package tpp.pottable.navtab.DatabaseTab.PlantInfoRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tpp.pottable.R;

import tpp.pottable.sqlite.model.PlantInfo;
import tpp.pottable.sqlite.model.PlantInfoHolder;

public class PlantInfoRecyclerViewDataAdapter extends RecyclerView.Adapter<PlantInfoHolder> {

    private List<PlantInfo> PlantInfoList;

    public PlantInfoRecyclerViewDataAdapter(List<PlantInfo> PlantInfoList) {
        this.PlantInfoList = PlantInfoList;
    }
    @Override
    public PlantInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get LayoutInflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the RecyclerView item layout xml.
        View ItemView = layoutInflater.inflate(R.layout.cardview_data, parent, false);

        // Create and return our custom PlantInfo Recycler View Item Holder object.
        return new PlantInfoHolder(ItemView);
    }
    @Override
    public void onBindViewHolder(PlantInfoHolder holder, int position) {
        if(PlantInfoList!=null) {
            // Get category item dto in list.
            PlantInfo Item = PlantInfoList.get(position);

            if(Item != null) {
                // Set plantinfo card data
                holder.getName().setText(Item.getName());
                holder.getImageView_tree().setImageBitmap(Item.getImage()); //dear god pls make this work
            }
        }
    }
    @Override
    public int getItemCount() {
        int ret = 0;
        if(PlantInfoList!=null)
        {
            ret = PlantInfoList.size();
        }
        return ret;
    }
}
