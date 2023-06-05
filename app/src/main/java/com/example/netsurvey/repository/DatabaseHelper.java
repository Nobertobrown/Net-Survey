package com.example.netsurvey.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.netsurvey.model.Area;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "netapp";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "area";

    private static final String KEY_ID = "id";
    private static final String KEY_START = "thestart";
    private static final String KEY_START_POINT = "startpoint";
    private static final String KEY_END = "theend";
    private static final String KEY_END_POINT = "endpoint";
    private static final String KEY_CORRIDOR = "corridor";
    private static final String KEY_REGION = "region";
    private static final String KEY_ROAD = "road";
    private static final String KEY_LINK = "link";
    private static final String KEY_SUB_LINK = "sublink";
    private static final String KEY_SHOULDER_TYPE = "shouldertype";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="create table "+ TABLE_NAME+"("+KEY_ID+" integer primary key,"+KEY_START+" text,"+KEY_CORRIDOR+" text,"+KEY_END+" text,"+KEY_LINK+" text,"+KEY_END_POINT+" text,"+KEY_START_POINT+" text,"+KEY_SHOULDER_TYPE+" text,"+KEY_REGION+" text,"+KEY_ROAD+" text,"+KEY_SUB_LINK+" text )";
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

    public ArrayList<Area> getAllAreas(){
        ArrayList<Area> areas = new ArrayList<>();

        String query = "select * from "+TABLE_NAME+" order by id desc";

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Area area = new Area();
                area.setId(Integer.parseInt(cursor.getString(0)));
                area.setStart(cursor.getString(1));
                area.setEnd(cursor.getString(2));
                area.setCorridor(cursor.getString(3));
                area.setRegion(cursor.getString(4));
                area.setShoulderType(cursor.getString(5));
                area.setStartPoint(cursor.getString(6));
                area.setEndPoint(cursor.getString(7));
                area.setRoad(cursor.getString(8));
                area.setLink(cursor.getString(9));
                area.setSubLink(cursor.getString(10));
                areas.add(area);
            }while (cursor.moveToNext());
        }

        return areas;
    }
}
