package com.example.mylris.PRODUCT_INFO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mylris.LRIS_Inventory.Product_Info;
import com.example.mylris.R;


public class  CategoryEdit extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_edit);


        ed1 = findViewById(R.id.catid);
        ed2 = findViewById(R.id.category);
        ed3 = findViewById(R.id.categorydes);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);

        Intent i = getIntent();

        String id = i.getStringExtra("id").toString();
        String category = i.getStringExtra("category").toString();

        String des = i.getStringExtra("catdes").toString();

        ed1.setText(id);
        ed2.setText(category);
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
                Edit();
            }
        });
    }

    public void Edit()
    {
        try
        {

            String catid = ed1.getText().toString();
            String categoryname = ed2.getText().toString();
            String catdescriptionn = ed3.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);


            String sql = "update category set category = ?,catdes=? where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,categoryname);
            statement.bindString(2,catdescriptionn);
            statement.bindString(3,catid);
            statement.execute();
            Toast.makeText(this,"Category Updateee",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), Product_Info.class);
            startActivity(i);
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Category Failed",Toast.LENGTH_LONG).show();
        }

    }


    public void Delete()
    {
        try
        {

            String catid = ed1.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

            String sql = "delete from category where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,catid);
            statement.execute();
            Toast.makeText(this,"Category Deleteddd",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), Product_Info.class);
            startActivity(i);
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Category Failed",Toast.LENGTH_LONG).show();
        }

    }



}


