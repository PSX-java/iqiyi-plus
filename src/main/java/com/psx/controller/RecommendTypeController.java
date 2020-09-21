package com.psx.controller;

import com.psx.model.RecommendType;
import com.psx.service.IRecommendTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：psx
 * @date ：Created in 2020/9/21 9:59
 * @description：电影推荐controller
 * @modified By：
 * @version: $
 */
@RestController
@CrossOrigin
@RequestMapping("recommendType")
public class RecommendTypeController {
    @Autowired
    private IRecommendTypeService recommendTypeService;

    @GetMapping("findAll")
    public List<RecommendType> findAll(){
        return recommendTypeService.findAll();
    }

    @GetMapping("nowRecommend")
    public String nowRecommend(String ids){
        // "1,2"
        recommendTypeService.nowRecommend(ids);
        return "提交成功";
    }
}
