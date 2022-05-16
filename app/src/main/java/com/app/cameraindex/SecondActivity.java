package com.app.cameraindex;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<CameraModel> cameraModels = new ArrayList<>();
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btnLogOut;
    private SecondViewModel viewModel;

    int[] cameraImages = {R.drawable.sony_grip, R.drawable.sony_a7_ii,
            R.drawable.canon_700d, R.drawable.canon_70200, R.drawable.canon_d3400,
            R.drawable.dji_zenmuse, R.drawable.nikon_d750, R.drawable.nikon_d750,
            R.drawable.sony_rx100};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //navigation drawer

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        btnLogOut = findViewById(R.id.btnLogout);

        setUpCameraModels();

        C_RecycleViewAdapter adapter = new C_RecycleViewAdapter(this,
                cameraModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(SecondViewModel.class);
        btnLogOut.setOnClickListener(view -> {
            startActivity(new Intent(SecondActivity.this, LoginActivity.class));
            viewModel.logOut();
        });
    }

    private void setUpCameraModels() {
        String[] cameraNames = getResources().getStringArray(R.array.gear_name);
        String[] cameraYear = getResources().getStringArray(R.array.gear_year);
        String[] cameraRating = getResources().getStringArray(R.array.gear_year);
        for (int i = 0; i < cameraNames.length; i++) {
            cameraModels.add(new CameraModel(cameraNames[i], cameraYear[i],
                    cameraRating[i], cameraImages[i]));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
