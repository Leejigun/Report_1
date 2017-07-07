package com.example.dopy.facebook;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Dopy on 2017-07-05.
 *
 * 참고 블로그 http://developer88.tistory.com/6
 */

public class toolbar_Adapter extends FragmentPagerAdapter {
    private static int PAGE_NUMBER=4;
    public toolbar_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TimeLine_fragment.newInstance();
            default:
                return empty_fragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }
}
