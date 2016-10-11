package me.fauzi.portofiolio.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import me.fauzi.portofiolio.model.Landing;
import me.fauzi.portofiolio.R;
import me.fauzi.portofiolio.base.BaseAdapter;

/**
 * Created by akhma on 02/10/2016.
 */

public class LandingAdapter extends BaseAdapter<Landing, LandingAdapter.ViewHolder> {

  @Override
  protected ViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.item_landing, parent, false);
    return new ViewHolder(view);
  }

  @Override
  protected void onBindViewHolder(ViewHolder holder) {
    Landing landing = getItem(holder.getAdapterPosition());
    holder.mIcon.setImageResource(landing.getIcon());
    holder.mTitle.setText(landing.getTitle());
  }

  public class ViewHolder extends BaseAdapter.BaseViewHolder {
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.title)
    TextView mTitle;

    public ViewHolder(View itemView) {
      super(itemView);
    }
  }
}
