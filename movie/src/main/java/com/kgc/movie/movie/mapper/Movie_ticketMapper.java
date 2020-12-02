package com.kgc.movie.movie.mapper;

import com.kgc.movie.movie.pojo.Movie_ticket;
import com.kgc.movie.movie.pojo.Movie_ticketExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Movie_ticketMapper {
    int countByExample(Movie_ticketExample example);

    int deleteByExample(Movie_ticketExample example);

    int deleteByPrimaryKey(Integer movieId);

    int insert(Movie_ticket record);

    int insertSelective(Movie_ticket record);

    List<Movie_ticket> selectByExample(Movie_ticketExample example);

    Movie_ticket selectByPrimaryKey(Integer movieId);

    int updateByExampleSelective(@Param("record") Movie_ticket record, @Param("example") Movie_ticketExample example);

    int updateByExample(@Param("record") Movie_ticket record, @Param("example") Movie_ticketExample example);

    int updateByPrimaryKeySelective(Movie_ticket record);

    int updateByPrimaryKey(Movie_ticket record);
}