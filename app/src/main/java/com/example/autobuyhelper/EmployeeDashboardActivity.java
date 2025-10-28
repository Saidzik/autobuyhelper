package com.example.autobuyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.autobuyhelper.adapters.DealAdapter;
import com.example.autobuyhelper.models.Deal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmployeeDashboardActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private Button btnCars, btnDeals, btnAddCar, btnAddDeal, btnLogout;
    private RecyclerView recyclerViewDeals;
    private DealAdapter dealAdapter;
    private String userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dashboard);

        initViews();
        setupUserInfo();
        setupDealsList();
        setupClickListeners();
    }

    private void initViews() {
        tvWelcome = findViewById(R.id.tvWelcome);
        btnCars = findViewById(R.id.btnCars);
        btnDeals = findViewById(R.id.btnDeals);
        btnAddCar = findViewById(R.id.btnAddCar);
        btnAddDeal = findViewById(R.id.btnAddDeal);
        btnLogout = findViewById(R.id.btnLogout);
        recyclerViewDeals = findViewById(R.id.recyclerViewDeals);
    }

    private void setupUserInfo() {
        userLogin = getIntent().getStringExtra("USER_LOGIN");
        tvWelcome.setText("Сотрудник: " + userLogin + "\nПанель управления");
    }

    private void setupDealsList() {
        List<Deal> dealList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

        try {
            dealList.add(new Deal("1", "Ford Focus", sdf.parse("01.05.2024"), 1100000, "Иван Петров"));
            dealList.add(new Deal("2", "BMW 320I", sdf.parse("23.04.2024"), 3500000, "Анна Сидорова"));
            dealList.add(new Deal("3", "Audi A4", sdf.parse("15.04.2024"), 2800000, "Петр Иванов"));
            dealList.add(new Deal("4", "Volkswagen Passat", sdf.parse("12.04.2024"), 1900000, "Мария Козлова"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        dealAdapter = new DealAdapter(dealList);
        recyclerViewDeals.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDeals.setAdapter(dealAdapter);
    }

    private void setupClickListeners() {
        btnCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDashboardActivity.this, CarsActivity.class);
                startActivity(intent);
            }
        });

        btnDeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDashboardActivity.this, DealsActivity.class);
                startActivity(intent);
            }
        });

        btnAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDashboardActivity.this, AddCarActivity.class);
                startActivity(intent);
            }
        });

        btnAddDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDashboardActivity.this, AddDealActivity.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDashboardActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
