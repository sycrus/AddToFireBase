package com.example.joe.addtofirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference personRef = database.getReference("person"); //add
    private DatabaseReference titleRef = database.getReference("title"); //set

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button titleButton = (Button) findViewById(R.id.title_button);
        titleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText title = (EditText) findViewById(R.id.title_text);
                titleRef.setValue(title.getText().toString());
            }

        });


        Button personButton = (Button) findViewById(R.id.person_button);
        personButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.name_text);
                EditText age = (EditText) findViewById(R.id.age_text);
                CheckBox isAlive = (CheckBox) findViewById(R.id.alive_checkbox);

                String putName = name.getText().toString();
                int putAge = Integer.valueOf(age.getText().toString());
                boolean putIsAlive = isAlive.isChecked();
                Person person = new Person(putName, putAge, putIsAlive);
                personRef.push().setValue(person);
            }
        });

    }
    /*
    public void set(View view) {
        Log.d("OnClick", "Set");
        personRef.setValue(new Person("Hello",13, true));
    }
    */
}

