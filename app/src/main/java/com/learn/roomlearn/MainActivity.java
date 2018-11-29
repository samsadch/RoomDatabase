package com.learn.roomlearn;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static AppDatabase appDatabase;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        appDatabase  = Room.databaseBuilder(context,AppDatabase.class,"userdb")
                .allowMainThreadQueries().build();
        fragmentManager=getSupportFragmentManager();
        if(findViewById(R.id.fragmentContainer)!=null){
            if(savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragmentContainer,new HomeFragment()).commit();
        }
    }
}
