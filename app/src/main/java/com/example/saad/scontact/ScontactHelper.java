package com.example.saad.scontact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jan on 07/02/16.
 */


public class ScontactHelper extends SQLiteOpenHelper {
    // singleton
    private static ScontactHelper instance = null;
    private static final String DATABASE_NAME = "scontact.db";
    private static final int DATABASE_VERSION = 1;
    // fields of cantact table

    public static final String CONTACT_TABLE = "contact";
    public static final String CONTACT_ID = "mail";    // primary key

    public static final String CONTACT_LASTNAME = "lastname";
    public static final String CONTACT_FIRSTNAME = "firstname";

    public static final String EMAIL = "email";
    public static final String ADRESSE = "addresse";

    public static final String PHONE = "tel";
    public static final String GSM = "gsm";

    public static final String WEBSITE = "siteweb";
    public static final String PROFESSION = "profession";


    //contact table creation
    private static final String CREATION_CONTACT_TABLE = "CREATE TABLE " + CONTACT_TABLE +
            "( " + CONTACT_ID + " INTEGER PRIMARY KEY" +

            ", " + CONTACT_LASTNAME + " TEXT NOT NULL" +
            ", " + CONTACT_FIRSTNAME + " TEXT NOT NULL" +

            ", " + EMAIL + " TEXT" +
            ", " + ADRESSE + " TEXT" +

            ", " + WEBSITE + " TEXT" +
            ", " + PROFESSION + " TEXT" +

            ", " + GSM + " TEXT" +
            ", " + PHONE + " TEXT" +


            ");";

    private ScontactHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATION_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ CONTACT_TABLE);
        onCreate(db);
    }

    public static synchronized ScontactHelper getInstance(Context context)
    {
        if(instance == null){
            instance = new ScontactHelper(context);
        }
        return instance;
    }
}
