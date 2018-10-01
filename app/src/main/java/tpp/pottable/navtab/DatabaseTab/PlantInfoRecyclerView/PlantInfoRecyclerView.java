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

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private List<PlantInfo> PlantInfoList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_category_inside);

        RecyclerView plantinforecyclerview = (RecyclerView) findViewById(R.id.category_body);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        PlantInfoList = mDBHelper.getCatPlantInfo(id); //TODO: ID IS JUST HERE TO AVOID PUSH ERROR. WE NEED TO GET CATEGORY NAME FROM ID.

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
