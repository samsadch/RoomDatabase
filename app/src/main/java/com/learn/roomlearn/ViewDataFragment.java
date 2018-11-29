package com.learn.roomlearn;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ViewDataFragment extends Fragment {

    private TextView userDataTxv;

    public ViewDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_data, container, false);
        userDataTxv =  (TextView) view.findViewById(R.id.userData);
        List<User> list = MainActivity.appDatabase.getUserDao().getAllUsers();
        String  info  = null;
        for (User user  : list){
            info = info+"\n\n"+user.toString();
        }
        userDataTxv.setText(info);
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
