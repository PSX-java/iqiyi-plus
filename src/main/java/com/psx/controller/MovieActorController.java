package com.psx.controller;


import com.psx.mapper.MovieMapper;
import com.psx.model.Actor;
import com.psx.model.Movie;
import com.psx.service.IActorService;
import com.psx.service.IMovieActorService;
import com.psx.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
@RestController
@CrossOrigin
@RequestMapping("/movie-actor")
public class MovieActorController {
    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private IMovieActorService movieActorService;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private IActorService actorService;

    // 删除电影与演员
    @PostMapping("/delete")
    public String delete(int movieId){
       movieMapper.deleteById(movieId);
        return "删除成功";
    }

    // 添加电影与演员
    @PostMapping("/update")
    public String update(Movie movie){
        movieMapper.update(movie,null);
        return "提交成功";
    }

    // 添加电影与演员
    @PostMapping("/save")
    public String save(Movie movie){
        movieActorService.save(movie);
        return "提交成功";
    }


    @GetMapping("/edit")
    public Map<String, Object> editMovieAndActor(int movieId){

        /*
        1.2 接口的逻辑:
            根据电影的id查询出电影的数据: movie
            查询所有的电影: movieList
            查询出所有的演员: actorList
        */
        // 根据电影的id查询出电影的数据: movie
        Movie movie = movieMapper.findById(movieId);
        // 查询所有的电影: movieList
        List<Movie> movieList = movieMapper.findAll();
        // 查询出所有的演员: actorList
        List<Actor> actorList = actorService.findAll();

        /*1.3 返回的数据
        以上三个数据:
        movie, movieList, actorList
        定义一个map封装这三个数据,返回map*/
        Map<String, Object> map = new HashMap<>();
        map.put("movie", movie);
        map.put("movieList", movieList);
        map.put("actorList", actorList);

        return map;

    }
}
