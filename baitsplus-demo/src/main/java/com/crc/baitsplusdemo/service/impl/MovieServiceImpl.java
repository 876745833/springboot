package com.crc.baitsplusdemo.service.impl;

import com.crc.baitsplusdemo.entity.Movie;
import com.crc.baitsplusdemo.mapper.MovieMapper;
import com.crc.baitsplusdemo.service.MovieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author crc
 * @since 2020-06-03
 */
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

}
