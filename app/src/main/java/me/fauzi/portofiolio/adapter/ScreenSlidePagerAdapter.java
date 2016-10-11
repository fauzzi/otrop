package me.fauzi.portofiolio.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by akhma on 27/06/2016.
 */

public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
  private final Fragment[] mFragments;

  public ScreenSlidePagerAdapter(FragmentManager fm, Fragment[] fragments) {
    super(fm);
    mFragments = fragments;
  }

  @Override
  public Fragment getItem(int position) {
    return mFragments[position];
  }

  @Override
  public int getCount() {
    return mFragments.length;
  }

  @Override
  public int getItemPosition(Object object) {
    return POSITION_NONE;
  }
}
