package com.psx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.psx.model.Movie;
import com.psx.model.RecommendType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendTypeMapper extends BaseMapper<Movie> {

    // 查询所有选中的推荐类型
    public List<RecommendType> findRecommendList();

    // 修改成被推荐的类型
    public void nowRecommend(int id);

    // 取消所有已经被推荐的类型
    public void cancelRecommend();

    // 查询所有推荐类型
    List<RecommendType> findAll();
}
