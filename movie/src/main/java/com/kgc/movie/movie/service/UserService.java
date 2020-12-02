package com.kgc.movie.movie.service;

import com.github.pagehelper.PageInfo;
import com.kgc.movie.movie.pojo.*;

import java.util.List;

public interface UserService {

    List<User> selectByExample(UserExample example);


}
