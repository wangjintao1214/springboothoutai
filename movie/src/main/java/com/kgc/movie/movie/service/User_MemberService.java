package com.kgc.movie.movie.service;

import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.pojo.User_Member;
import com.kgc.movie.movie.pojo.User_MemberExample;

import java.util.List;

public interface User_MemberService {
    List<User_Member> selectByExample(User_MemberExample example);
}
