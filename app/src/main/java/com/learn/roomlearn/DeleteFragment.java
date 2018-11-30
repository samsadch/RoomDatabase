package com.learn.roomlearn;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteFragment extends Fragment {

    private Button deleteButton;
    private EditText idEdit;


    public DeleteFragment() {
        // Required empty public constructor
    }


    public static DeleteFragment newInstance(String param1, String param2) {
        DeleteFragment fragment = new DeleteFragment();
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
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        deleteButton = view.findViewById(R.id.deleteButton);
        idEdit = view.findViewById(R.id.editText);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer id = Integer.valueOf(idEdit.getText().toString());
                User user = new User(id,"","");
                MainActivity.appDatabase.getUserDao().deleteUser(user);
                Toast.makeText(getContext(),"Deleted user..",Toast.LENGTH_LONG).show();
                idEdit.setText("");

            }
        });
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

}
