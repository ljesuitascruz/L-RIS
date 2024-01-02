package com.example.mylris.PRODUCT_INFO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mylris.LRIS_Inventory.Casher_User;
import com.example.mylris.LRIS_Inventory.Product_Info;
import com.example.mylris.MainActivity2;
import com.example.mylris.R;

import java.util.ArrayList;

public class transaction extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4, ed5;
    Button b1, b2;
    Button bckbtn,home,xbtn;
    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        ed1 = findViewById(R.id.pid);
        ed2 = findViewById(R.id.pname);
        ed3 = findViewById(R.id.proqyt);
        ed4 = findViewById(R.id.proprice);
        ed5 = findViewById(R.id.total);


        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);

        bckbtn = findViewById(R.id.btn17);
        home = findViewById(R.id.btn18);
        xbtn = findViewById(R.id.btn19);

        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transaction.this, Casher_User.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transaction.this, MainActivity2.class);
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


        ed3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int pqty = 0;
                int price = 0;
                int tot = 0;

                try {
                    pqty = Integer.parseInt(ed3.getText().toString());
                    price = Integer.parseInt(ed4.getText().toString());

                    tot = pqty * price;
                    // Continue with the rest of your logic
                } catch (NumberFormatException e) {
                    // Handle the case where the input is not a valid integer
                    //Toast.makeText(pos.this, "!", Toast.LENGTH_SHORT).show();
                    // or handle the error in an appropriate way for your application
                }

                ed5.setText(String.valueOf(tot));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();

            }
        });
    }

    public void search()
    {
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE, null);
        String id = ed1.getText().toString();
        final Cursor c = db.rawQuery("select * from product where id='" +id+"' ", null);
        int proname = c.getColumnIndex("product");
        int qty = c.getColumnIndex("qty");
        int price = c.getColumnIndex("price");

        titles.clear();

        final ArrayList<productview1> product1 = new ArrayList<productview1>();
        if (c.moveToFirst())
        {
            do {
                productview1 stu = new productview1();
                stu.product = c.getString(proname);
                stu.qty = c.getString(qty);
                stu.price = c.getString(price);
                product1.add(stu);

                ed2.setText(c.getString(proname));
                ed4.setText(c.getString(price));

            } while (c.moveToNext());


        }
    }


    public void insert() {
        try {
            int qty1 = 0;
            String proid = ed1.getText().toString();
            String proname = ed2.getText().toString();
            qty1 = Integer.parseInt(ed3.getText().toString().trim());
            String price = ed4.getText().toString();
            String totall = ed5.getText().toString();


            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE, null);
            String id = ed1.getText().toString();
            final Cursor c = db.rawQuery("select * from product where id='" + id + "'", null);
            int qty = c.getColumnIndex("qty");

            final ArrayList<productview1> product1 = new ArrayList<productview1>();
            if (c.moveToFirst()) {
                do {
                    productview1 stu = new productview1();

                    stu.qty = c.getString(qty);

                    product1.add(stu);
                    int oldqty = 0;
                    oldqty = Integer.parseInt(c.getString(qty));


                    if (qty1 > oldqty) {
                        Toast.makeText(transaction.this, String.valueOf(oldqty), Toast.LENGTH_LONG).show();
                        Toast.makeText(this, "Qty is not enough", Toast.LENGTH_LONG).show();
                        ed3.setText("");
                    } else {

                        db.execSQL("CREATE TABLE IF NOT EXISTS posss(proid VARCHAR,proname VARCHAR,qty VARCHAR,price VARCHAR,total VARCHAR)");

                        String sql = "insert into posss (proid,proname,qty,price,total)values(?,?,?,?,?)";
                        SQLiteStatement statement = db.compileStatement(sql);
                        statement.bindString(1, proid);
                        statement.bindString(2, proname);
                        statement.bindLong(3, qty1);
                        statement.bindString(4, price);
                        statement.bindString(5, totall);
                        statement.execute();

                        String sql1 = "update product set qty =qty - ? where id= ?";
                        SQLiteStatement statement1 = db.compileStatement(sql1);
                        statement1.bindLong(1, qty1);
                        statement1.bindString(2, proid);
                        statement1.execute();

                        Toast.makeText(this, "Item ordered successfully!", Toast.LENGTH_SHORT).show();
                    }
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show();
        }
    }

    // Existing code...
}