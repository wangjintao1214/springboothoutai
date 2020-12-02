package com.kgc.movie.movie.service.impl;


import com.kgc.movie.movie.mapper.Membership_levelMapper;

import com.kgc.movie.movie.pojo.Membership_level;
import com.kgc.movie.movie.pojo.Membership_levelExample;
import com.kgc.movie.movie.service.Membership_levelService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
/*@CacheConfig(cacheManager = "employeeRedisCacheManager")*/
@Service
public class Membership_levelServiceimpl implements Membership_levelService {
    @Resource
    Membership_levelMapper membership_levelMapper;
    //会员等级查询
    //  @RequestMapping("/member-level.html")
    /*@Cacheable(value = {"member-level.html"})*/
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
            criteriae.andTypeLike("%"+type+"%");
            membership_levels=membership_levelMapper.selectByExample(membership_levelExample);
        }
        return membership_levels;
    }
    //    @RequestMapping("/member-list.html")
  /*  @Cacheable*/
    @Override
    public List<Membership_level> selectByExample(Membership_levelExample example) {
        return membership_levelMapper.selectByExample(example);
    }

}
