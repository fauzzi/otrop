package me.fauzi.portofiolio.base;


import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import butterknife.BindView;
import me.fauzi.portofiolio.R;

/**
 * Created by fauzi on 14/6/16.
 */

public abstract class ToolbarActivity extends BaseActivity {
  @BindView(R.id.toolbar)
  protected Toolbar toolbar;

  @Override
  protected void onBindView() {
    super.onBindView();
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayShowTitleEnabled(false);
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
