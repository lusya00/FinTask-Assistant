package com.example.fintaskassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText etEmail, etPassword;
    TextView btnLogin;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.txtemaillogin);
        etPassword = findViewById(R.id.txtpasswordlogin);
        btnLogin = findViewById(R.id.btnlogin);

        databaseHelper = new DatabaseHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Email dan Password harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isUserExist = databaseHelper.checkUser(email, password);
                    if (isUserExist) {
                        Toast.makeText(Login.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                        // Redirect to another activity, e.g., HomeActivity
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Login.this, "Email atau Password salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
