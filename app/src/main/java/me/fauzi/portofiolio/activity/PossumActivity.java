package me.fauzi.portofiolio.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import me.fauzi.portofiolio.R;
import me.fauzi.portofiolio.adapter.BuddyAdapter;
import me.fauzi.portofiolio.adapter.PossumAdapter;
import me.fauzi.portofiolio.base.ToolbarActivity;
import me.fauzi.portofiolio.model.Item;
import me.fauzi.portofiolio.model.Possum;
import me.fauzi.portofiolio.utils.ZoomOutPageTransformer;

/**
 * Created by akhma on 02/10/2016.
 */

public class PossumActivity extends ToolbarActivity {

  @BindView(R.id.pager)
  ViewPager pager;
  private BuddyAdapter buddyAdapter;

  @Override
  protected int getContentViewResource() {
    return R.layout.activity_buddy;
  }

  @Override
  protected void onViewCreated() {
    toolbar.setTitle("Incident Reporting");

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
    arrayList.add(new Item("12/12/2016", R.drawable.possum_sign_up));
    arrayList.add(new Item("12/12/2016", R.drawable.possum_forgot_password));
    arrayList.add(new Item("12/12/2016", R.drawable.possum_choose_categories));
    arrayList.add(new Item("12/12/2016", R.drawable.possum_linking_to_cart));
    arrayList.add(new Item("12/12/2016", R.drawable.possum_dining_option));
    arrayList.add(new Item("12/12/2016", R.drawable.possum_capture));
    arrayList.add(new Item("12/12/2016", R.drawable.possum_payment_ui));
    return arrayList;
  }
}
