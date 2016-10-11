package me.fauzi.portofiolio.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.fauzi.portofiolio.R;
import me.fauzi.portofiolio.model.Item;

/**
 * Created by akhma on 02/10/2016.
 */

public class ApcAdapter extends PagerAdapter {

  private LayoutInflater layoutInflater;
  private Context context;
  private ArrayList<Item> itemArrayList;
  private OnItemClickListener mListener;


  public interface OnItemClickListener {
    public void onClick(View view, int position);
  }


  public ApcAdapter(Context context, ArrayList<Item> xRaySummaries, OnItemClickListener listener) {
    this.context = context;
    this.itemArrayList = xRaySummaries;
    this.mListener = listener;
  }


  @Override
  public Object instantiateItem(ViewGroup container, final int position) {
    layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View item_view = layoutInflater.inflate(R.layout.item_buddy, (ViewGroup) container, false);

    TextView mDate = (TextView) item_view.findViewById(R.id.title);
    ImageView mPicture = (ImageView) item_view.findViewById(R.id.picture);

    Item item = itemArrayList.get(position);

    String count = (position + 1) + " of " + getCount();
    mDate.setText(count);

    mPicture.setImageResource(item.getImage());

    item_view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mListener.onClick(view, position);
      }
    });

    ((ViewGroup) container).addView(item_view);

    return item_view;
  }

  @Override
  public int getCount() {
    return itemArrayList.size();
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((FrameLayout) object);
  }

}
