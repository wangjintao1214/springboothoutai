package com.kgc.movie.movie.service.impl;


import com.kgc.movie.movie.mapper.Membership_levelMapper;

import com.kgc.movie.movie.pojo.Membership_level;
import com.kgc.movie.movie.pojo.Membership_levelExample;
import com.kgc.movie.movie.service.Membership_levelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Membership_levelServiceimpl implements Membership_levelService {
    @Resource
    Membership_levelMapper membership_levelMapper;
    //会员等级查询
    @Override
    public List<Membership_level> select(String type) {
        Membership_levelExample membership_levelExample=new Membership_levelExample();
        Membership_levelExample.Criteria criteriae=membership_levelExample.createCriteria();
        List<Membership_level> membership_levels;
        if(type==null){
            membership_levels=membership_levelMapper.selectByExample(null);
        }else if(type==" "){
            membership_levels=membership_levelMapper.selectByExample(null);
        }else{
            criteriae.andTypeLike(type);
            membership_levels=membership_levelMapper.selectByExample(membership_levelExample);
        }
        return membership_levels;
    }

    @Override
    public void insert(Membership_level membership_level) {
        membership_levelMapper.insert(membership_level);
    }


    @Override
    public Membership_level slectById(Integer levelId) {
        Membership_level membership_level = membership_levelMapper.selectByPrimaryKey(levelId);
        return membership_level;
    }

    @Override
    public void meberlevlupd(Membership_level membership_level) {
        membership_levelMapper.updateByPrimaryKeySelective(membership_level);
    }


}
