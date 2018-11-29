package com.learn.roomlearn;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void addUser(User user);
    //method performs database insertion

    @Query("select * from `users`")
    public List<User> getAllUsers();
}
