package com.learn.roomlearn;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddUserFragment extends Fragment {

    private String userName,email;
    private Integer id;
    private Button saveButton;
    private EditText nameEdt,mailEdt,idEdt;


    public AddUserFragment() {
        // Required empty public constructor
    }

    public static AddUserFragment newInstance(String param1, String param2) {
        AddUserFragment fragment = new AddUserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        saveButton = view.findViewById(R.id.saveButtom);
        nameEdt = view.findViewById(R.id.nameEditText);
        mailEdt = view.findViewById(R.id.emailEditText);
        idEdt = view.findViewById(R.id.idEditText);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    userName = nameEdt.getText().toString();
                    email = mailEdt.getText().toString();
                    id = Integer.valueOf(idEdt.getText().toString());
                    User user = new User(id, userName, email);
                    MainActivity.appDatabase.getUserDao().addUser(user);
                    Toast.makeText(getContext(), "Succesfully added user", Toast.LENGTH_LONG).show();
                    idEdt.setText("");
                    mailEdt.setText("");
                    nameEdt.setText("");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
