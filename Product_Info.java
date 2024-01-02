package com.example.mylris.LRIS_Inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mylris.MainActivity2;
import com.example.mylris.PRODUCT_INFO.Category;
import com.example.mylris.PRODUCT_INFO.Categoryview;
import com.example.mylris.PRODUCT_INFO.brand;
import com.example.mylris.PRODUCT_INFO.brandview;
import com.example.mylris.R;

public class Product_Info extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;

    Button home,xbtn,bckbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);

        bckbtn = findViewById(R.id.btn17);
        home = findViewById(R.id.btn18);
        xbtn = findViewById(R.id.btn19);


        b1.setOnClickListener((v) -> {
            Intent i = new Intent(Product_Info.this, Category.class);
            startActivity(i);


        });

        b2.setOnClickListener((v) -> {
            Intent i = new Intent(Product_Info.this, Categoryview.class);
            startActivity(i);


        });

        b3.setOnClickListener((v) -> {
            Intent i = new Intent(Product_Info.this, brand.class);
            startActivity(i);


        });
        b4.setOnClickListener((v) -> {
            Intent i = new Intent(Product_Info.this, brandview.class);
            startActivity(i);


        });





        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Product_Info.this, Casher_User.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Product_Info.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        xbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });


    }
}

