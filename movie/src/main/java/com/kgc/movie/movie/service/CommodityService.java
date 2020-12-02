package com.kgc.movie.movie.service;

import com.kgc.movie.movie.pojo.Commodity;

import java.util.List;

public interface CommodityService {
    //查询所有商品
    List<Commodity> selectAll();
    //获取修改值
    Commodity getCommodity(Integer id);
    //修改商品
    int updateCommdity(Commodity commodity);
    //增加商品
    int addCommodity(Commodity commodity);
    //删除商品
    int del(Integer id);
}
