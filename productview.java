package com.example.mylris.PRODUCT_INFO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.mylris.LRIS_Inventory.Product_Info;
import com.example.mylris.MainActivity2;
import com.example.mylris.R;

import java.util.ArrayList;

public class productview extends AppCompatActivity {

    ListView list1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    Button bckbtn,home,xbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productview);

        bckbtn = findViewById(R.id.btn17);
        home = findViewById(R.id.btn18);
        xbtn = findViewById(R.id.btn19);

        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(productview.this, product.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(productview.this, MainActivity2.class);
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

        list1 = findViewById(R.id.list1);
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

        final Cursor c = db.rawQuery("select * from product",null);
        int id = c.getColumnIndex("id");
        int product = c.getColumnIndex("product");
        int productdes = c.getColumnIndex("productdes");
        int category = c.getColumnIndex("category");
        int brand = c.getColumnIndex("brand");
        int qty = c.getColumnIndex("qty");
        int price = c.getColumnIndex("price");


        titles.clear();

        arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,titles);
        list1.setAdapter(arrayAdapter);

        final ArrayList<prod> produ = new ArrayList<prod>();
        if(c.moveToFirst())
        {
            do {
                prod pr = new prod();
                pr.id = c.getString(id);
                pr.product = c.getString(product);
                pr.category = c.getString(category);
                pr.brand = c.getString(brand);
                pr.qty = c.getString(qty);
                pr.price = c.getString(price);

                produ.add(pr);

                titles.add(c.getString(id) + "\t" + c.getString(product) + "\t" + c.getString(category)+ "\t"  + c.getString(brand) + "\t" + c.getString(qty) + "\t" + c.getString(price) + "\t"  );

            }while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            list1.invalidateViews();

        }


    }
}