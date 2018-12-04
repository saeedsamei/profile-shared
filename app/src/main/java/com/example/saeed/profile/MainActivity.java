package com.example.saeed.profile;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editname = findViewById(R.id.name);
        final EditText editfamily = findViewById(R.id.family);
        final EditText editage = findViewById(R.id.age);
        final EditText editemail = findViewById(R.id.email);
        final EditText editnumber = findViewById(R.id.number);
        Button button = findViewById(R.id.btn);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"send",Toast.LENGTH_LONG).show();
                String n = editname.getText().toString();
                String f = editfamily.getText().toString();
                String a = editage.getText().toString();
                String e = editemail.getText().toString();
                String p = editnumber.getText().toString();
                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                intent.putExtra("Txt0",n);
                intent.putExtra("Txt1",f);
                intent.putExtra("Txt2",a);
                intent.putExtra("Txt3",e);
                intent.putExtra("Txt4",p);

                startActivity(intent);
            }
        });


    }
}
