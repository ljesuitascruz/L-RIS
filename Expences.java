package com.example.mylris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mylris.Profit.Profit;
import com.example.mylris.Profit.Profitview;

import java.util.List;

public class Expences extends AppCompatActivity {
    Button b1, b2, b3;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expences);



        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<ModelClass> employeeModelClasses = databaseHelperClass.getEmployeeList();

        if (employeeModelClasses.size() > 0){
            AdapterClass employeadapterclass = new AdapterClass(employeeModelClasses, Expences.this);
            recyclerView.setAdapter(employeadapterclass);
        }else {
            Toast.makeText(this, "L-ris", Toast.LENGTH_SHORT).show();
        }






    }
}