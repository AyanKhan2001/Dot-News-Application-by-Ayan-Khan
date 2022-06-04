package com.example.dotnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;


import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tabLayout;
TabItem mhome,msports,mhealth,mtech,mentertainment;
PagerAdapter pagerAdapter;
Toolbar mtoolbar;

    String api="1ed8b9ee56b14089872a7b1f3fd9757e";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome=findViewById(R.id.home);
        msports=findViewById(R.id.sports);
        mhealth=findViewById(R.id.health);
        mtech=findViewById(R.id.technology);
        mentertainment=findViewById(R.id.entertaintment);
        ViewPager viewPager= findViewById(R.id.fragmentcontainer);
        tabLayout=findViewById(R.id.include);

        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
            if(tab.getPosition()==0 ||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4)
            {
                pagerAdapter.notifyDataSetChanged();
            }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }


}