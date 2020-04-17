package com.udgs123.demo3gs.ui.lopcangiasu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitle = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }
    public int getCount() {
        return lstTitle.size();
    }
    public  CharSequence getPageTitle(int position) {
        return lstTitle.get(position);
    }
    public void AddFragment(Fragment fragment, String title) {
        lstFragment.add(fragment);
        lstTitle.add(title);
    }

}
