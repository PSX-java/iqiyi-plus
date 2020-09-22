package com.psx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class RecommendType extends Model {

    private int id;
    private String name;
    private boolean isrecommend;

}
