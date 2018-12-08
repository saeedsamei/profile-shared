package com.example.saeed.profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        String n;
        String f;
        String a;
        String e;
        String p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editname = findViewById(R.id.name);
        final EditText editfamily = findViewById(R.id.family);
        final EditText editage = findViewById(R.id.age);
        final EditText editemail = findViewById(R.id.email);
        final EditText editnumber = findViewById(R.id.number);

        Button button1=findViewById(R.id.btnExit);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog();
            }
        });

        final Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 n = editname.getText().toString();
                 f = editfamily.getText().toString();
                 a = editage.getText().toString();
                 e = editemail.getText().toString();
                 p = editnumber.getText().toString();
                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                intent.putExtra("Txt0",n);
                intent.putExtra("Txt1",f);
                intent.putExtra("Txt2",a);
                intent.putExtra("Txt3",e);
                intent.putExtra("Txt4",p);
                startActivityForResult(intent,150);
            }
        });

    }

    public void alertDialog(){
        final android.app.AlertDialog alertDialog=new android.app.AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setIcon(R.mipmap.ic_shortcut_exit_to_app);
        alertDialog.setTitle("Leave application?");
        alertDialog.setMessage("Are you sure you want to leave the application?");


        alertDialog.setButton(android.app.AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.cancel();
            }
        });
        alertDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==150){
            if(resultCode==RESULT_OK){
                String result=data.getStringExtra("result");
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("name",n).apply();
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("family",f).apply();
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("Age",a).apply();
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("Email",e).apply();
                PreferenceManager.getDefaultSharedPreferences(this).edit().putString("phone",p).apply();
                Toast.makeText(this,result,Toast.LENGTH_LONG).show();

            }
        }
    }
}
