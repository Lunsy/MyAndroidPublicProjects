package com.example.clubolympus;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.clubolympus.data.ClubOlympusContract.MemberEntry;
import com.example.clubolympus.data.ClubOlympusContract;

public class MemberCursorAdapter extends CursorAdapter {
    public MemberCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.member_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView firstNameTextView = view.findViewById(R.id.first_name_TV);
        TextView lastNameTextView = view.findViewById(R.id.last_name_TV);
        TextView kindSportTextView = view.findViewById(R.id.kind_sport_TV);

        String fistName = cursor.getString(cursor.getColumnIndexOrThrow(MemberEntry.COLUMN_FIRST_NAME));
        String lastName = cursor.getString(cursor.getColumnIndexOrThrow(MemberEntry.COLUMN_LAST_NAME));
        String kindSport = cursor.getString(cursor.getColumnIndexOrThrow(MemberEntry.COLUMN_KIND_SPORT));

        firstNameTextView.setText(fistName);
        lastNameTextView.setText(lastName);
        kindSportTextView.setText(kindSport);


    }
}
