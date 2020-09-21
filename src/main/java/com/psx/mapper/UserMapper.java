package com.psx.mapper;

import com.psx.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    public List<User> findAllUser();

}
