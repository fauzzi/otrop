package me.fauzi.portofiolio.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import me.fauzi.portofiolio.MainActivity;
import me.fauzi.portofiolio.R;
import me.fauzi.portofiolio.adapter.ScreenSlidePagerAdapter;
import me.fauzi.portofiolio.base.BaseActivity;
import me.fauzi.portofiolio.fragment.SlideFragment;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by akhma on 02/10/2016.
 */

public class IntroActivity extends BaseActivity {
  @BindView(R.id.pager)
  ViewPager pager;
  @BindView(R.id.indicator)
  CircleIndicator indicator;
  @BindView(R.id.btnNext)
  Button btnNext;

  @Override
  protected int getContentViewResource() {
    return R.layout.activity_intro;
  }

  @Override
  protected void onViewCreated() {

    Fragment[] fragments = {
      SlideFragment.newInstance(R.layout.intro1),
      SlideFragment.newInstance(R.layout.intro2),
      SlideFragment.newInstance(R.layout.intro4),
      SlideFragment.newInstance(R.layout.intro3),
      SlideFragment.newInstance(R.layout.intro5)
    };

    PagerAdapter adapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), fragments);
    pager.setAdapter(adapter);
    indicator.setViewPager(pager);

    pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(final int position, float positionOffset, int positionOffsetPixels) {
        if (position < 2) {
          btnNext.setText(R.string.skip);
        } else {
          btnNext.setText(R.string.finish);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (position < 2) {
              startActivity(new Intent(IntroActivity.this, MainActivity.class));
              finish();
            } else {
              startActivity(new Intent(IntroActivity.this, MainActivity.class));
              finish();
            }
          }
        });
      }

      @Override
      public void onPageSelected(int position) {
      }

      @Override
      public void onPageScrollStateChanged(int state) {
      }

    });


  }
}
