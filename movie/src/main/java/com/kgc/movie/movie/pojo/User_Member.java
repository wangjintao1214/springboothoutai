package com.kgc.movie.movie.pojo;

import java.io.Serializable;

public class User_Member /*implements Serializable*/ {
    private Integer memberId;

    private Integer userId;
    private User user;
    private Membership_level membership_level;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Membership_level getMembership_level() {
        return membership_level;
    }

    public void setMembership_level(Membership_level membership_level) {
        this.membership_level = membership_level;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}