package com.example.saad.scontact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NewContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
    }


    public void enregisterOnClick(View view){
        Contact contact = new Contact();

        // On construit notre objet contact:

        EditText editText;

        editText = (EditText) findViewById(R.id.nom1);
        contact.setNom(editText.getText().toString());


        editText = (EditText) findViewById(R.id.prenom1);
        contact.setPrenom(editText.getText().toString());

        editText = (EditText) findViewById(R.id.gsm1);
        contact.setPortable(editText.getText().toString());

        editText = (EditText) findViewById(R.id.tel11);
        contact.setPhone(editText.getText().toString());


        editText = (EditText) findViewById(R.id.adresse1);
        contact.setAdresse(editText.getText().toString());


        editText = (EditText) findViewById(R.id.mail1);
        contact.setEmail(editText.getText().toString());

        editText = (EditText) findViewById(R.id.proffession1);
        contact.setProfession(editText.getText().toString());

        editText = (EditText) findViewById(R.id.webSite1);
        contact.setWebSite(editText.getText().toString());

        Log.e("*************",contact.getNom());



    }
}
