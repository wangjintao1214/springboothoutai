package com.kgc.movie.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.mapper.Membership_levelMapper;

import com.kgc.movie.movie.pojo.Membership_level;
import com.kgc.movie.movie.service.DevuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DevuserServiceImpl implements DevuserService {
/*@Resource
    DevuserMapper devuserMapper;
@Resource
    Membership_levelMapper membership_levelMapper;
    @Override
    public PageInfo<Devuser> select(Integer pageNum, Integer pageSize, Integer grade, String uname) {
        PageHelper.startPage(pageNum,pageSize);
        DevuserExample devuserExample=new DevuserExample();
        DevuserExample.Criteria criteriae=devuserExample.createCriteria();
        List<Devuser> devuser;
        if(uname==null){
            devuser=devuserMapper.selectByExample(null);
        }else
        if(grade==0){
            devuser=devuserMapper.selectByExample(null);
        }else{
            criteriae.andGradeEqualTo(grade);
            criteriae.andUnameLike(uname);
            devuser=devuserMapper.selectByExample(devuserExample);
        }
        for (Devuser devusers : devuser) {
            Membership_level membership_level = membership_levelMapper.selectByPrimaryKey(devusers.getGrade());
            devusers.setMembership_level(membership_level);
        }
        PageInfo<Devuser> devuserPageInfo=new PageInfo<>(devuser);
        return devuserPageInfo;
    }*/
}
