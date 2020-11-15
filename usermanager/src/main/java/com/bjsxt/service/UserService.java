package com.bjsxt.service;

import com.bjsxt.pojo.Users;

public interface UserService {

    void addUser(Users users);

    Users findUserByIn(Integer id);

    void updateUser(Users users);

    void del(Integer userid);
}
