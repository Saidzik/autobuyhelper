package com.example.autobuyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.autobuyhelper.adapters.CarAdapter;
import com.example.autobuyhelper.models.Car;
import java.util.ArrayList;
import java.util.List;

public class CarsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCars;
    private CarAdapter carAdapter;
    private List<Car> carList;
    private Button btnAddCar, btnBack;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        initViews();
        setupCarList();
        setupRecyclerView();
        setupClickListeners();
        setupSearchView();
    }

    private void initViews() {
        recyclerViewCars = findViewById(R.id.recyclerViewCars);
        btnAddCar = findViewById(R.id.btnAddCar);
        btnBack = findViewById(R.id.btnBack);
        searchView = findViewById(R.id.searchView);
    }

    private void setupCarList() {
        carList = new ArrayList<>();
        // Пример данных
        carList.add(new Car("1", "Toyota", "Camry", 2022, "1H06M92013X004832",
                2200000, 0, "В наличии", ""));
        carList.add(new Car("2", "Ford", "Focus", 2021, "enr6prjUSMBIT8892",
                1100000, 15000, "В наличии", ""));
        carList.add(new Car("3", "BMW", "3 серии", 2021, "suXzwdycbq20a9023",
                3500000, 25000, "В наличии", ""));
        carList.add(new Car("4", "Mercedes-Benz", "C-Class", 2020, "MB123456789",
                2500000, 25000, "В наличии", ""));
        carList.add(new Car("5", "Hyundai", "Tucson", 2022, "HY987654321",
                2100000, 15000, "Ожидание", ""));
    }

    private void setupRecyclerView() {
        carAdapter = new CarAdapter(carList);
        recyclerViewCars.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCars.setAdapter(carAdapter);
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                carAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void setupClickListeners() {
        btnAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarsActivity.this, AddCarActivity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
