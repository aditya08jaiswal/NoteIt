package com.iam844.adityajaiswal.noteit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();

        //If user is there then login else open Registration page
        updateUI();
    }


    private  void updateUI() {

        if(fAuth.getCurrentUser() != null) {
            Log.i("Main Activity", "fAuth != null");
        }   else {
            Intent startIntent = new Intent(MainActivity.this, StartActivity.class);
            startActivity(startIntent);

            finish();

            Log.i("Main Activity", "fAuth == null");
        }

    }
}
