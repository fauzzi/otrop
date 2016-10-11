package me.fauzi.portofiolio.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by fauzi on 14/6/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

  @Override
  @Deprecated
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getContentViewResource());
    onBindView();
    onViewCreated();
  }

  protected void onBindView() {
    ButterKnife.bind(this);
  }

  @LayoutRes
  protected abstract int getContentViewResource();

  protected abstract void onViewCreated();

}
