package com.kgc.movie.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.mapper.Membership_levelMapper;
import com.kgc.movie.movie.mapper.UserMapper;
import com.kgc.movie.movie.mapper.User_MemberMapper;
import com.kgc.movie.movie.pojo.*;
import com.kgc.movie.movie.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/*@CacheConfig(cacheNames = "member-list.html",cacheManager = "employeeRedisCacheManager")*/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    /*@Cacheable*/
    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }




}
