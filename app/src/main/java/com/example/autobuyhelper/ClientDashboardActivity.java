package com.example.autobuyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.autobuyhelper.adapters.CarAdapter;
import com.example.autobuyhelper.models.Car;
import java.util.ArrayList;
import java.util.List;

public class ClientDashboardActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private Button btnSearch, btnFilters, btnProfile, btnLogout;
    private RecyclerView recyclerViewCars;
    private CarAdapter carAdapter;
    private String userRole, userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_dashboard);

        initViews();
        setupUserInfo();
        setupCarsList();
        setupClickListeners();
    }

    private void initViews() {
        tvWelcome = findViewById(R.id.tvWelcome);
        btnSearch = findViewById(R.id.btnSearch);
        btnFilters = findViewById(R.id.btnFilters);
        btnProfile = findViewById(R.id.btnProfile);
        btnLogout = findViewById(R.id.btnLogout);
        recyclerViewCars = findViewById(R.id.recyclerViewCars);
    }

    private void setupUserInfo() {
        userRole = getIntent().getStringExtra("USER_ROLE");
        userLogin = getIntent().getStringExtra("USER_LOGIN");
        tvWelcome.setText("Клиент: " + userLogin + "\nКаталог автомобилей");
    }

    private void setupCarsList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("1", "Mercedes-Benz", "C-Class", 2020, "MB123456789",
                2500000, 25000, "В наличии", ""));
        carList.add(new Car("2", "Hyundai", "Tucson", 2022, "HY987654321",
                2100000, 15000, "Ожидание", ""));
        carList.add(new Car("3", "Mazda", "CX-5", 2022, "MZ123456789",
                2300000, 15000, "В наличии", ""));

        carAdapter = new CarAdapter(carList);
        recyclerViewCars.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCars.setAdapter(carAdapter);
    }

    private void setupClickListeners() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.widget.Toast.makeText(ClientDashboardActivity.this, "Поиск автомобилей", android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        btnFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.widget.Toast.makeText(ClientDashboardActivity.this, "Фильтры", android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientDashboardActivity.this, ProfileActivity.class);
                intent.putExtra("USER_ROLE", userRole);
                intent.putExtra("USER_LOGIN", userLogin);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientDashboardActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}