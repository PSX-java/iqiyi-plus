package com.psx.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Movie extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String mviename;

    private String director;

    private Integer movietime;

    private String moviedes;

    private String moviecover;

    private Date releaseDate;

    private String movieStars;


    // 在电影与演员的编辑界面,选中的多个演员的id,比如: "1,3,4"
    private String actorIds;

    // 一个电影会有多个演员,一对多的关系
    private List<Actor> actors;
    // 一个电影有多个类型,一对多的关系
    // private String categories;
    private String types;
    private List<Type> typeList;
}
