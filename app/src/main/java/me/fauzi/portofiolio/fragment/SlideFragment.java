package me.fauzi.portofiolio.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.fauzi.portofiolio.base.BaseFragment;


/**
 * Created by akhma on 20/06/2016.
 */
public class SlideFragment extends BaseFragment {

  private static final String ARG_LAYOUT_RES_ID = "layoutResId";
  private int layoutResId;

  public SlideFragment() {
  }

  public static SlideFragment newInstance(int layoutResId) {
    SlideFragment fragment = new SlideFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID))
      layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
  }

  @Override
  protected void onViewCreated() {

  }

  @Override
  protected int getContentViewResource() {
    return layoutResId;
  }
}
