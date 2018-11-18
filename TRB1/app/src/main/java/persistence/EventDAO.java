package persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import model.Event;

public class EventDAO {

    private static final String TABLE_EVENTS = "events";
    private static DBGateway gw;

    public EventDAO(Context ctx){
        gw = DBGateway.getInstance(ctx);
    }

    public static boolean create(String title, String day, String hour, String facilitator, String description){
        ContentValues cv = new ContentValues();
        cv.put("title", title);
        cv.put("day", day);
        cv.put("hour", hour);
        cv.put("facilitator", facilitator);
        cv.put("description", description);
        return gw.getDatabase().insert(TABLE_EVENTS, null, cv) > 0;
    }

    public static Event read(String eventTitle) {
        Event event = null;

        String getAllQuery = "SELECT * FROM " + TABLE_EVENTS + " WHERE title LIKE '%" + eventTitle + "%'";

        Cursor cursor = gw.getDatabase().rawQuery(getAllQuery, null);

        while (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("event_id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String day = cursor.getString(cursor.getColumnIndex("day"));
            String hour = cursor.getString(cursor.getColumnIndex("hour"));
            String facilitator = cursor.getString(cursor.getColumnIndex("facilitator"));
            String description = cursor.getString(cursor.getColumnIndex("description"));
            event = new Event(id, title, Integer.parseInt(day), Integer.parseInt(hour), facilitator, description);
        }

        cursor.close();

        return event;
    }
    
    public static ArrayList<Event> getAll() {
        ArrayList<Event> events = new ArrayList<>();

        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM " + TABLE_EVENTS, null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("event_id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String day = cursor.getString(cursor.getColumnIndex("day"));
            String hour = cursor.getString(cursor.getColumnIndex("hour"));
            String facilitator = cursor.getString(cursor.getColumnIndex("facilitator"));
            String description = cursor.getString(cursor.getColumnIndex("description"));
            events.add(new Event(id, title, Integer.parseInt(day), Integer.parseInt(hour), facilitator, description));
        }

        cursor.close();

        return events;
    }

    public static Event getLast() {
        Event event;

        String getAllQuery = "SELECT * FROM " + TABLE_EVENTS + " ORDER BY event_id DESC";

        Cursor cursor = gw.getDatabase().rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("event_id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String day = cursor.getString(cursor.getColumnIndex("day"));
            String hour = cursor.getString(cursor.getColumnIndex("hour"));
            String facilitator = cursor.getString(cursor.getColumnIndex("facilitator"));
            String description = cursor.getString(cursor.getColumnIndex("description"));

            event = new Event(id, title, Integer.parseInt(day), Integer.parseInt(hour), facilitator, description);
            cursor.close();

            return event;
        }

        return null;
    }



}
