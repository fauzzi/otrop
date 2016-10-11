package me.fauzi.portofiolio.activity;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import me.fauzi.portofiolio.MainActivity;
import me.fauzi.portofiolio.R;
import me.fauzi.portofiolio.base.BaseActivity;

/**
 * Created by akhma on 02/10/2016.
 */

public class SplashActivity extends BaseActivity {

  @BindView(R.id.title)
  TextView mTitle;
  @BindView(R.id.author)
  TextView mAuthor;

  @Override
  protected int getContentViewResource() {
    return R.layout.activity_splash;
  }

  @Override
  protected void onViewCreated() {
    Thread welcomeThread = new Thread() {
      @Override
      public void run() {
        try {
          super.run();
          Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
          mTitle.startAnimation(animation);

          Animation animation_a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout);
          mAuthor.startAnimation(animation_a);

          sleep(5000);
        } catch (Exception ignored) {
          ignored.printStackTrace();
        } finally {
          startActivity(new Intent(getBaseContext(), IntroActivity.class));
          finish();
        }
      }
    };
    welcomeThread.start();

  }
}
