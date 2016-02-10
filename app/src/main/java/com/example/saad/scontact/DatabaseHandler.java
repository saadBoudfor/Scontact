package com.example.saad.scontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";

    // Contacts Table Columns names
    private static final String KEY_GSM = "gsm";
    private static final String KEY_WEB_Site = "siteweb";



    private static final String KEY_LASTNAME = "last_name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ADDRESS = "addresse";


    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";


    private static final String PROFESSION = "profession";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + KEY_ADDRESS+ "TEXT"+ KEY_EMAIL + "TEXT" + KEY_LASTNAME +"TEXT" + KEY_GSM +"TEXT" + KEY_WEB_Site +"TEXT"+ PROFESSION + "TEXT"+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }


    // Adding new contact
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put(KEY_NAME, contact.getNom()); // Contact Name
        values.put(KEY_LASTNAME, contact.getPrenom()); // Contact Phone Number

        values.put(KEY_PH_NO, contact.getPhone()); // Contact Name
        values.put(KEY_GSM, contact.getPortable()); // Contact Phone Number


        values.put(KEY_ADDRESS, contact.getAdresse()); // Contact Name
        values.put(KEY_EMAIL, contact.getEmail()); // Contact Phone Number



        values.put(KEY_WEB_Site, contact.getWebSite()); // Contact Name
        values.put(PROFESSION, contact.getProfession()); // Contact Phone Number



        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }



    // Getting All Contacts
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setNom(cursor.getString(1));
                contact.setPhone(cursor.getString(2));

                contact.setAdresse(cursor.getString(3));
                contact.setEmail(cursor.getString(4));

                contact.setPrenom(cursor.getString(5));
                contact.setPortable(cursor.getString(6));

                contact.setWebSite(cursor.getString(7));
                contact.setProfession(cursor.getString(8));


                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }



}