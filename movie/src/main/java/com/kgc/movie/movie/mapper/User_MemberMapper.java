package com.kgc.movie.movie.mapper;

import com.kgc.movie.movie.pojo.User_Member;
import com.kgc.movie.movie.pojo.User_MemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User_MemberMapper {
    int countByExample(User_MemberExample example);

    int deleteByExample(User_MemberExample example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(User_Member record);

    int insertSelective(User_Member record);

    List<User_Member> selectByExample(User_MemberExample example);

    User_Member selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") User_Member record, @Param("example") User_MemberExample example);

    int updateByExample(@Param("record") User_Member record, @Param("example") User_MemberExample example);

    int updateByPrimaryKeySelective(User_Member record);

    int updateByPrimaryKey(User_Member record);
}