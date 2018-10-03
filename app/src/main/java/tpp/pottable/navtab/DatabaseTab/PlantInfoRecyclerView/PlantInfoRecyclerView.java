package tpp.pottable.navtab.DatabaseTab.PlantInfoRecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tpp.pottable.R;
import tpp.pottable.sqlite.DatabaseHelper;
import tpp.pottable.sqlite.model.PlantInfo;

public class PlantInfoRecyclerView extends AppCompatActivity {

    private DatabaseHelper mDBHelper = new DatabaseHelper(this); //fuck contexts
    private SQLiteDatabase mDb;
    private List<PlantInfo> PlantInfoList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_category_inside);

        RecyclerView plantinforecyclerview = (RecyclerView) findViewById(R.id.category_body);

        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("selectedCategoryID"));
        String catName = null;
        switch (id) {
            case 0: {
                catName = "COMMON";
                break;
            }
            case 1: {
                catName = "FOLIAGE";
                break;
            }
            case 2: {
                catName = "SUCCULENT";
                break;
            }
            case 3: {
                catName = "UNUSUAL";
                break;
            }
            default: break; //fuck it
            }
        PlantInfoList = mDBHelper.getCatPlantInfo(catName);


        // Create recycler view data adapter with item list.
        PlantInfoRecyclerViewDataAdapter DataAdapter = new PlantInfoRecyclerViewDataAdapter(PlantInfoList);
        // Set data adapter.
        plantinforecyclerview.setAdapter(DataAdapter);
        // Create the grid layout manager with 2 columns.
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        // Set layout manager.
        plantinforecyclerview.setLayoutManager(gridLayoutManager);

    }
    /*DATABASE INIT*/

}
