package com.example.codingtown.tabfragmentprogram;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    TabLayout tlayout; //This is our tablayout
    ViewPager vPager;//This is our viewPager



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = (ViewPager) findViewById(R.id.viewpager);
        vPager.setAdapter(new CustomAdapter(getSupportFragmentManager(), getApplicationContext()));

        tlayout=(TabLayout)findViewById(R.id.tabLayout);
        tlayout.setupWithViewPager(vPager);

        tlayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                vPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                vPager.setCurrentItem(tab.getPosition());
            }
        });

    }

    private class CustomAdapter extends FragmentPagerAdapter
    {
        private String fragments[]={"Frgament 1","Fragment 2"};
        public CustomAdapter(FragmentManager supportFragmentManager,Context applicationContext)
        {
         super(supportFragmentManager);

        }


        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0:
                    return new Fragments1();
                case 1:
                    return  new Fragments2();
                default:
                    return  null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
    }
}