package com.psx.service;

import com.psx.model.Region;
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
public interface IRegionService extends IService<Region> {

    public List<Region> findAll();
}
