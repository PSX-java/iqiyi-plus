package com.psx.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
public class MovieActor extends Model {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer movieid;

    private Integer actorid;

    public MovieActor(int movieid, int actorid) {
        this.movieid = movieid;
        this.actorid = actorid;
    }


}
