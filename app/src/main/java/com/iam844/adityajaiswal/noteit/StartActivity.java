package com.iam844.adityajaiswal.noteit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.iam844.adityajaiswal.noteit.user_sign.LoginActivity;
import com.iam844.adityajaiswal.noteit.user_sign.RegisterActivity;

public class StartActivity extends AppCompatActivity {

    private Button btnReg, btnLog;

    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnReg = findViewById(R.id.start_reg_btn);
        btnLog = findViewById(R.id.start_log_btn);

        fAuth = FirebaseAuth.getInstance();

        updateUI();

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    private void register() {

        Intent regIntent = new Intent(StartActivity.this, RegisterActivity.class);
        startActivity(regIntent);

    }

    private void login() {

        Intent logIntent = new Intent(StartActivity.this, LoginActivity.class);
        startActivity(logIntent);
    }

    private  void updateUI() {

        if (fAuth.getCurrentUser() != null) {

            Log.i("Start Activity", "fAuth != null");

            Intent startIntent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(startIntent);

            finish();
        } else {
            Log.i("Start Activity", "fAuth == null");
        }
    }
}
