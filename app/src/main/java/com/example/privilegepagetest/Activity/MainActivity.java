package com.example.privilegepagetest.Activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.privilegepagetest.R;
import com.hjq.toast.ToastUtils;
import com.hjq.toast.style.BlackToastStyle;

/**
 * @author kdy
 * create at $ $
 * @Params :$
 */
public class MainActivity extends AppCompatActivity {
    private Button AnimalOrder;
    private Button LandOrder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnimalOrder = (Button) findViewById(R.id.button_1);
        LandOrder = (Button) findViewById(R.id.button_2);

        ToastUtils.init(this.getApplication());

        AnimalOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.setStyle(new BlackToastStyle());
                ToastUtils.show("AnimalOrder\n1111111\n222222222\n33333333");


                Intent intent = new Intent(MainActivity.this, AnimalOrderActivity.class);
                startActivity(intent);
            }
        });
        LandOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("LandOrder\n1111111\n222222222\n33333333");
                Intent intent = new Intent(MainActivity.this, LandOrderActivity.class);
                startActivity(intent);
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);

    }
}
