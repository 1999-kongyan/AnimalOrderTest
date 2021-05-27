package com.example.privilegepagetest.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.privilegepagetest.R;
import com.example.privilegepagetest.adapter.AnimalOrderAdapter;
import com.example.privilegepagetest.adapter.LandOrderAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LandOrderActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> datas;
    private View view;
    private Context mContext;
    private LandOrderAdapter mLandOrderAdapter;


    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1) {
                datas = (List<String>) msg.obj;
            }
            init();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_order);
        mRecyclerView = (RecyclerView) findViewById(R.id.rc_land_order);

        getLandOrder();
    }

    private void init() {
        mContext =this;
        mLandOrderAdapter = new LandOrderAdapter(mContext,datas);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 1));
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext,
//                DividerItemDecoration.HORIZONTAL));

        mRecyclerView.setAdapter(mLandOrderAdapter);

    }

    private void getLandOrder() {
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("东北黑土地"+i);
        }
        Message msg = Message.obtain();
        msg.what = 1;
        msg.obj = list;
        //4、发送消息
        handler.sendMessage(msg);
    }
}