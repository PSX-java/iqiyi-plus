package com.psx.service;

import com.psx.model.Actor;
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
public interface IActorService extends IService<Actor> {


    // 根据id查询
    public Actor findById(int id);


    // 查询演员列表
    public List<Actor> findAll();
    // 删除一条记录
    public void delete(int actorId);
}
