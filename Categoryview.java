package com.example.mylris.PRODUCT_INFO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.mylris.LRIS_Inventory.Product_Info;
import com.example.mylris.MainActivity2;
import com.example.mylris.R;

import java.util.ArrayList;

public class Categoryview extends AppCompatActivity {

    ListView list1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    Button bckbtn,home,xbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryview);
//Universal Guide
        bckbtn = findViewById(R.id.btn17);
        home = findViewById(R.id.btn18);
        xbtn = findViewById(R.id.btn19);

        //Button for Back,Home,Exit
        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categoryview.this, Product_Info.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categoryview.this, MainActivity2.class);
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
//Data base For Listing all data
        list1 = findViewById(R.id.list1);
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE, null);

        final Cursor c = db.rawQuery("select * from category", null);
        int id = c.getColumnIndex("id");
        int category = c.getColumnIndex("category");
        int catedes = c.getColumnIndex("catdes");

        titles.clear();

        arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, titles);
        list1.setAdapter(arrayAdapter);

        final ArrayList<cate> catee = new ArrayList<cate>();
        if (c.moveToFirst()) {
            do {
                cate ca = new cate();
                ca.id = c.getString(id);
                ca.category = c.getString(category);
                ca.des = c.getString(catedes);
                catee.add(ca);

                titles.add(c.getString(id) + "\t" + c.getString(category) + "\t" + c.getString(catedes));

            } while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            list1.invalidateViews();

        }
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String aaa = titles.get(position).toString();
                cate ca = catee.get((position));
                Intent i = new Intent(getApplicationContext(), CategoryEdit.class);
                i.putExtra("id", ca.id);
                i.putExtra("category", ca.category);
                i.putExtra("catdes", ca.des);
                startActivity(i);
            }
        });

    }
}

