package com.kgc.movie.movie.service;


import com.kgc.movie.movie.pojo.Membership_level;
import com.kgc.movie.movie.pojo.Membership_levelExample;

import java.util.List;

public interface Membership_levelService {
    //会员等级查询
    List<Membership_level> select(String type);

    List<Membership_level> selectByExample(Membership_levelExample example);
}
