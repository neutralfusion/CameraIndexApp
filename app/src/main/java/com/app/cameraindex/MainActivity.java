package com.app.cameraindex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CameraModel> cameraModels = new ArrayList<>();

    int[] cameraImages = {R.drawable.sony_a6000, R.drawable.sony_grip, R.drawable.sony_a7_ii, R.drawable.canon_700d,
            R.drawable.canon_70200, R.drawable.canon_d3400, R.drawable.dji_zenmuse, R.drawable.nikon_d750,
            R.drawable.yongnuo_flash, R.drawable.sony_rx100};

        Button btnLogOut;
        FirebaseAuth mAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.nav_activity_main);

            btnLogOut = findViewById(R.id.btnLogout);
            mAuth = FirebaseAuth.getInstance();

            btnLogOut.setOnClickListener(view ->{
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            });

        }

        @Override
        protected void onStart() {
            super.onStart();
            FirebaseUser user = mAuth.getCurrentUser();
            if (user == null){
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }  else startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }



    }