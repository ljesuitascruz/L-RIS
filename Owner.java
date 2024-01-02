package com.example.mylris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylris.LRIS_Inventory.Owner_User;
import com.google.android.material.button.MaterialButton;

public class Owner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);


        TextView txt = findViewById(R.id.bck);


        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("") && password.getText().toString().equals("")){
                    //correct
                    Toast.makeText(Owner.this,"LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Owner_User.class);
                    Toast.makeText(getApplicationContext(),"LOG IN SUCCESSFULLY",Toast.LENGTH_LONG).show();
                    startActivity(intent);


                }else
                    //incorrect
                    Toast.makeText(Owner.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();

            }
        });

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Owner.this, MainActivity2.class);
                startActivity(intent3);
            }
        });


    }
}