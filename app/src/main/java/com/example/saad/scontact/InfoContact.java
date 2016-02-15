package com.example.saad.scontact;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class InfoContact extends AppCompatActivity {
    private Contact contact;
    private ContactDAO contactDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_contact);


        String id_contact = this.getIntent().getExtras().getString("contact_id");

        contactDAO = new ContactDAO(this);
        contact = contactDAO.read(String.valueOf(id_contact));


        ((TextView)findViewById(R.id.img)).setText(String.valueOf(contact.getNom().charAt(0)));


        ((TextView)findViewById(R.id.nom1)).setText(contact.getNom());
        ((TextView)findViewById(R.id.prenom1)).setText(contact.getPrenom());

        ((TextView)findViewById(R.id.adresse1)).setText(contact.getAdresse());
        ((TextView)findViewById(R.id.mail1)).setText(contact.getEmail());


        ((TextView)findViewById(R.id.tel11)).setText(contact.getPhone());
        ((TextView)findViewById(R.id.gsm1)).setText(contact.getPortable());


        ((TextView)findViewById(R.id.proffession1)).setText(contact.getProfession());
        ((TextView)findViewById(R.id.webSite1)).setText(contact.getWebSite());






    }
    public void oKonClick(View view){
        Intent intent = new Intent(view.getContext(), ContactManager.class);
        startActivity(intent);
    }

    public void supprimeronClick(final View view){
                final AlertDialog.Builder adb = new AlertDialog.Builder(InfoContact.this);
                //on attribut un titre à notre boite de dialogue
                adb.setTitle("Suppression du contact: " + contact.getPrenom() + " " + contact.getPrenom());
                //on insère un message à notre boite de dialogue, et ici on affiche le titre de l'item cliqué
                adb.setMessage("Etes vous sûr de vouloir supprimer le contact " + contact.getPrenom() + " " + contact.getPrenom() + "de votre liste de contact ?");
                //on indique que l'on veut le bouton ok à notre boite de dialogue

                //on indique que l'on veut le bouton ok à notre boite de dialogue

                adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        contactDAO.deleteContact(contact);
                        Intent intent = new Intent(view.getContext(), ContactManager.class);
                        startActivity(intent);
                    }
                });
                //on affiche la boite de dialogue


                adb.setNegativeButton("Annuler", null);
                adb.show();
    }

    public void modifieronClick(View view){
        Intent intent = new Intent(view.getContext(), ModifierContact.class);
        intent.putExtra("contact_id", this.getIntent().getExtras().getString("contact_id"));
        startActivityForResult(intent, 0);

    }
}
