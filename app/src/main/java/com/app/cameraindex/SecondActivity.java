package com.app.cameraindex;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<CameraModel> cameraModels = new ArrayList<>();

    int[] cameraImages = {R.drawable.sony_a6000, R.drawable.sony_grip, R.drawable.sony_a7_ii,
                R.drawable.canon_700d, R.drawable.canon_70200, R.drawable.canon_d3400,
                R.drawable.dji_zenmuse, R.drawable.nikon_d750, R.drawable.nikon_d750,
                R.drawable.sony_rx100};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpCameraModels();

        C_RecycleViewAdapter adapter = new C_RecycleViewAdapter(this,
                cameraModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpCameraModels() {
        String[] cameraNames = getResources().getStringArray(R.array.gear_name);
        String[] cameraYear = getResources().getStringArray(R.array.gear_year);
        String[] cameraRating = getResources().getStringArray(R.array.gear_year);
    for (int i=0; i< cameraNames.length; i++){
        cameraModels.add(new CameraModel(cameraNames[i], cameraYear[i],
                cameraRating[i], cameraImages[i]));
    }

    }


}
