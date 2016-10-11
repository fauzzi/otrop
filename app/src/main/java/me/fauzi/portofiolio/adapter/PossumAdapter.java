package me.fauzi.portofiolio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import me.fauzi.portofiolio.R;
import me.fauzi.portofiolio.base.BaseAdapter;
import me.fauzi.portofiolio.model.Possum;

/**
 * Created by akhma on 02/10/2016.
 */

public class PossumAdapter extends BaseAdapter<Possum, PossumAdapter.ViewHolder> {
  private Context context;

  public PossumAdapter(Context context) {
    this.context = context;
  }

  @Override
  protected ViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.item_possum, parent, false);
    return new ViewHolder(view);
  }

  @Override
  protected void onBindViewHolder(ViewHolder holder) {
    Possum possum = getItem(holder.getAdapterPosition());
    holder.mTitle.setText(possum.getTitle());
    holder.mImage.setImageResource(possum.getImage());
  }

  public class ViewHolder extends BaseAdapter.BaseViewHolder {
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.image)
    ImageView mImage;

    public ViewHolder(View itemView) {
      super(itemView);
    }
  }
}
