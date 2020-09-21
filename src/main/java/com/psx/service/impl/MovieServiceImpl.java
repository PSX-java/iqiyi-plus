package com.psx.service.impl;

import com.psx.mapper.RecommendTypeMapper;
import com.psx.model.Movie;
import com.psx.mapper.MovieMapper;
import com.psx.model.MovieType;
import com.psx.model.RecommendType;
import com.psx.service.IMovieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements IMovieService {


    @Autowired
    private RecommendTypeMapper recommendTypeMapper;

    @Autowired
    private MovieMapper movieMapper;


    @Override
    public Movie findById(int movieId) {
        return movieMapper.findById(movieId);
    }

    @Override
    public List<Movie> findAll() {
        return movieMapper.findAll();
    }





    @Override
    public void deleteMovie(int movieId) {
        // 1.电影与类型的中间表的记录
        movieMapper.deleteMovieAndtypes(movieId);
        // 2.电影与演员的中间表的记录
        movieMapper.deleteMovieAndActors(movieId);
        // 3.电影表中的记录
        movieMapper.deleteById(movieId);
    }




    @Override
    public void update(Movie movie) {
        // 1.更新电影表
        movieMapper.update(movie);
        // 2.更新电影与类型的中间表的记录
        // 2.1.先删除中间表中的相关记录:根据电影的id删除记录
        movieMapper.deleteMovieAndtypes(movie.getId());

        // 2.2.在插入相关的记录:向中间表中插入新的记录
        // 页面上传递过来的电影存储在movie的categories中, 使用逗号连接起来的字符串: 1,3
        // 分割电影类型的id
        String type = movie.getTypes();
        // ["1", "3"]
        String[] types = type.split(",");
        for (String tid : types) {
            // 创建一个bean用来封装movieId和categoryId
            MovieType mac = new MovieType(movie.getId(),
                    Integer.parseInt(tid));
            movieMapper.insertMovieAndCategory(mac);
        }

    }






    /*
   电影 推荐列表:

    */
    @Override
    public List<Movie> recommendMovieList(int movieId) {
        // 1.查询电影
        Movie movie = movieMapper.findById(movieId);

        // 2.获取所有的推荐类型
        List<RecommendType> recommendList = recommendTypeMapper.findRecommendList();

        // 3. 定义一个list用来存储被推荐的电影
        List<Movie> recommendMovieList = new ArrayList<Movie>();
        // 用来存储被推荐的电影的id,不允许重复
        Set<Integer> recommendMovieIds = new HashSet<Integer>();
        // 3.遍历推荐类型
        for (RecommendType r : recommendList) {
            if(r.getId() == 1){
                // 表示按照 类型推荐
                // 按照电影的类型查询出最新的前3条电影
                List<Movie> top3ByCates = movieMapper.findTop3ByCates(movieId);
                // 添加到recommendMovieList中
                // recommendMovieList.addAll(top3ByCates);
                for (Movie m : top3ByCates) {
                    // 判断当前电影是否与已经推荐的
                    if(!recommendMovieIds.contains(m.getId())){
                        recommendMovieList.add(m);
                        recommendMovieIds.add(m.getId());
                    }

                }
            }else if (r.getId() == 2){
                // 表示按照演员
                // 按照电影的演员查询出最新的前3条电影
                List<Movie> top3ByActors =
                        movieMapper.findTop3ByActors(movieId);
                for (Movie m : top3ByActors) {
                    if(!recommendMovieIds.contains(m.getId())){
                        recommendMovieList.add(m);
                        recommendMovieIds.add(m.getId());
                    }
                }
            }else{
                // 按照花絮推荐
            }

        }

        return recommendMovieList;
    }
}
