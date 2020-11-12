package com.kgc.movie.movie.service;

import com.kgc.movie.movie.pojo.Admins;

/**
 * @author shkstart
 * @create 2020-11-12 9:16
 */
public interface AdminsService {
    Admins selectByName(String name);
}
