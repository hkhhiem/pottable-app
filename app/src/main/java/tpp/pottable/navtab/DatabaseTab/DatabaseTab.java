package tpp.pottable.navtab.DatabaseTab;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tpp.pottable.R;
import tpp.pottable.sqlite.DatabaseHelper;

public class DatabaseTab extends Fragment {

    private List<CatRecyclerViewItem> ItemList = null;

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
        CatRecyclerViewDataAdapter DataAdapter = new CatRecyclerViewDataAdapter(ItemList);
        // Set data adapter.
        catRecyclerView.setAdapter(DataAdapter);
        // Create the grid layout manager with 2 columns.
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        // Set layout manager.
        catRecyclerView.setLayoutManager(gridLayoutManager);
        return rootView;
    }



    /* Initialise items in list. */
    private void initializeItemList()
    {
        if(ItemList == null)
        {
            ItemList = new ArrayList<CatRecyclerViewItem>();
            ItemList.add(new CatRecyclerViewItem(getString(R.string.cat_common), R.drawable.common,getString(R.string.cat_common_desc)));
            ItemList.add(new CatRecyclerViewItem(getString(R.string.cat_foliage), R.drawable.foliage, getString(R.string.cat_foliage_desc)));
            ItemList.add(new CatRecyclerViewItem(getString(R.string.cat_succulent), R.drawable.succulent, getString(R.string.cat_succulent_desc)));
            ItemList.add(new CatRecyclerViewItem(getString(R.string.cat_unusual), R.drawable.unusual, getString(R.string.cat_unusual_desc)));
        }
    }

}
