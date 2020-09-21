package com.psx.controller;


import com.psx.mapper.MovieMapper;
import com.psx.mapper.TypeMapper;
import com.psx.model.Movie;
import com.psx.model.Type;
import com.psx.service.IMovieService;
import com.psx.utils.FileLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private MovieMapper movieMapper;

    @Value("${upload.dir}")
    private String uploadDir;


    // 播放电影的接口: 需要返回当前电影的信息和推荐列表
    @GetMapping("/playMovie")
    public Map<String, Object> playMovie(int movieId){
        // 得到当前电影
        Movie movie = movieService.findById(movieId);
        // 得到被推荐的电影列表
        List<Movie> recommendMovieList = recommendMovieList(movieId);
        // 定义一个map用来封装movie和recommendMovieList,把它们一起返回到页面
        Map<String, Object> map = new HashMap<>();
        map.put("movie", movie);
        map.put("recommendMovieList", recommendMovieList);
        return map;
    }

    // 电影推荐列表接口
    public List<Movie> recommendMovieList(int movieId){
        return  movieService.recommendMovieList(movieId);
    }

    // 查询电影列表
    @GetMapping("/findAll")
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    // 添加电影
    @PostMapping(value="/save")
    public String save(@RequestParam(value = "file") MultipartFile file,
                       Movie movie){

        // 2.把pic文件中数据写到 新的文件中
        try{
            if(file != null){
                // 把图片转成base64编码的字符串
                String base64Str = Base64.encodeBase64String(file.getBytes());
                // 把base64编码的字符串保存到对象中, 会插入到表的pic字段中
                movie.setMoviecover(base64Str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("controller movie = " + movie);
        movieService.save(movie);

        // 上传缩略图
        FileLoad.uploadFile(file, uploadDir);

        return "提交成功!";
    }


    @GetMapping("/editMovie")
    public Map<String, Object> editMovie(int movieId){
        // 1.得到 这个电影的基本信息
        Movie movie = movieService.findById(movieId);
        // 2.所有的电影类型
        List<Type> typeList = typeMapper.selectList(null);
        // 3.定义一个map用来封装返回的数据
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("movie", movie);
        dataMap.put("allTypeList", typeList);
        return dataMap;
    }


    @PostMapping("/deleteMovie")
    /*
     原来是这样定义的,movieId是int类型
     由于前端传递参数时是一个json对象,所以服务端接收时也应该使用Movie对象接受.
     由于前段使用的是Post请求,参数都是封装在requestbody中的,所有服务应该从
     requestbody中取数据,所以在参数前加@RequestBody注解
     */
    // public String deleteMovie( int movieId){
    public String deleteMovie(@RequestBody Movie movie){
        //删除这个电影相关的数据:有三部分相关的数据:在movieService的deleteMovie中删除这三部分数据
        movieService.deleteMovie(movie.getId());
        return "删除成功";
    }


    @PostMapping("/updateMovie")
    public String updateMovie(@RequestParam(value = "file") MultipartFile file,
                              Movie movie){
        System.out.println("updateMovie");


        // 1.在数据库中更新这个电影的记录
        if(file != null){
            //1.1在服务器上创建一个新的文件
            System.out.println("uploadDir : " + uploadDir);
            // E://movie/images/2010-09-09/dsfjkdsjfkdsl.jpg
            // 1.1创建日期目录
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dir = sdf.format(new Date());

            //1.2 创建目录 E://movie/images/2010-09-09
            // 创建文件名
            System.out.println(" dir = " + dir);
            File parentDir = new File(uploadDir, dir);
            if(!parentDir.exists()){
                parentDir.mkdirs();
            }

            // 1.3得到上传文件的扩展名
            // 1.3.1 得到上传的文件的名字: 1.abc.jpg
            String uuid = UUID.randomUUID().toString();
            // 得到文件原来的名字
            String originalFilename = file.getOriginalFilename();
            // 得到扩展名
            int index = originalFilename.lastIndexOf(".");
            String fileExter = originalFilename.substring(index);
            // 新的文件名: uuid + fileExter
            String fileName = uuid + fileExter;
            // 创建新文件
            File newFile = new File(parentDir, fileName);

            // 2.把pic文件中数据写到 新的文件中
            try {
                // 把图片转成base64编码的字符串
                String base64Str = Base64.encodeBase64String(file.getBytes());
                // 把base64编码的字符串保存到对象中, 会插入到表的pic字段中
                movie.setMoviecover(base64Str);

                // 把图片的数据写到新文件中
                file.transferTo(newFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("controller movie = " + movie);
        movieService.update(movie);
        return "提交成功!";
    }


}
