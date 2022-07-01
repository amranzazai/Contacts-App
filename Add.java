package com.example.assignment7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    //Declaring three fields for user to enter email, name, and number
    EditText editEmail;
    EditText editName;
    EditText editNumber;

    //Declaring an add button for contacts and a go back button
    Button mAddDataButton;
    Button mCancelButton;

    //Declaring databaseHelper
    Database databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //We are using the activity_add_contact.xml file for our layout
        setContentView(R.layout.activity_add_contact);

        //Connecting editTextView to layout file
        editName = (EditText)findViewById(R.id.editTextName);
        editNumber = (EditText)findViewById(R.id.editTextNumber);
        editEmail = (EditText)findViewById(R.id.editTextEmail);

        //Connecting buttons to layout file
        mAddDataButton = (Button)findViewById(R.id.mAddDataButtonLabel);
        mCancelButton = (Button)findViewById(R.id.mCancelButtonLabel);

        //Setting an on click Listener for mCancelButton
        mCancelButton.setOnClickListener(v -> {
            //creating intent to go to another activity
            Intent myIntent = new Intent(Add.this, MainActivity.class);

            //returning to mainActivity
            Add.this.startActivity(myIntent);
        });
        //Creating on click listener for mAddDataButton
        AddData();

        //setting our database helper
        databaseHelper = new Database(this);
    }

    private void AddData() {
        //Creating on click listener for mAddDataButton
        mAddDataButton.setOnClickListener(
                v1 -> {
                    //boolean to return true or false depending on whether data is inserted or not
                    boolean inserted = databaseHelper.insertData(editName.getText().toString(),
                            editNumber.getText().toString(),
                            editEmail.getText().toString());

                    if (inserted)
                        Toast.makeText(Add.this, "Success!", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Add.this, "Error with inserting data!", Toast.LENGTH_LONG).show();
                }
        );
    }
}
