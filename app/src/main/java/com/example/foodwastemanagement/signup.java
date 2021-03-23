package com.example.foodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText f_n=(EditText) findViewById(R.id.first_name);
        EditText l_n=(EditText) findViewById(R.id.last_name);
        EditText email=(EditText) findViewById(R.id.email);
        EditText pass=(EditText) findViewById(R.id.password);
        Button insert=(Button) findViewById(R.id.signup_btn);

        database db=new database(signup.this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(f_n.getText().toString().equals("") ||l_n.getText().toString().equals("")||pass.getText().toString().equals("") || email.getText().toString().equals(""))){
                    boolean inseruser=db.userinsert(f_n.getText().toString(),l_n.getText().toString(),email.getText().toString(), pass.getText().toString());
                    if(inseruser == true) {
                        Toast.makeText(signup.this, "success", Toast.LENGTH_SHORT).show();
                        Intent ob = new Intent(signup.this,login.class);
                        startActivity(ob);
                        finish();
                    }else {
                        Toast.makeText(signup.this, "Your are not Signup", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(signup.this, "Please Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}