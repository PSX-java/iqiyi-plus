package com.psx.service.impl;

import com.psx.mapper.RecommendTypeMapper;
import com.psx.model.RecommendType;
import com.psx.service.IRecommendTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：psx
 * @date ：Created in 2020/9/21 10:03
 * @description：电影推荐service层
 * @modified By：
 * @version: $
 */
@Service
public class RecommendTypeServiceImpl implements IRecommendTypeService {

    @Autowired
    private RecommendTypeMapper recommendTypeMapper;

//    @Override
//    public List<RecommendType> findAll() {
//        return recommendTypeMapper.findAll();
//    }

    @Override
    public void nowRecommend(String ids) {

        // 先取消之前所有的推荐类型
        recommendTypeMapper.cancelRecommend();

        // 在设置现在推荐的类型: ["1", "2"]
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            recommendTypeMapper.nowRecommend(Integer.parseInt(id));
        }
    }
}
