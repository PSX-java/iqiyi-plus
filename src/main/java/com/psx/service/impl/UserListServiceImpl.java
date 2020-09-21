package com.psx.service.impl;

import com.psx.model.UserList;
import com.psx.mapper.UserListMapper;
import com.psx.service.IUserListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
@Service
public class UserListServiceImpl extends ServiceImpl<UserListMapper, UserList> implements IUserListService {

}
