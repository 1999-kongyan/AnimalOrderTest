package com.example.privilegepagetest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.privilegepagetest.R;

/**
 * @author kdy
 * create at $ $
 * @Params :$
 */
public class PrivilegePageFragment  extends Fragment {

    String title;

    private View view;


    public PrivilegePageFragment() {

    }


    public static PrivilegePageFragment newInstance(String title) {
        PrivilegePageFragment fragment = new PrivilegePageFragment();
        fragment.title = title;
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_privilege_page, container, false);
        return view;
    }

    public String getTitle() {
        return title;
    }


}
