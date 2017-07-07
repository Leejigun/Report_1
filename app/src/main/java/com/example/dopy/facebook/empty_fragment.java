package com.example.dopy.facebook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dopy.facebook.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class empty_fragment extends Fragment {


    public empty_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empty_fragment, container, false);
    }

    public static empty_fragment newInstance(){
        Bundle args=new Bundle();
        empty_fragment fragment=new empty_fragment();
        fragment.setArguments(args);
        return fragment;
    }
}
