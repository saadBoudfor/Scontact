package com.example.saad.scontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.saad.scontact.ScontactHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 07/02/16.
 */
public class ContactDAO {
    private ScontactHelper helper;
    private SQLiteDatabase database;

    // should be a singleton but useless in our case
    public ContactDAO(Context context) {
        this.helper = ScontactHelper.getInstance(context);
    }

    public Contact create(Contact contact){
        database = helper.getWritableDatabase();
        database.beginTransaction();
        try{
            ContentValues values = new ContentValues();

            values.put(ScontactHelper.EMAIL, contact.getEmail());
            values.put(ScontactHelper.ADRESSE, contact.getAdresse());

            values.put(ScontactHelper.PHONE, contact.getPhone());
            values.put(ScontactHelper.GSM, contact.getPortable());

            values.put(ScontactHelper.CONTACT_FIRSTNAME, contact.getPrenom());
            values.put(ScontactHelper.CONTACT_LASTNAME, contact.getNom());


            values.put(ScontactHelper.WEBSITE, contact.getWebSite());
            values.put(ScontactHelper.PROFESSION, contact.getProfession());

            database.insert(ScontactHelper.CONTACT_TABLE, null, values);
            database.setTransactionSuccessful();


        }catch (Exception e){
            Log.e("scontact", "create error", e);
        }
        database.endTransaction();
        return contact;
    }

    public Contact read(String id){
        Contact tamp =  new Contact();

        database = helper.getReadableDatabase();
        String query = "SELECT * FROM "+ ScontactHelper.CONTACT_TABLE +
                " WHERE " + ScontactHelper.CONTACT_ID + " = '" + id + "'";

        Cursor c = database.rawQuery(query, null);
        if (c.moveToFirst()){
            // On récupere les elements:
            String firstName = c.getString(c.getColumnIndex(ScontactHelper.CONTACT_FIRSTNAME));
            String lastName = c.getString(c.getColumnIndex(ScontactHelper.CONTACT_LASTNAME));

            String email = c.getString(c.getColumnIndex(ScontactHelper.EMAIL));
            String adresse = c.getString(c.getColumnIndex(ScontactHelper.ADRESSE));

            String website = c.getString(c.getColumnIndex(ScontactHelper.WEBSITE));
            String profession = c.getString(c.getColumnIndex(ScontactHelper.PROFESSION));

            String phone = c.getString(c.getColumnIndex(ScontactHelper.PHONE));
            String gsm = c.getString(c.getColumnIndex(ScontactHelper.GSM));



            //On construit l'objet COntact:
            tamp.setPrenom(firstName);
            tamp.setNom(lastName);

            tamp.setId(Integer.parseInt(id));

            tamp.setPortable(gsm);
            tamp.setEmail(email);

            tamp.setAdresse(adresse);
            tamp.setPhone(phone);

            tamp.setProfession(profession);
            tamp.setWebSite(website);
        }
        return tamp;
    }

    public ArrayList<Contact> readAll(){
        ArrayList<Contact> contacts = new ArrayList<>();
        database = helper.getReadableDatabase();
        String query = "SELECT * FROM "+ ScontactHelper.CONTACT_TABLE;

        Cursor c = database.rawQuery(query,null);
        if (c.moveToFirst()){
            do {
                String firstName = c.getString(c.getColumnIndex(ScontactHelper.CONTACT_FIRSTNAME));
                String lastName = c.getString(c.getColumnIndex(ScontactHelper.CONTACT_LASTNAME));
                String id = c.getString(c.getColumnIndex(ScontactHelper.CONTACT_ID));


                String email = c.getString(c.getColumnIndex(ScontactHelper.EMAIL));
                String adresse = c.getString(c.getColumnIndex(ScontactHelper.ADRESSE));

                String website = c.getString(c.getColumnIndex(ScontactHelper.WEBSITE));
                String profession = c.getString(c.getColumnIndex(ScontactHelper.PROFESSION));

                String phone = c.getString(c.getColumnIndex(ScontactHelper.PHONE));
                String gsm = c.getString(c.getColumnIndex(ScontactHelper.GSM));


                Contact tamp =  new Contact();
                tamp.setPrenom(firstName);
                tamp.setNom(lastName);

                tamp.setId(Integer.parseInt(id));

                tamp.setPortable(gsm);
                tamp.setEmail(email);

                tamp.setAdresse(adresse);
                tamp.setPhone(phone);

                tamp.setProfession(profession);
                tamp.setWebSite(website);




                tamp.setId(Integer.parseInt(id));

                contacts.add(tamp);
            }while(c.moveToNext());
        }
        return contacts;
    }


    public void deleteContact(Contact contact) {
        database = helper.getWritableDatabase();
        database.delete(ScontactHelper.CONTACT_TABLE, ScontactHelper.CONTACT_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
        database.close();
    }


    public int updateContact(Contact contact) {
        database = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ScontactHelper.EMAIL, contact.getEmail());
        values.put(ScontactHelper.ADRESSE, contact.getAdresse());

        values.put(ScontactHelper.PHONE, contact.getPhone());
        values.put(ScontactHelper.GSM, contact.getPortable());

        values.put(ScontactHelper.CONTACT_FIRSTNAME, contact.getPrenom());
        values.put(ScontactHelper.CONTACT_LASTNAME, contact.getNom());


        values.put(ScontactHelper.WEBSITE, contact.getWebSite());
        values.put(ScontactHelper.PROFESSION, contact.getProfession());


        // updating row
        return database.update(ScontactHelper.CONTACT_TABLE, values,  ScontactHelper.CONTACT_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
    }
}
