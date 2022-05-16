package com.app.cameraindex;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<CameraModel> cameraModels = new ArrayList<>();
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btnLogOut;
    private MainActivityViewModel viewModel;
    private DrawerLayout drawerLayout;

    int[] cameraImages = {R.drawable.sony_a6000, R.drawable.sony_grip, R.drawable.sony_a7_ii,
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
        ActionBar toolbar = getSupportActionBar();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        // to make the Navigation drawer icon always appear on the action bar
        toolbar.setDisplayHomeAsUpEnabled(true);


        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        btnLogOut = findViewById(R.id.btnLogout);

        setUpCameraModels();

        C_RecycleViewAdapter adapter = new C_RecycleViewAdapter(this,
                cameraModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        btnLogOut.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
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
            if(item.getItemId() == R.id.settings)
            {
                Toast.makeText(this, "pressed on settings!", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_home :{
                Toast.makeText(this, "pressed on home!", Toast.LENGTH_SHORT).show();
            }
            case R.id.RegisterActivity: {
                Toast.makeText(this,"pressed on register!", Toast.LENGTH_SHORT).show();
            }
            case R.id.settings:{
                Toast.makeText(this, "pressed on settings!", Toast.LENGTH_SHORT).show();
            }
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
