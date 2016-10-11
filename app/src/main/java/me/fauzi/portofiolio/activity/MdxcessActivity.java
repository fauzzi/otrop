package me.fauzi.portofiolio.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import me.fauzi.portofiolio.R;
import me.fauzi.portofiolio.adapter.PossumAdapter;
import me.fauzi.portofiolio.base.ToolbarActivity;
import me.fauzi.portofiolio.model.Possum;

/**
 * Created by akhma on 02/10/2016.
 */

public class MdxcessActivity extends ToolbarActivity {

  private PossumAdapter possumAdapter;
  @BindView(R.id.viewpager)
  protected RecyclerViewPager mRecyclerView;

  @Override
  protected int getContentViewResource() {
    return R.layout.activity_possum;
  }

  @Override
  protected void onViewCreated() {
    toolbar.setTitle("MDXCess");
    initViewPager();
  }


  protected void initViewPager() {


    LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
      true);
    mRecyclerView.setLayoutManager(layout);
    possumAdapter = new PossumAdapter(this);

    possumAdapter.setItems(loadData());
    mRecyclerView.setAdapter(possumAdapter);
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLongClickable(true);

    mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override
      public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
//                updateState(scrollState);
      }

      @Override
      public void onScrolled(RecyclerView recyclerView, int i, int i2) {
//                mPositionText.setText("First: " + mRecyclerViewPager.getFirstVisiblePosition());
        int childCount = mRecyclerView.getChildCount();
        int width = mRecyclerView.getChildAt(0).getWidth();
        int padding = (mRecyclerView.getWidth() - width) / 2;
//                mCountText.setText("Count: " + childCount);

        for (int j = 0; j < childCount; j++) {
          View v = recyclerView.getChildAt(j);
          //往左 从 padding 到 -(v.getWidth()-padding) 的过程中，由大到小
          float rate = 0;
          ;
          if (v.getLeft() <= padding) {
            if (v.getLeft() >= padding - v.getWidth()) {
              rate = (padding - v.getLeft()) * 1f / v.getWidth();
            } else {
              rate = 1;
            }
            v.setScaleY(1 - rate * 0.1f);
            v.setScaleX(1 - rate * 0.1f);

          } else {
            //往右 从 padding 到 recyclerView.getWidth()-padding 的过程中，由大到小
            if (v.getLeft() <= recyclerView.getWidth() - padding) {
              rate = (recyclerView.getWidth() - padding - v.getLeft()) * 1f / v.getWidth();
            }
            v.setScaleY(0.9f + rate * 0.1f);
            v.setScaleX(0.9f + rate * 0.1f);
          }
        }
      }
    });
    mRecyclerView.addOnPageChangedListener(new RecyclerViewPager.OnPageChangedListener() {
      @Override
      public void OnPageChanged(int oldPosition, int newPosition) {
        Log.d("test", "oldPosition:" + oldPosition + " newPosition:" + newPosition);
      }
    });

    mRecyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
      @Override
      public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (mRecyclerView.getChildCount() < 3) {
          if (mRecyclerView.getChildAt(1) != null) {
            if (mRecyclerView.getCurrentPosition() == 0) {
              View v1 = mRecyclerView.getChildAt(1);
              v1.setScaleY(0.9f);
              v1.setScaleX(0.9f);
            } else {
              View v1 = mRecyclerView.getChildAt(0);
              v1.setScaleY(0.9f);
              v1.setScaleX(0.9f);
            }
          }
        } else {
          if (mRecyclerView.getChildAt(0) != null) {
            View v0 = mRecyclerView.getChildAt(0);
            v0.setScaleY(0.9f);
            v0.setScaleX(0.9f);
          }
          if (mRecyclerView.getChildAt(2) != null) {
            View v2 = mRecyclerView.getChildAt(2);
            v2.setScaleY(0.9f);
            v2.setScaleX(0.9f);
          }
        }

      }
    });

  }


  private ArrayList loadData() {
    ArrayList arrayList = new ArrayList();
    arrayList.add(new Possum("Login", R.drawable.mdx_login));
    arrayList.add(new Possum("Main", R.drawable.mdx_main));
    arrayList.add(new Possum("Consultation", R.drawable.mdx_consultation));
    arrayList.add(new Possum("Add Photo", R.drawable.mdx_addphoto));
    arrayList.add(new Possum("Add Consultation", R.drawable.mdx_consultation_added));
    return arrayList;
  }

}
