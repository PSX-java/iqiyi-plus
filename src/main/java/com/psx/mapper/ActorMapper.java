package com.psx.mapper;

import com.psx.model.Actor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.psx.model.ActorRegion;
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
public interface ActorMapper extends BaseMapper<Actor> {

    // 查询演员列表
    public List<Actor> findAll();

    // 删除演员与区域关联记录的方法
    public void deleteActorAndRegion(int id);

//    // 删除演员
//    public void delete(int actorId);

    // 根据id查询
    public Actor findById(int id);

    // 保存演员与区域关联记录的方法
    public void saveActorAndRegion(ActorRegion aar);
}
