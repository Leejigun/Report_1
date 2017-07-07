package com.example.dopy.facebook;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/* 진주=>https://github.com/jinjoochoi/Boost */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.viewpager)
    ViewPager myViewPager;
    @BindView(R.id.mTabLayout)
    TabLayout myTabLayout;
    @OnClick(R.id.toolbar_direct)
    void directfunc(){
        Toast.makeText(MainActivity.this,"direct Button Clicked",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.toolbar_messenger)
    void messagefunc(){
        Toast.makeText(MainActivity.this,"Messenger Button Clicked",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();
    }

    private void setupToolbar(){
        //뷰페이저와 어탭터 연결
        toolbar_Adapter toolbarAdapter=new toolbar_Adapter(getSupportFragmentManager());
        myViewPager.setAdapter(toolbarAdapter);
        myTabLayout.setupWithViewPager(myViewPager);
        myTabLayout.getTabAt(0).setIcon(R.drawable.newsfeed);
        myTabLayout.getTabAt(1).setIcon(R.drawable.friend);
        myTabLayout.getTabAt(2).setIcon(R.drawable.alert);
        myTabLayout.getTabAt(3).setIcon(R.drawable.menu);

        /*directButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"direct Button Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        messengerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Message Button Clicked",Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return TimeLine_fragment.newInstance();
                default:
                    // not implemented.
                    return empty_fragment.newInstance();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "";
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}
