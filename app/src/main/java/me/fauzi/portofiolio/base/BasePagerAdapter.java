package me.fauzi.portofiolio.base;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by fauzi on 14/6/16.
 */

public abstract class BasePagerAdapter<M, VH extends BasePagerAdapter.BaseViewHolder> extends PagerAdapter {


  public static class BaseViewHolder extends PagerAdapter {
    @Override
    public int getCount() {
      return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
      return false;
    }
  }
}
