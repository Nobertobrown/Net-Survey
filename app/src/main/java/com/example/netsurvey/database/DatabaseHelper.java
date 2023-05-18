package com.example.netsurvey.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.netsurvey.coverage.Area;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "netApp";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "area";

    private static final String KEY_ID = "id";
    private static final String KEY_START = "start";
    private static final String KEY_START_POINT = "start-point";
    private static final String KEY_END = "theend";
    private static final String KEY_END_POINT = "theend-point";
    private static final String KEY_CORRIDOR = "corridor";
    private static final String KEY_REGION = "region";
    private static final String KEY_ROAD = "sublink";
    private static final String KEY_LINK = "link";
    private static final String KEY_SUB_LINK = "sub-link";
    private static final String KEY_SHOULDER_TYPE = "shoulder type";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table "+TABLE_NAME+" ( "
                +KEY_ID+" integer primary key,"
                +KEY_CORRIDOR+" text,"
                +KEY_START+" text,"
                +KEY_ROAD+" text,"
                +KEY_LINK+" text,"
                +KEY_SUB_LINK+" text,"
                +KEY_END+" text,"
                +KEY_REGION+" text,"
                +KEY_START_POINT+" text,"
                +KEY_END_POINT+" text,"
                +KEY_SHOULDER_TYPE+" text )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "drop table if exists "+TABLE_NAME;
        db.execSQL(query);

        onCreate(db);
    }

    public void createArea(Area land){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_CORRIDOR,land.getCorridor());
        values.put(KEY_START,land.getStart());
        values.put(KEY_ROAD,land.getRoad());
        values.put(KEY_LINK,land.getLink());
        values.put(KEY_SUB_LINK,land.getSubLink());
        values.put(KEY_END,land.getEnd());
        values.put(KEY_REGION,land.getRegion());
        values.put(KEY_START_POINT,land.getStartPoint());
        values.put(KEY_END_POINT,land.getEndPoint());
        values.put(KEY_SHOULDER_TYPE,land.getShoulderType());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }
}
