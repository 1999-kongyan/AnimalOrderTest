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

/**
 * @author kdy
 * create at $ $
 * @Params :$
 */
public class AnimalOrderAdapter extends RecyclerView.Adapter<AnimalOrderAdapter.MyAnimalOrderHolder>  {
    private Context mContext;
    private List<String> mList;
    private String mtitle;

    public AnimalOrderAdapter(Context context, List<String> list,String title) {
        mContext = context;
        mList = list;
        mtitle = title;
    }


    @NonNull
    @Override
    public MyAnimalOrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_order_animal, parent, false);
        return new MyAnimalOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAnimalOrderHolder holder, int position) {
        holder.setData((String) mList.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    class MyAnimalOrderHolder extends RecyclerView.ViewHolder {
        private TextView tv_order_animal_name;
        private TextView tv_order_time;
        private TextView tv_animal_desc;


        public MyAnimalOrderHolder(View itemView) {
            super(itemView);
            tv_order_animal_name = (TextView) itemView.findViewById(R.id.tv_order_animal_name);
            tv_order_time = (TextView) itemView.findViewById(R.id.tv_order_time);
            tv_animal_desc = (TextView) itemView.findViewById(R.id.tv_animal_desc);

        }


        public void setData(String str ) {
            tv_order_animal_name.setText(str);
            if(mtitle == "认养成功"){
                tv_animal_desc.setText("认养成功，请耐心等待");
            }
            if(mtitle == "成长中"){
                tv_animal_desc.setText("动物正在加紧成长，请耐心等待");
            }
            if(mtitle == "已收获"){
                tv_animal_desc.setText("动物已经收获成功，请耐心等待");
            }


        }


    }


}