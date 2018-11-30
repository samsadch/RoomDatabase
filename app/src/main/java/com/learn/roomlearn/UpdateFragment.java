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
import android.widget.Toast;


public class UpdateFragment extends Fragment {

    private EditText nameEdt,idEdt,mailEdt;
    private String name,mail;
    private int id;
    private Button updateButton;

    public UpdateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        idEdt = (EditText) view.findViewById(R.id.editText4);
        nameEdt = (EditText) view.findViewById(R.id.nameEdt);
        mailEdt = (EditText) view.findViewById(R.id.emailEdt);
        updateButton = (Button) view.findViewById(R.id.editButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameEdt.getText().toString();
                id = Integer.parseInt(idEdt.getText().toString());
                mail = mailEdt.getText().toString();
                User user = new User(id,name,mail);
                MainActivity.appDatabase.getUserDao().updateUser(user);
                Toast.makeText(getContext(),"Updated successfully",Toast.LENGTH_LONG).show();
                nameEdt.setText("");
                idEdt.setText("");
                mailEdt.setText("");
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
