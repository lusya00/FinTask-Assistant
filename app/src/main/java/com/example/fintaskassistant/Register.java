package com.example.fintaskassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText etEmail, etPhone, etPassword;
    TextView btnRegister;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.txtemail);
        etPhone = findViewById(R.id.txtphone);
        etPassword = findViewById(R.id.txtpassword);
        btnRegister = findViewById(R.id.txtregis);

        databaseHelper = new DatabaseHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();

                if(email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Register.this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = databaseHelper.addUser(email, phone, password);
                    if (isInserted) {
                        Toast.makeText(Register.this, "Registrasi berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Register.this, "Registrasi gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
