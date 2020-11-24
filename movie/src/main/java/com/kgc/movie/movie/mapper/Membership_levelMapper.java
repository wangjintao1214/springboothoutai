package com.kgc.movie.movie.mapper;

import com.kgc.movie.movie.pojo.Membership_level;
import com.kgc.movie.movie.pojo.Membership_levelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Membership_levelMapper {
    int countByExample(Membership_levelExample example);

    int deleteByExample(Membership_levelExample example);

    int deleteByPrimaryKey(Integer levelId);

    int insert(Membership_level record);

    int insertSelective(Membership_level record);

    List<Membership_level> selectByExample(Membership_levelExample example);

    Membership_level selectByPrimaryKey(Integer levelId);

    int updateByExampleSelective(@Param("record") Membership_level record, @Param("example") Membership_levelExample example);

    int updateByExample(@Param("record") Membership_level record, @Param("example") Membership_levelExample example);

    int updateByPrimaryKeySelective(Membership_level record);

    int updateByPrimaryKey(Membership_level record);
}