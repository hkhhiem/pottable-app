package tpp.pottable.navtab.DatabaseTab;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import tpp.pottable.R;
import tpp.pottable.navtab.DatabaseTab.PlantInfoRecyclerView.PlantInfoRecyclerView;

public class CatRecyclerViewItemHolder extends RecyclerView.ViewHolder {

    private TextView TitleText = null;

    private ImageView ImageView = null;

    private TextView DescText = null;

    public RelativeLayout plantinfo_card = null;

    public interface OnItemClickListener {
        public void onClick(View view, int position);
    }

    public CatRecyclerViewItemHolder(View itemView) {
        super(itemView);
        if (itemView != null) {
            TitleText = (TextView) itemView.findViewById(R.id.card_view_image_title);
            ImageView = (ImageView) itemView.findViewById(R.id.card_view_image);
            DescText = (TextView) itemView.findViewById(R.id.card_view_image_desc);
            plantinfo_card = itemView.findViewById(R.id.plantinfo_card);
        }
    }

    public TextView getTitleText() {
        return TitleText;
    }

    public ImageView getImageView() {
        return ImageView;
    }

    public TextView getDescText() {
        return DescText;
    }

}
