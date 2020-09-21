package com.psx.service.impl;

import com.psx.model.Movie;
import com.psx.model.MovieActor;
import com.psx.mapper.MovieActorMapper;
import com.psx.service.IMovieActorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MovieActorServiceImpl extends ServiceImpl<MovieActorMapper, MovieActor> implements IMovieActorService {


    @Autowired
    private MovieActorMapper movieActorMapper;


    @Override
    public void save(Movie movie) {
        // 1.得到电影的id
        int mid = movie.getId();
        // 2.得到所有的演员的id
        String actorIds = movie.getActorIds();
        // 解析出每个演员id
        String[] actorIdArray = actorIds.split(",");
        // 遍历出每个演员的id
        for (String actorId :actorIdArray) {
            MovieActor maa = new MovieActor(mid,
                    Integer.parseInt(actorId));
            // 向中间表中保存记录
            movieActorMapper.save(maa);
        }
    }
}
