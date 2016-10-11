package me.fauzi.portofiolio.activity;

import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import me.fauzi.portofiolio.R;
import me.fauzi.portofiolio.adapter.BuddyAdapter;
import me.fauzi.portofiolio.base.ToolbarActivity;
import me.fauzi.portofiolio.model.Item;
import me.fauzi.portofiolio.utils.ZoomOutPageTransformer;

/**
 * Created by akhma on 02/10/2016.
 */

public class ApcActivity extends ToolbarActivity {
  @BindView(R.id.pager)
  ViewPager pager;
  private BuddyAdapter buddyAdapter;

  @Override
  protected int getContentViewResource() {
    return R.layout.activity_buddy;
  }

  @Override
  protected void onViewCreated() {
    toolbar.setTitle(R.string.asian_pastry_cub);

    buddyAdapter = new BuddyAdapter(getBaseContext(), loadData(), new BuddyAdapter.OnItemClickListener() {
      @Override
      public void onClick(View view, int position) {

      }
    });
    pager.setAdapter(buddyAdapter);
    pager.setPageTransformer(true, new ZoomOutPageTransformer());
  }

  private ArrayList loadData() {
    ArrayList arrayList = new ArrayList();
    arrayList.add(new Item("12/12/2016", R.drawable.apc_dashboard));
    arrayList.add(new Item("12/12/2016", R.drawable.apc_judge));
    arrayList.add(new Item("12/12/2016", R.drawable.apc_prize));
    arrayList.add(new Item("12/12/2016", R.drawable.apc_scoring));
    return arrayList;
  }
}
