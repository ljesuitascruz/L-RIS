package com.example.mylris.LRIS_Inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mylris.MainActivity2;
import com.example.mylris.Owner;
import com.example.mylris.PRODUCT_INFO.transactionview;
import com.example.mylris.Profit.Profit;
import com.example.mylris.R;
import com.example.mylris.Expences;
import com.example.mylris.add2;

public class Owner_User extends AppCompatActivity {
    Button b1,b2,b3,b4;
    Button home,xbtn,bckbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_user);
        bckbtn = findViewById(R.id.btn5);
        home = findViewById(R.id.btn6);
        xbtn = findViewById(R.id.btn7);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);


        b1.setOnClickListener((v) -> {
            Intent i = new Intent(Owner_User.this, Profit.class);
            startActivity(i);


        });

        b2.setOnClickListener((v) -> {
            Intent i = new Intent(Owner_User.this, Expences.class);
            startActivity(i);


        });

        b3.setOnClickListener((v) -> {
            Intent i = new Intent(Owner_User.this, transactionview.class);
            startActivity(i);


        });

        b4.setOnClickListener((v) -> {
            Intent i = new Intent(Owner_User.this, Casher_User.class);
            startActivity(i);


        });


        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Owner_User.this, Owner.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Owner_User.this, MainActivity2.class);
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