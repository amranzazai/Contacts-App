package com.example.assignment7;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class View extends AppCompatActivity {
    //Declaring delete button
    Button mDeleteButton;
    //Declaring listView for contacts
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //using activity_view as our xml layout file
        setContentView(R.layout.activity_view_contact);
        //new database object
        Database database = new Database(View.this);

        //Creating an array of strings to store contacts in
        ArrayList<String> contacts = new ArrayList<>();

        //seting listView object to its correct view group
        listView = findViewById(R.id.listView);

        //connecting mDeleteButton to delete button widget
        mDeleteButton = (Button)findViewById(R.id.mDeleteButtonLabel);

        //setting delete button onClick listener
        mDeleteButton.setOnClickListener(v -> {
            //delete data from our database on click
            database.deleteData();
            //Display a toast to let the user know data was deleted
            Toast.makeText(View.this, "The database has been cleared!", Toast.LENGTH_LONG).show();
            //creating a new intent to launch an activity, MainActivity class in this case
            Intent intent = new Intent(View.this, MainActivity.class);
            //launching mainActivity to go to the home screen after clicking Delete button
            View.this.startActivity(intent);
        });

        //storing all of the contacts in our database in listOfContacts
        List<Contacts> listOfContacts = database.getAllContacts();

        //for each contact in our contact list...
        for (Contacts contact: listOfContacts){
            //...Add their name, phone, and email address to the array of strings we made in the beginning
            contacts.add("\nName: " + contact.getName() + "\n\nPhone: " + contact.getNumber() + "\n\ne-mail: " + contact.getEmail() + "\n");
        }

        //We are using this adapter because our data source is an array
        //By default, ArrayAdapter creates a view for each array item by calling toString() on each item and placing the contents in a TextView
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        //allows us to scroll through our contacts which are displayed in a single column list.
        listView.setAdapter(arrayAdapter);
    }
}
