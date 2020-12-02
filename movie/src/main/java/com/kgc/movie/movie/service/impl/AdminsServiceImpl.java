package com.kgc.movie.movie.service.impl;

import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.mapper.AdminsMapper;
import com.kgc.movie.movie.pojo.Admins;
import com.kgc.movie.movie.pojo.AdminsExample;
import com.kgc.movie.movie.pojo.User;
import com.kgc.movie.movie.service.AdminsService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-12 9:16
 */
/*@CacheConfig(cacheManager = "employeeRedisCacheManager")*/
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
    //    @RequestMapping("/member-kiss.html")
    /*@Cacheable(value = {"member-kiss.html"})*/
    @Override
    public List<Admins> selectAllName(String name) {
        AdminsExample example=new AdminsExample();
        AdminsExample.Criteria criteria = example.createCriteria();
        List<Admins> adminsList;
        if(name==null){
            adminsList = adminsMapper.selectByExample(null);
        }else{
            criteria.andNameLike("%"+name+"%");
            adminsList = adminsMapper.selectByExample(example);
        }

        return adminsList;
    }

}
