package com.example.autobuyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvProfileInfo;
    private Button btnBack, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();
        setupProfileInfo();
        setupClickListeners();
    }

    private void initViews() {
        tvProfileInfo = findViewById(R.id.tvProfileInfo);
        btnBack = findViewById(R.id.btnBack);
        btnLogout = findViewById(R.id.btnLogout);
    }

    private void setupProfileInfo() {
        String userRole = getIntent().getStringExtra("USER_ROLE");
        String userLogin = getIntent().getStringExtra("USER_LOGIN");

        String profileText = "Профиль пользователя\n\n" +
                "Логин: " + userLogin + "\n" +
                "Роль: " + userRole + "\n" +
                "Дата регистрации: 01.01.2024\n" +
                "Статус: Активен";

        tvProfileInfo.setText(profileText);
    }

    private void setupClickListeners() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Возврат на предыдущий экран
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}