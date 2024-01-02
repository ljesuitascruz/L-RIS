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

import com.example.mylris.LRIS_Inventory.Owner_User;
import com.example.mylris.LRIS_Inventory.Product_Info;
import com.example.mylris.MainActivity2;
import com.example.mylris.R;

import java.util.ArrayList;

public class transactionview extends AppCompatActivity {

    ListView list1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    Button bckbtn,home,xbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactionview);


        bckbtn = findViewById(R.id.btn17);
        home = findViewById(R.id.btn18);
        xbtn = findViewById(R.id.btn19);

        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transactionview.this, Owner_User.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transactionview.this, MainActivity2.class);
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


        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

        list1 = findViewById(R.id.list1);
        final Cursor c = db.rawQuery("select * from posss",null);
        int proid = c.getColumnIndex("proid");
        int proname = c.getColumnIndex("proname");
        int qty = c.getColumnIndex("qty");
        int price = c.getColumnIndex("price");
        int total = c.getColumnIndex("total");

        titles.clear();

        arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,titles);
        list1.setAdapter(arrayAdapter);

        final ArrayList<productview1> product1 = new ArrayList<productview1>();
        if(c.moveToFirst())
        {
            do {
                productview1 stu = new productview1();
                stu.id = c.getString(proid);
                stu.product = c.getString(proname);
                stu.qty = c.getString(qty);
                stu.price = c.getString(price);
                stu.total = c.getString(total);

                product1.add(stu);

                titles.add(c.getString(proid) + "\t" + c.getString(proname) + "\t" + c.getString(qty)+ "\t"  + c.getString(price) + "\t" + c.getString(total)+ "\t"   );

            }while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            list1.invalidateViews();

        }


    }
}