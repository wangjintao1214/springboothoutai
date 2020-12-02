package com.kgc.movie.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.mapper.Membership_levelMapper;
import com.kgc.movie.movie.mapper.UserMapper;
import com.kgc.movie.movie.mapper.User_MemberMapper;
import com.kgc.movie.movie.pojo.*;
import com.kgc.movie.movie.service.Membership_levelService;
import com.kgc.movie.movie.service.User_MemberService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;
//    @RequestMapping("/member-list.html")
@Service
public class User_MemberServiceImpl implements User_MemberService {
    @Resource
    User_MemberMapper user_memberMapper;
   /* @Cacheable*/
    @Override
    public List<User_Member> selectByExample(User_MemberExample example) {
        return user_memberMapper.selectByExample(example);
    }

}
