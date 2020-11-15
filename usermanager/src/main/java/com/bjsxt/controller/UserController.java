package com.bjsxt.controller;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
      * @param users
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(Users users){
        this.userService.addUser(users);
        return "redirect:/ok";

    }

    /**
     * 根据查询id查询用户
     */
    @RequestMapping("/findUserById")
    public String showUser(Integer userid,Model model){
       Users users = userService.findUserByIn(userid);
       model.addAttribute("u", users);
        return "/showUser";
    }

    /**
     * 更新用户
     */
    @RequestMapping("/updateUser")
    public  String updateUser(Users users){
        userService.updateUser(users);
        return "redirect:/ok";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/del")
    public String deleteUser(Integer userid){
        userService.del(userid);
        return "redirect:/ok";
    }
}
