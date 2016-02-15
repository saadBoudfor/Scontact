package com.example.saad.scontact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ModifierContact extends AppCompatActivity {

    private ContactDAO contactDAO;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_contact);

        String id_contact = this.getIntent().getExtras().getString("contact_id");

        contactDAO = new ContactDAO(this);
        contact = contactDAO.read(String.valueOf(id_contact));

        ((EditText)findViewById(R.id.nom1)).setText(contact.getNom());
        ((EditText)findViewById(R.id.prenom1)).setText(contact.getPrenom());

        ((EditText)findViewById(R.id.adresse1)).setText(contact.getAdresse());
        ((EditText)findViewById(R.id.mail1)).setText(contact.getEmail());


        ((EditText)findViewById(R.id.tel11)).setText(contact.getPhone());
        ((EditText)findViewById(R.id.gsm1)).setText(contact.getPortable());


        ((EditText)findViewById(R.id.proffession1)).setText(contact.getProfession());
        ((EditText)findViewById(R.id.webSite1)).setText(contact.getWebSite());
        
        


    }
    
    public void onClickEnregistrer(View view){
       contact.setNom(((EditText) findViewById(R.id.nom1)).getText().toString());
       contact.setPrenom(((EditText) findViewById(R.id.prenom1)).getText().toString());

        contact.setAdresse(((EditText) findViewById(R.id.adresse1)).getText().toString());
        contact.setEmail(((EditText) findViewById(R.id.mail1)).getText().toString());


        contact.setPhone(((EditText) findViewById(R.id.tel11)).getText().toString());
        contact.setPortable(((EditText) findViewById(R.id.gsm1)).getText().toString());


       contact.setProfession(((EditText) findViewById(R.id.proffession1)).getText().toString());
       contact.setWebSite(((EditText) findViewById(R.id.webSite1)).getText().toString());


        contactDAO.updateContact(contact);
        Intent intent = new Intent(view.getContext(), ContactManager.class);
        startActivity(intent);

    }

    public void oKonClick(View view){
        Intent intent = new Intent(view.getContext(), ContactManager.class);
        startActivity(intent);
    }

}
