package com.psx.service;

import com.psx.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
public interface IUserService extends IService<User> {

        public List<User> findAllUser();

//        String update(User user);

        String saveUser(User user);
}
