package com.kgc.movie.movie.service.impl;

import com.kgc.movie.movie.mapper.CommodityMapper;
import com.kgc.movie.movie.pojo.Commodity;
import com.kgc.movie.movie.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    CommodityMapper commodityMapper;

    @Override
    public List<Commodity> selectAll() {
        return commodityMapper.selectByExample(null);
    }

    @Override
    public Commodity getCommodity(Integer id) {
        return commodityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateCommdity(Commodity commodity) {
        return  commodityMapper.updateByPrimaryKeySelective(commodity);
    }

    @Override
    public int addCommodity(Commodity commodity) {
        return commodityMapper.insertSelective(commodity);
    }

    @Override
    public int del(Integer id) {
        return commodityMapper.deleteByPrimaryKey(id);
    }


}
