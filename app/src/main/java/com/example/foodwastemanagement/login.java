package com.example.foodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView signup_link = (TextView) findViewById(R.id.signup);
        TextView errosr = (TextView) findViewById(R.id.error);
        EditText username=(EditText) findViewById(R.id.f_name);
        EditText pasword=(EditText) findViewById(R.id.pwd);
        Button btn=(Button) findViewById(R.id.login);
//        database db=new database(login.this);

        try{
            database db=new database(this);
            errosr.setText("Sucees");
        }catch (Exception e){
            errosr.setText("Error"+e);
        }

      signup_link.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent ob = new Intent(login.this,signup.class);
              startActivity(ob);
          }
      });



//      btn.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//              if(!(username.getText().toString().equals("") && pasword.getText().toString().equals(""))) {
//                  if(db.login(username.getText().toString(), pasword.getText().toString()))
//                  {
//                      Toast.makeText(login.this,"Successfully Logged In", Toast.LENGTH_LONG).show();
//                      Intent log = new Intent(login.this, dashboard.class);
//                      startActivity(log);
//                  }else{
//                      Toast.makeText(login.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();
//                  }
//
//              }else{
//                  Toast.makeText(login.this, "Please Fill all fields", Toast.LENGTH_SHORT).show();
//              }
//
//          }
//      });

    }
}