package com.example.foodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class myevent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myevent);
        EditText eventname=(EditText) findViewById(R.id.eventname);
        EditText location  =(EditText) findViewById(R.id.location);
        Button addev=(Button) findViewById(R.id.insertevent);

        database db=new database(myevent.this);

        addev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(eventname.getText().toString().equals("") || location.getText().toString().equals(""))){
                  boolean add=  db.insertenvent(eventname.getText().toString(),location.getText().toString());
                  if(add== true){
                      Toast.makeText(myevent.this, "Add Event", Toast.LENGTH_SHORT).show();
                      eventname.setText("");
                      location.setText("");
                  }else{
                      Toast.makeText(myevent.this, "Event not Add", Toast.LENGTH_SHORT).show();
                  }
                }else {
                    Toast.makeText(myevent.this, "Please fill all fileds", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}