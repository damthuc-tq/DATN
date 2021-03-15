package com.example.iwash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignUpActivity extends AppCompatActivity {
    TextInputEditText edName, edPhone, edPassword, edAddress;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        changeStatusBarColor();
        initView();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerAccount();
            }
        });
    }

    private void initView() {
        edName = findViewById(R.id.edName);
        edPhone = findViewById(R.id.edPhone);
        edPassword = findViewById(R.id.edPassword);
        edAddress = findViewById(R.id.edAddress);
        btnRegister = findViewById(R.id.btnRegister);

    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    public void onLoginClick(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    private void registerAccount() {
        if (!edName.getText().toString().isEmpty() && !edPhone.getText().toString().isEmpty() || !edAddress.getText().toString().isEmpty() || !edPassword.getText().toString().isEmpty()) {
            Intent intent = new Intent(SignUpActivity.this, VerifyPhoneActivity.class);
            String phone_number = "+84" + edPhone.getText().toString().trim();
            intent.putExtra("phone_number", phone_number);
            intent.putExtra("name", edName.getText().toString());
            intent.putExtra("address", edAddress.getText().toString());
            intent.putExtra("password", edPassword.getText().toString());
            startActivity(intent);
        } else {

        }
    }
}