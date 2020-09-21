package com.psx.service.impl;

import com.psx.model.Actor;
import com.psx.mapper.ActorMapper;
import com.psx.model.ActorRegion;
import com.psx.service.IActorService;
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
public class ActorServiceImpl extends ServiceImpl<ActorMapper, Actor> implements IActorService {

    @Autowired
    private ActorMapper actorMapper;

    @Override
    public List<Actor> findAll() {
        return actorMapper.findAll();
    }

    @Override
    public void delete(int actorId) {
        // 2.1根据演员的id从 演员与区域的中间表中删除相关的记录
        actorMapper.deleteActorAndRegion(actorId);
        // 2.2根据演员的id从演员表中删除记录
        actorMapper.delete(null);
    }

    @Override
    public Actor findById(int id) {
        return actorMapper.findById(id);
    }

    @Override
    public boolean save(Actor actor) {
        /*
        保存演员信息:
            3.1 演员的基本信息:在演员表中插入一条记录
            3.2 在演员与区域中间表中插入记录
         */
        //  3.1 演员的基本信息:在演员表中插入一条记录
        actorMapper.update(actor,null);
        // 在演员与区域中间表中插入记录
        insertActorAndRegion(actor);

        return false;
    }

    // 在演员与区域中间表中插入记录
    private void insertActorAndRegion(Actor actor) {
        //  3.2 在演员与区域中间表中插入记录
        // 得到演员的id
        int aid = actor.getId();
        // 得到所有区域ID
        String regionsStr = actor.getRegionsStr();
        // 拆分区域ID
        String[] idArray = regionsStr.split(",");
        // 遍历出每个区域id
        for (String rid : idArray) {
            ActorRegion aar = new ActorRegion(aid, Integer.parseInt(rid));
            actorMapper.saveActorAndRegion(aar);
        }
    }
}
