package com.example.netsurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.netsurvey.adapter.AreaAdapter;
import com.example.netsurvey.model.Area;
import com.example.netsurvey.repository.DatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AreaAdapter.OnClickListener {
    public RecyclerView areaView;
    public ArrayList<Area> areas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        areaView= findViewById(R.id.areaList);

        getAreas();

        AreaAdapter adapter = new AreaAdapter(this, areas);

        adapter.setOnClickListener(this);

        areaView.setHasFixedSize(true);
        areaView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        areaView.setAdapter(adapter);
    }

    public void getAreas(){
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        areas = db.getAllAreas();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onClick(int position, Area area) {
        Toast.makeText(this, "Position: "+position+" id: "+area.getId(), Toast.LENGTH_SHORT).show();

//        Intent intent = new Intent(this,UpdateNoteActivity.class);
//        intent.putExtra("id",area.getId());
//        intent.putExtra("title",area.getTitle());
//        intent.putExtra("body",area.getBody());
//        startActivity(intent);
    }
}