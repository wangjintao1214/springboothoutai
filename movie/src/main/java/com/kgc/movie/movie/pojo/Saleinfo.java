package com.kgc.movie.movie.pojo;

import java.util.Date;

/**
 * @author wangyifan
 * @create 2020-11-15 18:03
 */
public class Saleinfo {
    private  int id;
    private Date saleDate;//时间
    private String MovieName;//电影名

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    private int saleMoney;//销售值

    @Override
    public String toString() {
        return "Saleinfo{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", MovieName='" + MovieName + '\'' +
                ", saleMoney=" + saleMoney +
                '}';
    }

    public Saleinfo(int id, Date saleDate, String movieName, int saleMoney) {
        this.id = id;
        this.saleDate = saleDate;
        MovieName = movieName;
        this.saleMoney = saleMoney;
    }

    public Saleinfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(int saleMoney) {
        this.saleMoney = saleMoney;
    }
}
