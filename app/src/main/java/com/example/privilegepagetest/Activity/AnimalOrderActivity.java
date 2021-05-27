package com.example.privilegepagetest.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.privilegepagetest.R;
import com.example.privilegepagetest.fragment.AnimalOrderFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AnimalOrderActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;



    private String[] titles = new String[]{"认养成功","成长中","已收获"};//托管类型

    private List<AnimalOrderFragment> pageFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_order);

        viewPager = (ViewPager) findViewById(R.id.privilege_viewPager);
        tabLayout = (TabLayout) findViewById(R.id.privilege_tabLayout);
        initViewPager();
        initTabNormal();
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {

        return super.onCreateView(parent, name, context, attrs);
    }


    /**
     * 初始化ViewPager，方便后期与tabLayout关联
     */
    private void initViewPager() {

        pageFragment = new ArrayList<>();

        for (int i = 0; i < titles.length; i++) {

            pageFragment.add(AnimalOrderFragment.newInstance(titles[i],this));
        }

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),1,pageFragment));



    }

    /**
     * 初始化顶部标签
     */
    private void initTabNormal() {
        tabLayout.setupWithViewPager(viewPager);
    }


    /**
     * ViewPager的适配器。
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {

        List<AnimalOrderFragment> fragmentList;

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, List<AnimalOrderFragment> fragmentList) {
            super(fm, behavior);
            this.fragmentList = fragmentList;
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentList.get(position).getTitle();
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            //   super.destroyItem(container, position, object);
        }
    }

}