package com.bjsxt.service.impl;

import com.bjsxt.commons.JsonUtils;
import com.bjsxt.jedisdao.JedisDao;
import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private JedisPool jedisPool;


    @Value("${REDIS_USERS_PRIFX}")//解析properties文件
     private  String REDIS_USERS_PRIFX;

    @Override
    public void addUser(Users users) {
        this.usersMapper.insert(users);
    }

    @Override
    public Users findUserByIn(Integer userid) {
       try{
           //查询缓存
           Jedis jedis =this.jedisPool.getResource();
           //返回jason字符串
           String json =jedis.get(this.REDIS_USERS_PRIFX+":"+userid);//:前缀+：+key作为缓存的一部分
           //在缓存中是否命中
           if (json!=null&&json.length()>0){
               Users user = JsonUtils.jsonToPojo(json, Users.class);
               return user;
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        //查询数据库
        Users user =usersMapper.selectByPrimaryKey(userid);
       try {
           //放入redis中
           String res = JsonUtils.objectToJson(user);
           this.jedisPool.getResource().set(this.REDIS_USERS_PRIFX+":"+userid,res);
           this.jedisPool.getResource().expire(this.REDIS_USERS_PRIFX+":"+userid, 10);//失效时间10s
       }catch (Exception e){
           e.printStackTrace();
       }

        return user;
    }

    @Override
    public void updateUser(Users users) {
        this.usersMapper.updateByPrimaryKey(users);
        //同步redis,删除原来已更新的数据
       try {
           this.jedisPool.getResource().del(this.REDIS_USERS_PRIFX +":"+ users.getUserid());
       }catch (Exception e){
           e.printStackTrace();
       }

    }

    @Override
    public void del(Integer userid) {
        usersMapper.deleteByPrimaryKey(userid);

        try {
            this.jedisPool.getResource().del(this.REDIS_USERS_PRIFX +":"+ userid);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
