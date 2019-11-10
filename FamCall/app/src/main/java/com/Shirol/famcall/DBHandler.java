package com.Shirol.famcall;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHandler extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "usersdb";

    public static final String CallDetails = "calldetails";
    public static final String Key_CallDuration = "Call_Duration";
    public static final String Key_Name = "Name";
    public static final String Key_Date = "CurrDate";
    public static final String KEY_ID = "id";

    public DBHandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE "+ CallDetails + "("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Key_Name + " TEXT," + Key_CallDuration + " TEXT," + Key_Date + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CallDetails);
        onCreate(sqLiteDatabase);
    }
}
