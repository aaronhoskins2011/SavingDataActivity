package com.example.aaron.savingdataactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    EditText etName;
    EditText etGender;
    Button btnNextActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.data);
        textView = (TextView)findViewById(R.id.tvName);



    }

    public void changeText(View view){
        String dt = editText.getText().toString();
        textView.setText(dt);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String data = textView.getText().toString();

        outState.putString("data", data);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        textView.setText(savedInstanceState.getString("data"));
    }

    public void doSomething(View view){

        switch(view.getId()){
            case R.id.btnChangeText:

            case R.id.btnGotoSecond:
                Intent intent = new Intent(this, SecondActivity.class);
                Person person = new Person("Bob","Male");

                intent.putExtra("person",person);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                intent.setAction("sendingPerson");

                break;
            case R.id.shareData:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is a message");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
        }
    }
}
