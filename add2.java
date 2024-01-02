package com.example.mylris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mylris.LRIS_Inventory.Casher_User;
import com.example.mylris.LRIS_Inventory.Owner_User;

public class add2 extends AppCompatActivity {

    EditText ed1,ed2;
    Button button_add,button_view,home,xbtn,bckbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);

        ed1 = findViewById(R.id.edittext_name);
        ed2 = findViewById(R.id.edittext_email);
        button_add = findViewById(R.id.button_add);
        bckbtn = findViewById(R.id.button);
        home = findViewById(R.id.button1);
        xbtn = findViewById(R.id.button2);



        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = ed1.getText().toString();
                String stringEmail = ed2.getText().toString();

                if (stringName.length() <=0 || stringEmail.length() <=0){
                    Toast.makeText(add2.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(add2.this);
                    ModelClass employeeModelClass = new ModelClass(stringName,stringEmail);
                    databaseHelperClass.addEmployee(employeeModelClass);
                    Toast.makeText(add2.this, "Enter Expenses Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add2.this, Casher_User.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add2.this,MainActivity2.class);
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