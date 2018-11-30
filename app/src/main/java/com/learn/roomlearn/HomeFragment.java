package com.learn.roomlearn;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button addButton,readButton,editButton,deleteButton;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        addButton = view.findViewById(R.id.addButton);
        readButton = view.findViewById(R.id.viewButton);
        view.findViewById(R.id.deleteButton).setOnClickListener(this);
        view.findViewById(R.id.updateButton).setOnClickListener(this);
        readButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.addButton:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer,new AddUserFragment())
                        .addToBackStack("").commit();
            break;
            case R.id.viewButton:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer,new ViewDataFragment())
                        .addToBackStack("").commit();
                break;
            case R.id.deleteButton:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer,new DeleteFragment())
                        .addToBackStack("").commit();
                break;
            case R.id.updateButton:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer,new UpdateFragment())
                        .addToBackStack("").commit();
                break;
        }
    }
}
