package com.psx.service;

import com.psx.model.Movie;
import com.psx.model.MovieActor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
public interface IMovieActorService extends IService<MovieActor> {

    public void save(Movie movie);
}
