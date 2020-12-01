package com.kgc.movie.movie.service;

import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.pojo.Movie_ticket;

import java.util.Map;

/**
 * @author wangyifan
 * @create 2020-11-12 20:09
 */
public interface SaleService {
    //查询所有
    //PageInfo<Movie_ticket> showList(Integer pagenum, Date startData, Date endDate);
    PageInfo<Movie_ticket> showList(Integer pagenum, String startData, String endDate);

    //查询每部电影都有多少销售额
    Map selectByMovieYingchengId();//电影名和电影售卖值

    //根据每天不同电影显示售卖值
    //List showMovieInfoByDay();//分页展示
    PageInfo showMovieInfoByDay(Integer pagenum,Integer pageSize);

  //  List<Movie_ticket>selectAll();
}