package com.psx.service;

import com.psx.model.Movie;
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
public interface IMovieService extends IService<Movie> {

    Movie findById(int movieId);

    void deleteMovie(int movieId);

    void update(Movie movie);

    public List<Movie> findAll();

    List<Movie> recommendMovieList(int movieId);
}
