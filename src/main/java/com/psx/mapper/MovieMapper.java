package com.psx.mapper;

import com.psx.model.Movie;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.psx.model.MovieType;
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
public interface MovieMapper extends BaseMapper<Movie> {

    Movie findById(int movieId);

    public List<Movie> findAll();


    void deleteMovieAndtypes(int movieId);

    void deleteMovieAndActors(int movieId);

    void deleteById(int movieId);

    // 根据当前电影的类型查询出与该电影类型相同的最新的前3条电影
    List<Movie> findTop3ByCates(int movieId);

    // 根据当前电影的演员查询出与该电影演员相同的最新的前3条电影
    List<Movie> findTop3ByActors(int movieId);

    void update(Movie movie);

    public void insertMovieAndCategory(MovieType mac);
}
