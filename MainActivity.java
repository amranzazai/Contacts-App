package com.example.assignment7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Declaring add and view buttons
    Button mAddButton;
    Button mViewButton;
    //Declaring database
    Database database1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Using activity main as our xml layout file
        setContentView(R.layout.activity_main);

        //set database1 to a new Database
        database1 = new Database(this);

        //set add button to button widget
        mAddButton = (Button)findViewById(R.id.mAddButtonLabel);
        //set view button to button widget
        mViewButton = (Button)findViewById(R.id.mViewButtonLabel);
        //set add button onClick listener
        mAddButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //creating a new intent to launch an activity, add class in this case
                Intent intent = new Intent(MainActivity.this, Add.class);
                //launching add class because add button was clicked
                MainActivity.this.startActivity(intent);
            }
        });
        //set view button onClick listener
        mViewButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //Creating a new intent to launch an activity, view class this time
                Intent intent = new Intent(MainActivity.this, View.class);
                //launching view class because the view button was clicked
                MainActivity.this.startActivity(intent);
            }
        });

    }
}