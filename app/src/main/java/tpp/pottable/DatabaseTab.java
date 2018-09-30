package tpp.pottable;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTab extends Fragment {

    private List<RecyclerViewItem> ItemList = null;

    public DatabaseTab(){}

    @Override
    public void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.database, container, false);
        initializeItemList();
        RecyclerView catRecyclerView = (RecyclerView) rootView.findViewById(R.id.card_view_recycler_list);
        // Create recycler view data adapter with item list.
        RecyclerViewDataAdapter DataAdapter = new RecyclerViewDataAdapter(ItemList);
        // Set data adapter.
        catRecyclerView.setAdapter(DataAdapter);
        // Create the grid layout manager with 2 columns.
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        // Set layout manager.
        catRecyclerView.setLayoutManager(gridLayoutManager);
        return rootView;
    }

    /* Initialise car items in list. */
    private void initializeItemList()
    {
        if(ItemList == null)
        {
            ItemList = new ArrayList<RecyclerViewItem>();
            ItemList.add(new RecyclerViewItem("COMMON", R.drawable.common, "Description here."));
            ItemList.add(new RecyclerViewItem("FOLIAGE", R.drawable.foliage, "Description here."));
            ItemList.add(new RecyclerViewItem("SUCCULENT", R.drawable.succulent, "Description here."));
            ItemList.add(new RecyclerViewItem("UNUSUAL", R.drawable.unusual, "Description here."));
        }
    }

}
