package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Admin.AdminCategoryActivity;
import com.example.myapplication.Model.Users;
import com.example.myapplication.Prevalent.Prevalent;
import com.example.myapplication.Users.HomeActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText usernameInput, phoneInput, passwordInput;
    private ProgressDialog loadingBar;
    private TextView AdminLink, NotAdminLink;

    private String parentDBName = "Users";
    private CheckBox checkBoxRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.login_btn);
        phoneInput = (EditText) findViewById(R.id.login_phone_input);
        passwordInput = (EditText) findViewById(R.id.login_password_input);
        loadingBar = new ProgressDialog(this);
        checkBoxRememberMe = (CheckBox)findViewById(R.id.login_checkbox);
        Paper.init(this);

        AdminLink = (TextView)findViewById(R.id.admin_panel_link);
        NotAdminLink = (TextView)findViewById(R.id.not_admin_panel_link);

        loginBtn.setOnClickListener((v) -> { loginUser(); });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                loginBtn.setText("Вход для админа");
                parentDBName = "Admins";
            }
        });

        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                loginBtn.setText("Войти");
                parentDBName = "Users";
            }
        });

    }

    private void loginUser() {
        String phone = phoneInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Введите номер", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Введите пароль", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("Вход в приложение");
            loadingBar.setMessage("Пожалуйста подождите...");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            ValidateUser(phone, password);
        }


    }

    private void ValidateUser(String phone, String password) {

        if(checkBoxRememberMe.isChecked()){
            Paper.book().write(Prevalent.UserPhoneKey, phone);
            Paper.book().write(Prevalent.UserPasswordKey, password);
        }

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(parentDBName).child(phone).exists())
                {
                    Users usersData = dataSnapshot.child(parentDBName).child(phone).getValue(Users.class);

                    if(usersData.getPhone().equals(phone))
                    {
                        if(usersData.getPassword().equals(password))
                        {
                            if(parentDBName.equals("Users")){
                                loadingBar.dismiss();
                                Toast.makeText(LoginActivity.this, "Успешный вход!", Toast.LENGTH_SHORT).show();

                                Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(homeIntent);
                            }
                            else if(parentDBName.equals("Admins")) {
                                loadingBar.dismiss();
                                Toast.makeText(LoginActivity.this, "Успешный вход!", Toast.LENGTH_SHORT).show();

                                Intent homeIntent = new Intent(LoginActivity.this, AdminCategoryActivity.class);
                                startActivity(homeIntent);
                            }
                        }
                        else
                        {
                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this, "Неверный пароль", Toast.LENGTH_SHORT).show();
                        }
                    }


                }
                else
                {
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity.this, "Аккаунт с номером " + phone + "не существует", Toast.LENGTH_SHORT).show();

                    Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(registerIntent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}