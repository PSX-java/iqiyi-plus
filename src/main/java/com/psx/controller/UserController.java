package com.psx.controller;


import com.psx.model.User;
import com.psx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @PostMapping("/getUser")
    public User getUser(){
        return userService.getById(1);
    }

    @PostMapping("/findAllUser")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }
}