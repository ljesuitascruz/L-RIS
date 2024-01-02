package com.example.mylris.PRODUCT_INFO;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mylris.LRIS_Inventory.Product_Info;
import com.example.mylris.R;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class brandedit extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brandedit);

        ed1 = findViewById(R.id.brandid);
        ed2 = findViewById(R.id.brand);
        ed3 = findViewById(R.id.branddes);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);





        Intent i = getIntent();

        String id = i.getStringExtra("id").toString();
        String brand = i.getStringExtra("brand").toString();
        String des = i.getStringExtra("branddes").toString();

        ed1.setText(id);
        ed2.setText(brand);
        ed3.setText(des);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Product_Info.class);
                startActivity(i);
            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Delete();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edit();
            }
        });
    }

    public void edit()
    {
        try
        {

            String brandid = ed1.getText().toString();
            String brandname = ed2.getText().toString();
            String branddescriptionn = ed3.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);


            String sql = "update brand set brand = ?,branddes=? where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,brandname);
            statement.bindString(2,branddescriptionn);
            statement.bindString(3,brandid );
            statement.execute();
            Toast.makeText(this,"brand Updateee",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), Product_Info.class);
            startActivity(i);
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"brand Failed",Toast.LENGTH_LONG).show();
        }

    }

    public void Delete()
    {
        try
        {

            String brandid = ed1.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

            String sql = "delete from brand where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,brandid);
            statement.execute();
            Toast.makeText(this,"Brand Deleteddd",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), Product_Info.class);
            startActivity(i);
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Brand Failed",Toast.LENGTH_LONG).show();
        }


    }

}