package com.psx.service.impl;

import com.psx.model.User;
import com.psx.mapper.UserMapper;
import com.psx.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }

    @Override
    public String saveUser(User user) {
        userMapper.saveUser(user);
        return "数据已添加";
    }
//
//    public String update(User user){
//        userMapper.update(user,null);
//        return "修改成功";
//    }
}
