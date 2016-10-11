package me.fauzi.portofiolio;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import me.fauzi.portofiolio.activity.AlamaakActivity;
import me.fauzi.portofiolio.activity.ApcActivity;
import me.fauzi.portofiolio.activity.BaristaActivity;
import me.fauzi.portofiolio.activity.BuddyActivity;
import me.fauzi.portofiolio.activity.EspressoActivity;
import me.fauzi.portofiolio.activity.IncidentReportingActivity;
import me.fauzi.portofiolio.activity.MdxcessActivity;
import me.fauzi.portofiolio.activity.PossumActivity;
import me.fauzi.portofiolio.adapter.LandingAdapter;
import me.fauzi.portofiolio.base.BaseAdapter;
import me.fauzi.portofiolio.base.ToolbarActivity;
import me.fauzi.portofiolio.model.Landing;
import me.fauzi.portofiolio.utils.GridSpacingItemDecoration;

public class MainActivity extends ToolbarActivity {


  @BindView(R.id.recyclerView)
  RecyclerView recyclerView;
  private GridLayoutManager lLayout;
  private LandingAdapter landingAdapter;

  @Override
  protected int getContentViewResource() {
    return R.layout.activity_main;
  }

  @Override
  protected void onViewCreated() {
    toolbar.setTitle(R.string.akhmad_fauzi_hasibuan);

    //landing menu setup
    lLayout = new GridLayoutManager(this, 2);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(lLayout);
    recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
    landingAdapter = new LandingAdapter();
    landingAdapter.setItems(prepareData());
    recyclerView.setAdapter(landingAdapter);
    landingAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener<Landing>() {
      @Override
      public void onItemClick(View view, int position, Landing landing) {
        switch (position) {
          case 0:
            startActivity(new Intent(MainActivity.this, ApcActivity.class));
            break;
          case 1:
            startActivity(new Intent(MainActivity.this, IncidentReportingActivity.class));
            break;
          case 2:
            startActivity(new Intent(MainActivity.this, PossumActivity.class));
            break;
          case 3:
            startActivity(new Intent(MainActivity.this, BuddyActivity.class));
            break;
          case 4:
            startActivity(new Intent(MainActivity.this, EspressoActivity.class));
            break;
          case 5:
            startActivity(new Intent(MainActivity.this, BaristaActivity.class));
            break;

          case 6:
            startActivity(new Intent(MainActivity.this, MdxcessActivity.class));
            break;

          case 7:
            startActivity(new Intent(MainActivity.this, AlamaakActivity.class));
            break;


          default:
            break;
        }
      }
    });
  }

  private ArrayList prepareData() {
    ArrayList arrayList = new ArrayList();
    arrayList.add(new Landing("APC", R.drawable.apc_dashboard));
    arrayList.add(new Landing("Incident Reporting", R.drawable.incident_reporting));
    arrayList.add(new Landing("Possum", R.drawable.possum_capture));
    arrayList.add(new Landing("Nutritionist Buddy", R.drawable.buddy_5_meallogging_photo));
    arrayList.add(new Landing("63Espresso", R.drawable.es_landing));
    arrayList.add(new Landing("63Espresso Barista", R.drawable.barista_landing));
    arrayList.add(new Landing("MDXcess", R.drawable.mdx_consultation));
    arrayList.add(new Landing("Alamaak", R.drawable.mak_food));
    return arrayList;
  }

  /**
   * Converting dp to pixel
   */
  private int dpToPx(int dp) {
    Resources r = getResources();
    return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
  }

}
