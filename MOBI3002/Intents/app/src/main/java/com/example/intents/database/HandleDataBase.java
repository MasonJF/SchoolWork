package com.example.intents.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class HandleDataBase extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Things.db";
    private static final String TABLE_NAME = "animals";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";


    private static final String _ID = "_ID";
    private static final String _NAME_COL = "_name";
    private static final String _DETAILS_COL = "_details";
    private static final String _ACCESS_COUNT = "_access_Count";
    private static final String _WEARSAHAT = "_wearsahat";
    private static final String _DATE = "_date";
    private static final String _WEBPAGE = "_webpage";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened untiljava.lang.String one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public HandleDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String db_com = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY, " +
                _NAME_COL + " TEXT," +
                _DETAILS_COL + " TEXT," +
                _ACCESS_COUNT + " INTEGER," +
                _WEARSAHAT + " INTEGER," +
                _DATE + " TEXT," +
                _WEBPAGE + " TEXT" +" )";
        Log.v("HandleDataBase", "onCreate DB =" + db_com);
        db.execSQL(db_com);

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);

    }

    ////////////////////////////////////////////////////
    // Getters & Setters

    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public void addThingItem(DataBaseContent.ThingItem ThingItem) {
        Log.d("add ThingItem", ThingItem.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(_NAME_COL, ThingItem.name); // get title
        values.put(_DETAILS_COL, ThingItem.details);// get author
        values.put(_ACCESS_COUNT, ThingItem.access_Count);
        values.put(_WEARSAHAT, ThingItem.wearsAHat);
        values.put(_DATE, ThingItem.date);
        values.put(_WEBPAGE, ThingItem.webpage);
        // 3. insert
        db.insert(TABLE_NAME, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public void incrementAccessCount(DataBaseContent.ThingItem thing) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_ACCESS_COUNT, ++thing.access_Count);
        db.update(TABLE_NAME, values, _ID + "=" + thing.id, null);
        db.close();
    }

    public void setCurrentDate(DataBaseContent.ThingItem thing) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        thing.date = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date());
        values.put(_DATE, thing.date);
        db.update(TABLE_NAME, values, _ID + "=" + thing.id, null);
        db.close();
    }

    public DataBaseContent.ThingItem getThingItem(int id) {

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        // Which columns to return in query
        String[] COLUMNS = {_ID, _NAME_COL, _DETAILS_COL, _ACCESS_COUNT, _WEARSAHAT};
        Cursor cursor =
                db.query(TABLE_NAME, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build object
        DataBaseContent.ThingItem ThingItem =
                new DataBaseContent().new ThingItem(cursor.getInt( cursor.getColumnIndexOrThrow(_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(_NAME_COL)),
                        cursor.getString( cursor.getColumnIndexOrThrow(_DETAILS_COL)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(_ACCESS_COUNT)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(_WEARSAHAT)) == 1,
                        cursor.getString(cursor.getColumnIndexOrThrow(_DATE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(_WEBPAGE)));

        //log
        Log.d("get animal(" + id + ")", ThingItem.toString());

        // 5. return book
        return ThingItem;
    }


    public List<DataBaseContent.ThingItem> getAllThingItems(){
        List<DataBaseContent.ThingItem> temp = new ArrayList<DataBaseContent.ThingItem>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_NAME;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        DataBaseContent.ThingItem ThingItem = null;
        if (cursor.moveToFirst()) {
            do {
                ThingItem =
                        new DataBaseContent().new ThingItem(cursor.getInt( cursor.getColumnIndexOrThrow(_ID)),
                                cursor.getString(cursor.getColumnIndexOrThrow(_NAME_COL)),
                                cursor.getString( cursor.getColumnIndexOrThrow(_DETAILS_COL)),
                                cursor.getInt(cursor.getColumnIndexOrThrow(_ACCESS_COUNT)),
                                cursor.getInt(cursor.getColumnIndexOrThrow(_WEARSAHAT)) == 1,
                                cursor.getString(cursor.getColumnIndexOrThrow(_DATE)),
                                cursor.getString(cursor.getColumnIndexOrThrow(_WEBPAGE)));
                temp.add(ThingItem);
            } while (cursor.moveToNext());
        }

        Log.d("getAllThingItems", temp.toString());

        // return all
        return temp;
    }


    public Map<String, DataBaseContent.ThingItem> getAllThingItemDetails(){
        Map<String, DataBaseContent.ThingItem> temp = new HashMap<String, DataBaseContent.ThingItem>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_NAME;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        DataBaseContent.ThingItem ThingItem = null;
        if (cursor.moveToFirst()) {
            do {
                ThingItem =
                        new DataBaseContent().new ThingItem(cursor.getInt( cursor.getColumnIndexOrThrow(_ID)),
                                cursor.getString(cursor.getColumnIndexOrThrow(_NAME_COL)),
                                cursor.getString( cursor.getColumnIndexOrThrow(_DETAILS_COL)),
                                cursor.getInt(cursor.getColumnIndexOrThrow(_ACCESS_COUNT)),
                                cursor.getInt(cursor.getColumnIndexOrThrow(_WEARSAHAT)) == 1,
                                cursor.getString(cursor.getColumnIndexOrThrow(_DATE)),
                                cursor.getString(cursor.getColumnIndexOrThrow(_WEBPAGE)));
                temp.put(cursor.getString(0), ThingItem);  // ID, then animal
            } while (cursor.moveToNext());
        }

        Log.d("getAllThingItemDetails", temp.toString());

        return temp;
    }
}
