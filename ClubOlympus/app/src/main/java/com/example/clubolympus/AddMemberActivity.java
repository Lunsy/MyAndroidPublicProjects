package com.example.clubolympus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.clubolympus.data.ClubOlympusContract.MemberEntry;

import java.net.URI;
import java.util.ArrayList;

public class AddMemberActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int EDIT_MEMBER_LOADER = 110;

    Uri currentMemberUri;

    private EditText firstNameET;
    private EditText lastNameET;
    private EditText kindsportET;
    private Spinner genderSpnr;
    private int gender = 0;
    private ArrayAdapter spnrAdapter;
//    private ArrayList  spnrArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_member);

        Intent intent = getIntent();

        currentMemberUri = intent.getData();

        if (currentMemberUri == null){
            setTitle("Add new Member");
            invalidateOptionsMenu();
        } else {
            setTitle("Edit the Member");
            getSupportLoaderManager().initLoader(EDIT_MEMBER_LOADER, null, this);
        }

        firstNameET = findViewById(R.id.first_name_ET);
        lastNameET = findViewById(R.id.last_name_ET);
        kindsportET = findViewById(R.id.kind_sport);
        genderSpnr = findViewById(R.id.gen_spnr);

        // Dynamical list with ArrayList
        /*spnrArrayList = new ArrayList();
        spnrArrayList.add("Unkown");
        spnrArrayList.add("Male");
        spnrArrayList.add("Female");
        spnrArrayList.add("Other");*/

        // Adapter for dynamical list
//        spnrAdapter = new ArrayAdapter(this,
//                android.R.layout.simple_spinner_item, spnrArrayList);

        // Statical list with array.xml
        // Statical Adapter
        spnrAdapter = ArrayAdapter.createFromResource(this,
               R.array.array_gender, android.R.layout.simple_spinner_item );
        spnrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        genderSpnr.setAdapter(spnrAdapter);

        genderSpnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                String selectedGender = (String) adapterView.getItemAtPosition(pos);
                if (!TextUtils.isEmpty(selectedGender)){
                    if (selectedGender.equals("Male")){
                        gender = MemberEntry.GENDER_MALE;
                    } else if (selectedGender.equals("Female")){
                        gender = MemberEntry.GENDER_FEMALE;
                    } else if (selectedGender.equals("Other")){
                        gender = MemberEntry.GENDER_OTHER;
                    } else {
                        gender = MemberEntry.GENDER_UNKNOWN;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                gender = 0;
            }
        });


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){

        super.onPrepareOptionsMenu(menu);

        if(currentMemberUri == null){
            MenuItem menuItem = menu.findItem(R.id.delete_member);
            menuItem.setVisible(false);
        }

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu_member, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)  {
        int id = item.getItemId();
            if (id == R.id.save_member){
                    saveMember();
                    return true;
            } else if (id == R.id.delete_member){
                    showDeleteMemberDialog();
                    return true;
            } else if (id == android.R.id.home) {
                NavUtils.navigateUpFromSameTask(this);
                return true;
            }
        return super.onOptionsItemSelected(item);
    }

    private void saveMember(){

        String firstName = firstNameET.getText().toString().trim();
        String lastName = lastNameET.getText().toString().trim();
        String kindSport = kindsportET.getText().toString().trim();

        if(TextUtils.isEmpty(firstName)){
            Toast.makeText(this, "Input First Name",
                    Toast.LENGTH_SHORT).show();
            return;
        } else if(TextUtils.isEmpty(lastName)){
            Toast.makeText(this, "Input Last Name",
                    Toast.LENGTH_SHORT).show();
            return;
        } else if(TextUtils.isEmpty(kindSport)){
            Toast.makeText(this, "Input Kind of Sport",
                    Toast.LENGTH_SHORT).show();
            return;
        } else if(gender == MemberEntry.GENDER_UNKNOWN){
            Toast.makeText(this, "Choose Gender",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(MemberEntry.COLUMN_FIRST_NAME, firstName);
        contentValues.put(MemberEntry.COLUMN_LAST_NAME, lastName);
        contentValues.put(MemberEntry.COLUMN_KIND_SPORT, kindSport);
        contentValues.put(MemberEntry.COLUMN_GENDER, gender);

        if(currentMemberUri == null){

            ContentResolver contentResolver = getContentResolver();
            Uri uri = contentResolver.insert(MemberEntry.CONTENT_URI, contentValues);

            if (uri == null){
                Toast.makeText(this, "Insertion of data in the table failed",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();

            }
        } else {
            int rowsChanged = getContentResolver().update(currentMemberUri, contentValues,
                    null, null);

            if(rowsChanged == 0){
                Toast.makeText(this, "Saving of data in the table failed",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Member updated", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {

        String[] projection = {
                MemberEntry._ID,
                MemberEntry.COLUMN_FIRST_NAME,
                MemberEntry.COLUMN_LAST_NAME,
                MemberEntry.COLUMN_GENDER,
                MemberEntry.COLUMN_KIND_SPORT,
        };

        return new CursorLoader(this,
                currentMemberUri,
                projection,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        if(cursor.moveToFirst()){
            int firstNameColumnIndex = cursor.getColumnIndex(
                    MemberEntry.COLUMN_FIRST_NAME
            );
            int lastNameColumnIndex = cursor.getColumnIndex(
                    MemberEntry.COLUMN_LAST_NAME
            );
            int genderColumnIndex = cursor.getColumnIndex(
                    MemberEntry.COLUMN_GENDER
            );
            int kindSportColumnIndex = cursor.getColumnIndex(
                    MemberEntry.COLUMN_KIND_SPORT
            );

            String firstName = cursor.getString(firstNameColumnIndex);
            String lastName = cursor.getString(lastNameColumnIndex);
            int gender = cursor.getInt(genderColumnIndex);
            String kindSport = cursor.getString(kindSportColumnIndex);

            firstNameET.setText(firstName);
            lastNameET.setText(lastName);
            kindsportET.setText(kindSport);

            switch (gender){
                case MemberEntry.GENDER_MALE:
                    genderSpnr.setSelection(1);
                    break;
                case MemberEntry.GENDER_FEMALE:
                    genderSpnr.setSelection(2);
                    break;
                case MemberEntry.GENDER_OTHER:
                    genderSpnr.setSelection(3);
                    break;
                case MemberEntry.GENDER_UNKNOWN:
                    genderSpnr.setSelection(0);
                    break;
            }
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }

    private void showDeleteMemberDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want delete the member?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteMember();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(dialogInterface != null){
                    dialogInterface.dismiss();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void deleteMember(){
        if(currentMemberUri != null){
            int rowsDeleted = getContentResolver().delete(currentMemberUri,
                    null, null);
            if(rowsDeleted == 0){
                Toast.makeText(this, "Deleting of data from the table failed",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Member is deleted",
                        Toast.LENGTH_SHORT).show();
            }

            finish();
        }
    }
}