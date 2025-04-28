package com.example.clubolympus.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.clubolympus.data.ClubOlympusContract.MemberEntry;


public class OlympusDbOpenHelper extends SQLiteOpenHelper {

    public OlympusDbOpenHelper(@Nullable Context context) {
        super(context, MemberEntry.DATABASE_NAME,
                null, MemberEntry.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL - Structured Query Language
        String CREATE_MEMBERS_TABLE = "CREATE TABLE "
                + MemberEntry.TABLE_NAME + "("
                + MemberEntry._ID + " INTEGER PRIMARY KEY,"
                + MemberEntry.COLUMN_FIRST_NAME + " TEXT,"
                + MemberEntry.COLUMN_LAST_NAME + " TEXT,"
                + MemberEntry.COLUMN_GENDER + " INTEGER NOT NULL,"
                + MemberEntry.COLUMN_KIND_SPORT + " TEXT" + ")";
        db.execSQL(CREATE_MEMBERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MemberEntry.TABLE_NAME);
        onCreate(db);
    }

    // CRUD
    // Create, Read, Update, Delete
    /*public  void  addMember(Person person){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MemberEntry.COLUMN_FIRST_NAME, person.getFirstName());
        contentValues.put(MemberEntry.COLUMN_LAST_NAME, person.getLastName());
        contentValues.put(MemberEntry.COLUMN_GENDER, person.getGender());
        contentValues.put(MemberEntry.COLUMN_KIND_SPORT, person.getKindSport());

        db.insert(MemberEntry.TABLE_NAME, null, contentValues);
        db.close();
    }*/


}
