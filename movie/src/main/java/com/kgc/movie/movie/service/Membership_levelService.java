package com.kgc.movie.movie.service;


import com.kgc.movie.movie.pojo.Membership_level;

import java.util.List;

public interface Membership_levelService {
    //会员等级查询
    List<Membership_level> select(String type);

    void insert(Membership_level membership_level);


    Membership_level slectById(Integer levelId);

    void meberlevlupd(Membership_level membership_level);
}
