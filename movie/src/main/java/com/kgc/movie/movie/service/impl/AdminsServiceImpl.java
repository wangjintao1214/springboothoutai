package com.kgc.movie.movie.service.impl;

import com.kgc.movie.movie.mapper.AdminsMapper;
import com.kgc.movie.movie.pojo.Admins;
import com.kgc.movie.movie.pojo.AdminsExample;
import com.kgc.movie.movie.service.AdminsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-12 9:16
 */
@Service
public class AdminsServiceImpl implements AdminsService{
    @Resource
    AdminsMapper adminsMapper;


    @Override
    public Admins selectByName(String name) {
        Admins admins=null;
        AdminsExample example=new AdminsExample();
        AdminsExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<Admins> admins1 = adminsMapper.selectByExample(example);
        if(admins1.size()!=0&&admins1!=null){
            admins=admins1.get(0);
        }
        return admins;
    }
}
