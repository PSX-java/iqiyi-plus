package com.psx.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.extension.activerecord.Model;
/**
 * @author ：psx
 * @date ：Created in 2020/9/21 9:36
 * @description：电影推荐
 * @modified By：
 * @version: $
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RecommendType extends Model {

    private int id;
    private String name;
    private boolean isrecommend;

}
