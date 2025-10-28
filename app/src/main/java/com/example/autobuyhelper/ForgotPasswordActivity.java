package com.example.autobuyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText etRecoveryLogin;
    private Button btnRecoverPassword, btnBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        etRecoveryLogin = findViewById(R.id.etRecoveryLogin);
        btnRecoverPassword = findViewById(R.id.btnRecoverPassword);
        btnBackToLogin = findViewById(R.id.btnBackToLogin);
    }

    private void setupClickListeners() {
        btnRecoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoverPassword();
            }
        });

        btnBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void recoverPassword() {
        String login = etRecoveryLogin.getText().toString().trim();

        if (login.isEmpty()) {
            showToast("Пожалуйста, введите ваш логин");
            return;
        }

        String password = findPasswordByLogin(login);

        if (password != null) {
            String role = getRole(login);
            showToast("Логин: " + login + "\nПароль: " + password + "\nРоль: " + role + "\n\nСохраните данные в надежном месте!");
        } else {
            showToast("Пользователь с таким логином не найден");
        }
    }

    private String findPasswordByLogin(String login) {
        switch (login) {
            case "manager":
                return "AutoBuy2024!";
            case "employee":
                return "Helper123!";
            case "client":
                return "ClientPass123!";
            default:
                return null;
        }
    }

    private String getRole(String login) {
        switch (login) {
            case "manager":
                return "Руководитель";
            case "employee":
                return "Сотрудник";
            case "client":
                return "Клиент";
            default:
                return "Неизвестная роль";
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}