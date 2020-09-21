package com.psx.service.impl;

import com.psx.model.MovieType;
import com.psx.mapper.MovieTypeMapper;
import com.psx.service.IMovieTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
@Service
public class MovieTypeServiceImpl extends ServiceImpl<MovieTypeMapper, MovieType> implements IMovieTypeService {

}
