package com.example.myapplication.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.R;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView car, motorbike, ship, maintenance;
    private ImageView dress, tshirt, jeans, shoes;
    private ImageView fridge, laptop, smartphone, pc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        init();


        fridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "fridge");
                startActivity(intent);
            }
        });

        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "laptop");
                startActivity(intent);
            }
        });

        pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "pc");
                startActivity(intent);
            }
        });

        smartphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "phone");
                startActivity(intent);
            }
        });

        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "tshirt");
                startActivity(intent);
            }
        });

        jeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "jeans");
                startActivity(intent);
            }
        });

        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "shoes");
                startActivity(intent);
            }
        });

        dress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "dress");
                startActivity(intent);
            }
        });

        maintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "maintenance");
                startActivity(intent);
            }
        });

        ship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "ship");
                startActivity(intent);
            }
        });

        motorbike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "motorbike");
                startActivity(intent);
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "car");
                startActivity(intent);
            }
        });
    }

    private void init() {
        car = findViewById(R.id.car);
        motorbike = findViewById(R.id.moto);
        ship = findViewById(R.id.boat);
        maintenance = findViewById(R.id.car_service);

        dress = findViewById(R.id.dress);
        tshirt = findViewById(R.id.t_shirt);
        jeans = findViewById(R.id.pants);
        shoes = findViewById(R.id.shoes);

        fridge = findViewById(R.id.fridge);
        laptop = findViewById(R.id.laptop);
        smartphone = findViewById(R.id.phone);
        pc = findViewById(R.id.pc);

    }
}