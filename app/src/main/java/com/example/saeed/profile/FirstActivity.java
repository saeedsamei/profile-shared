package com.example.saeed.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        final TextView txtname = findViewById(R.id.name);
        final TextView txtfamily = findViewById(R.id.family);
        final TextView txtage = findViewById(R.id.age);
        final TextView txtemail = findViewById(R.id.email);
        final TextView txtnumber = findViewById(R.id.number);

        Intent intent=getIntent();
        String n = intent.getStringExtra("Txt0");
        String f = intent.getStringExtra("Txt1");
        String a = intent.getStringExtra("Txt2");
        String e = intent.getStringExtra("Txt3");
        String p = intent.getStringExtra("Txt4");

        txtname.setText(n);
        txtfamily.setText(f);
        txtage.setText(a);
        txtemail.setText(e);
        txtnumber.setText(p);




    }
}


