package com.Shirol.famcall;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBManager {
    private DBHandler dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c){
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DBHandler(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public void insertCallDetails(String name, String CallDuration){

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss a");
        String strDate = formatter.format(date);

        ContentValues cVals = new ContentValues();
        cVals.put(DBHandler.Key_Name, name);
        cVals.put(DBHandler.Key_CallDuration, CallDuration);
        cVals.put(DBHandler.Key_Date, strDate);

        database.insert(DBHandler.CallDetails, null, cVals);
    }

    public Cursor fetch(){
        String[] columns = new String[] {DBHandler.KEY_ID, DBHandler.Key_Name, DBHandler.Key_CallDuration, DBHandler.Key_Date};
        Cursor cursor = database.query(DBHandler.CallDetails, columns, null, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        return cursor;
    }

    public void delete(){
        database.delete(DBHandler.CallDetails, null, null);
    }
}
