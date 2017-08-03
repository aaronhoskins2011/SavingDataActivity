package com.example.aaron.savingdataactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView etPersonName;
    TextView etPersonGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        Person person = (Person)intent.getParcelableExtra("person");

        etPersonName = (TextView)findViewById(R.id.etPersonName);
        etPersonGender = (TextView)findViewById(R.id.etPersonGender);



        etPersonName.setText(person.getName());
        etPersonGender.setText(person.getGender());

        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
    }
}
