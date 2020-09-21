package com.psx.mapper;

import com.psx.model.MovieActor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
@Repository
public interface MovieActorMapper extends BaseMapper<MovieActor> {

    public void save(MovieActor maa);
}
