package com.example.autobuyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etLogin, etPassword;
    private Button btnLogin;
    private TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
    }

    private void setupClickListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void attemptLogin() {
        String login = etLogin.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (login.isEmpty() || password.isEmpty()) {
            showToast("Пожалуйста, заполните все поля");
            return;
        }

        if (isValidCredentials(login, password)) {
            String role = getRole(login);
            showToast("Успешный вход! Добро пожаловать, " + role);

            // Переход на разные экраны в зависимости от роли
            openRoleSpecificDashboard(role, login);
        } else {
            showToast("Неверный логин или пароль");
        }
    }

    private boolean isValidCredentials(String login, String password) {
        return (login.equals("manager") && password.equals("AutoBuy2024!")) ||
                (login.equals("employee") && password.equals("Helper123!")) ||
                (login.equals("client") && password.equals("ClientPass123!"));
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
                return "Пользователь";
        }
    }

    private void openRoleSpecificDashboard(String role, String login) {
        Intent intent;

        switch (role) {
            case "Руководитель":
                // Вторая фотография - экран руководителя (персонал + отчеты)
                intent = new Intent(this, ManagerDashboardActivity.class);
                break;
            case "Сотрудник":
                // Первая фотография - экран сотрудника (автомобили + сделки)
                intent = new Intent(this, EmployeeDashboardActivity.class);
                break;
            case "Клиент":
                // Третья фотография - экран клиента (каталог автомобилей)
                intent = new Intent(this, ClientDashboardActivity.class);
                break;
            default:
                intent = new Intent(this, UserDashboardActivity.class);
        }

        intent.putExtra("USER_ROLE", role);
        intent.putExtra("USER_LOGIN", login);
        startActivity(intent);
        finish(); // Закрываем экран авторизации
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}