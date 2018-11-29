package com.learn.roomlearn;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface UserDao {

    @Insert
    public void addUser(User user);
    //method performs database insertion
}
