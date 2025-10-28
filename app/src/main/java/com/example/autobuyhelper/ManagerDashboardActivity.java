package com.example.autobuyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ManagerDashboardActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private Button btnStaff, btnReports, btnCars, btnExport, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_dashboard);

        initViews();
        setupUserInfo();
        setupClickListeners();

        // Отладочное сообщение
        Toast.makeText(this, "Экран руководителя загружен!", Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        tvWelcome = findViewById(R.id.tvWelcome);
        btnStaff = findViewById(R.id.btnStaff);
        btnReports = findViewById(R.id.btnReports);
        btnCars = findViewById(R.id.btnCars);
        btnExport = findViewById(R.id.btnExport);
        btnLogout = findViewById(R.id.btnLogout);
    }

    private void setupUserInfo() {
        String userLogin = getIntent().getStringExtra("USER_LOGIN");
        if (userLogin != null) {
            tvWelcome.setText("Руководитель: " + userLogin + "\nПанель управления");
        } else {
            tvWelcome.setText("Руководитель\nПанель управления");
        }
    }

    private void setupClickListeners() {
        btnStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ManagerDashboardActivity.this, "Экран персонала", Toast.LENGTH_SHORT).show();
            }
        });

        btnReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerDashboardActivity.this, ReportsActivity.class);
                startActivity(intent);
            }
        });

        btnCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerDashboardActivity.this, CarsActivity.class);
                startActivity(intent);
            }
        });

        btnExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ManagerDashboardActivity.this, "Экспорт в Excel выполнен", Toast.LENGTH_SHORT).show();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerDashboardActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}