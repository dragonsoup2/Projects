package com.example.drago.food;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by drago on 2016-04-27.
 */
public class MyDb extends SQLiteOpenHelper
{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "food.db";
    private static final String TABLE_USERS = "user";

    public static final String COLUMN_USERID = "userName";
    public static final String COLUMN_PASSWORD = "passWord";
    public static final String COLUMN_LASTNAME = "lastName";
    public static final String COLUMN_FIRSTNAME = "firstName";
    public static final String COLUMN_PHONENUMBER = "phoneNumber";
    public static final String COLUMN_EMAIL = "email";

    public MyDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + TABLE_USERS
                + "("
                + COLUMN_USERID + " TEXT NOT NULL,"
                + COLUMN_PASSWORD + " TEXT NOT NULL,"
                + COLUMN_LASTNAME + " TEXT NOT NULL,"
                + COLUMN_FIRSTNAME + " TEXT NOT NULL)";
        db.execSQL(createTable);
        Log.d("DatabaseHandler", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public String addUser(ArrayList<String> userInfo)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERID, userInfo.get(0));
        values.put(COLUMN_PASSWORD, userInfo.get(1));
        values.put(COLUMN_LASTNAME, userInfo.get(2));
        values.put(COLUMN_FIRSTNAME, userInfo.get(3));

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_USERS, null, values);

        db.close();

        return userInfo.get(0);
    }
    public Cursor findUser(String userID) {
        String query = "Select * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERID + " LIKE \"%" + userID + "%\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //Cursor cursor = db.query(true, TABLE_USERS, columns, COLUMN_USERID + " LIKE ?", new String[] {"%" + userID + "%"}, null, null, null, null);

        db.close();
        return cursor;
    }
    public boolean deleteUser(String userID) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERID + " = \"" + userID + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        ArrayList<String> userInfo = new ArrayList<String>();

        if (cursor.moveToFirst()) {
            userInfo.add(cursor.getString(0));
            db.delete(TABLE_USERS, COLUMN_USERID + " = ?", new String[]{userInfo.get(0)});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}
