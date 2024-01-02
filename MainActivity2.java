package com.example.mylris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylris.LRIS_Inventory.Casher_User;
import com.example.mylris.LRIS_Inventory.Owner_User;

public class MainActivity2 extends AppCompatActivity {

    TextView twv1,tvw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView button3 =findViewById(R.id.image);

         twv1 =findViewById(R.id.textView15);
        tvw2=findViewById(R.id.textView16);


        twv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity2.this, Owner.class);
                startActivity(intent3);
            }
        });
        tvw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity2.this, Casher.class);
                startActivity(intent3);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity2.this, recordpurchased.class);
                startActivity(intent3);
            }
        });
    }
}