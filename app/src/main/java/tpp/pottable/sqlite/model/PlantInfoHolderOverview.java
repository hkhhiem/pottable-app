package tpp.pottable.sqlite.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tpp.pottable.R;

public class PlantInfoHolderOverview extends RecyclerView.ViewHolder {

    private TextView Name = null;

    private ImageView ImageView_tree = null;

    private ImageView data_sun = null;
    private ImageView data_water = null;
    private ImageView data_soil = null;
    private ImageView data_size = null;

    public PlantInfoHolderOverview(View itemView) {
        super(itemView);
        if (itemView != null){
            Name = (TextView) itemView.findViewById(R.id.card_view_image_tree);
            ImageView_tree = (ImageView) itemView.findViewById(R.id.card_view_image_title_tree);
            data_sun = (ImageView) itemView.findViewById(R.id.card_view_data_sun);
            data_water = (ImageView) itemView.findViewById(R.id.card_view_data_water);
            data_soil = (ImageView) itemView.findViewById(R.id.card_view_data_soil);
            data_size = (ImageView) itemView.findViewById(R.id.card_view_data_size);
        }
    }

    public TextView getName() {
        return Name;
    }

    public ImageView getImageView_tree() {
        return ImageView_tree;
    }

    public ImageView getData_sun() {
        return data_sun;
    }

    public ImageView getData_water() {
        return data_water;
    }

    public ImageView getData_soil() {
        return data_soil;
    }

    public ImageView getData_size() {
        return data_size;
    }
}
