package com.example.netsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.netsurvey.model.Area;
import com.example.netsurvey.repository.DatabaseHelper;

public class AreaCoverage extends AppCompatActivity implements View.OnClickListener {
    public EditText start, end, corridor, region, shoulderType, startPoint, endPoint, road, link;

    public Button saveBtn;

    Spinner subLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_coverage);

        subLink = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.links, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subLink.setAdapter(adapter);

        start = findViewById(R.id.editTextText);
        end = findViewById(R.id.editTextText2);
        corridor = findViewById(R.id.editTextText3);
        region = findViewById(R.id.editTextText4);
        shoulderType = findViewById(R.id.editTextText5);
        startPoint = findViewById(R.id.editTextNumber5);
        endPoint = findViewById(R.id.editTextNumber4);
        road = findViewById(R.id.editTextNumber2);
        link = findViewById(R.id.editTextNumber);

        saveBtn = findViewById(R.id.button2);
        saveBtn.setOnClickListener(this);
    }

    public void createNewArea() {
        String startTxt = start.getText().toString();
        String endTxt = end.getText().toString();
        String corridorTxt = corridor.getText().toString();
        String regionTxt = region.getText().toString();
        String shoulderTxt = shoulderType.getText().toString();
        String startPointTxt = startPoint.getText().toString();
        String endPointTxt = endPoint.getText().toString();
        String roadTxt = road.getText().toString();
        String linkTxt = link.getText().toString();
        String subLinkTxt = subLink.getSelectedItem().toString();

        if (!startTxt.equals("") && !endTxt.equals("") && !corridorTxt.equals("") && !regionTxt.equals("") && !shoulderTxt.equals("") && !startPointTxt.equals("") && !endPointTxt.equals("") && !roadTxt.equals("") && !subLinkTxt.equals("") && !linkTxt.equals("")) {
            DatabaseHelper db = new DatabaseHelper(getApplicationContext());

            db.createArea(new Area(startTxt, endTxt, corridorTxt, regionTxt, shoulderTxt, startPointTxt, endPointTxt, roadTxt, linkTxt, subLinkTxt));
            Toast.makeText(this, "Area Created", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"You are required to fill all the inputs", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        createNewArea();
    }
}