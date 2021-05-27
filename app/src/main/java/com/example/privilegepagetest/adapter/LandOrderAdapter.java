package com.example.privilegepagetest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.privilegepagetest.R;

import java.util.List;
import java.util.Random;

/**
 * @author kdy
 * create at $ $
 * @Params :$
 */
public class LandOrderAdapter extends RecyclerView.Adapter<LandOrderAdapter.MyLandOrderHolder>{
    private Context mContext;
    private List<String> mList;


    public LandOrderAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;

    }


    @NonNull
    @Override
    public MyLandOrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_order_land, parent, false);
        return new LandOrderAdapter.MyLandOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyLandOrderHolder holder, int position) {

        holder.setData((String) mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    class MyLandOrderHolder extends RecyclerView.ViewHolder {

        private TextView tv_order_land_name;//土地名称
        private TextView tv_land_cycle;//租赁时间
        private TextView tv_land_area;//土地面积

        public MyLandOrderHolder(View itemView) {
            super(itemView);
            tv_order_land_name = (TextView) itemView.findViewById(R.id.tv_order_land_name);
            tv_land_cycle = (TextView) itemView.findViewById(R.id.tv_land_cycle);
            tv_land_area = (TextView) itemView.findViewById(R.id.tv_land_area);

        }


        public void setData(String str ) {
            tv_order_land_name.setText(str);


        }


    }
}
