package com.example.privilegepagetest.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.privilegepagetest.R;
import com.example.privilegepagetest.adapter.AnimalOrderAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author kdy
 * create at $ $
 * @Params :$
 */
public class AnimalOrderFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private AnimalOrderAdapter mAnimalOrderAdapter;

    String title;

    private List<String> datas;

    private View view;
    private Context mContext;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1) {
                datas = (List<String>) msg.obj;
            }
            init(view);
        }
    };


    public AnimalOrderFragment() {

    }


    public static AnimalOrderFragment newInstance(String title,Context context) {
        AnimalOrderFragment fragment = new AnimalOrderFragment();
        fragment.title = title;
        fragment.mContext = context;
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_animal_order, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rc_animal_order);

        getAnimalOrder();

        return view;
    }




    public String getTitle() {
        return title;
    }


    private void init(View view) {
        mAnimalOrderAdapter = new AnimalOrderAdapter(mContext, datas,title);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.HORIZONTAL));

        mRecyclerView.setAdapter(mAnimalOrderAdapter);
    }


    private void getAnimalOrder() {
        final List<String> list = new ArrayList<>();
        final int temp =new Random().nextInt( 6 ); ;
        for (int i = 0; i < temp; i++) {
            list.add("农家土鸡"+i);
        }
        Message msg = Message.obtain();
        msg.what = 1;
        msg.obj = list;
        //4、发送消息
        handler.sendMessage(msg);

    }

}
