package tpp.pottable.navtab.DatabaseTab.PlantInfoRecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import tpp.pottable.R;

public class PlantInfoRecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_category_inside);
    }
    RecyclerView PlantInfoOverview = (RecyclerView) findViewById(R.id.category_body);;

}
