package com.example.mobipart2.database;

import android.content.Context;
import android.util.Log;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DataBaseContent {

    public boolean data_is_set = false;

    /**
     * An array of items.
     */
//    public static List<ThingItem> ITEMS = new ArrayList<ThingItem>();
    public static List<ThingItem> ITEMS;
    public List<ThingItem> getITEMS() {
        return ITEMS;
    }


    /**
     * A map of items, by ID.
     */
//    public static Map<String, ThingItem> ITEM_MAP = new HashMap<String, ThingItem>();
    public static Map<String, ThingItem> ITEM_MAP;
    public Map<String, ThingItem> getITEM_MAP() {
        return ITEM_MAP;
    }


    //    private static final int COUNT = 25;
    public static final String DATABASE_NAME = "ThingItemDB";
    public static final int DATABASE_VERSION = 2;

    Context context;
    HandleDataBase dbRaw;

    // Empty Constructor
    public DataBaseContent() {
    }

    // Constructor to create DB
    public DataBaseContent(Context context) {

        Log.v("HandleDataBase", "DataBaseContent constructor");

        dbRaw = new HandleDataBase(context, DATABASE_NAME, null, DATABASE_VERSION);
        Date date = new Date();

        // Add some sample items.
        if (dbRaw.getCount() > 1) {
            Log.v("HandleDataBase", "DataBaseContent already rows in DB");

        } else {
            Log.v("HandleDataBase", "DataBaseContent no rows in DB...add some");
            ThingItem a = new ThingItem(1, "Jordan", "Super Genius", 0, false, "Jan 1, 2000");
            dbRaw.addThingItem(a);
            a = new ThingItem(2, "Zac", "The Big Sad", 0, true, "Jan 1, 2000");
            dbRaw.addThingItem(a);
            a = new ThingItem(3, "Thomas", "Living in a terminal window", 0, false, "Jan 1, 2000");
            dbRaw.addThingItem(a);
            a = new ThingItem(4, "Adam", "Sleepyboi", 0, true, "Jan 1, 2000");
            dbRaw.addThingItem(a);
            a = new ThingItem(5, "Bailey", "THE Vegan", 0, true, "Jan 1, 2000");
            dbRaw.addThingItem(a);
            a = new ThingItem(6, "Other Zac", "Government Plant", 0, false, "Jan 1, 2000");
            dbRaw.addThingItem(a);
            a = new ThingItem(7, "Other Jordan", "PonyBoy", 0, false, "Jan 1, 2000");
            dbRaw.addThingItem(a);
            a = new ThingItem(8, "Mitch", "King Weaboo", 0, true, "Jan 1, 2000");
            dbRaw.addThingItem(a);
            a = new ThingItem(9, "Ryan", "The Pot", 0, true, "Jan 1, 2000");
            dbRaw.addThingItem(a);
            a = new ThingItem(11, "Callahan", "The Procrastinator", 0, false, "Jan 1, 2000");
            dbRaw.addThingItem(a);
            a = new ThingItem(12, "Diana", "The Quiet One", 0, false, "Jan 1, 2000");
            dbRaw.addThingItem(a);
        }

        ITEMS = dbRaw.getAllThingItems();
        ITEM_MAP = dbRaw.getAllThingItemDetails();

        data_is_set = true;

        Log.v("HandleDataBase", ITEMS.toString());
        Log.v("HandleDataBase", ITEM_MAP.toString());

//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
    }

    public int getSize(){
        return dbRaw.getCount();
    }


    // class was using static method to initialize
//    static {
//        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
//    }

//    private void addItem(ThingItem item) {
//        ITEMS.add(item);
//        ITEM_MAP.put(item.id, item);
//    }

//    private ThingItem createDummyItem(int position) {
//        return new ThingItem(String.valueOf(position), "Animal " + position, makeDetails(position));
//    }

//    private String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Animal: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore animal details.");
//        }
//        return builder.toString();
//    }

    /**
     * A dummy item representing a piece of content.
     */
    public class ThingItem extends DataBaseContent {
        public final Integer id;
        public final String name;
        public final String details;
        public int access_Count;
        public final boolean wearsAHat;
        public String date;

        public ThingItem(Integer id, String name, String details, int access_count, boolean wearsAHat, String date) {
            this.date = date;
            this.id = id;
            this.name = name;
            this.details = details;
            this.access_Count = access_count;
            this.wearsAHat = wearsAHat;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}