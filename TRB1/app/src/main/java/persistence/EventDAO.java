package persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import model.Participant;

public class EventDAO {

    private static final String TABLE_PARTICIPANTS = "participants.db";
    private static DBGateway gw;

    public EventDAO(Context ctx){
        gw = DBGateway.getInstance(ctx);
    }

    public static boolean create(String registerNumber, String name, String mail){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("register_number", registerNumber);
        cv.put("mail", mail);
        return gw.getDatabase().insert(TABLE_PARTICIPANTS, null, cv) > 0;
    }

    public static Participant read(String participantName) {
        return null;
    }

    public static boolean update(Participant participant) {
        return false;
    }

    public static ArrayList<model.Event> getAll() {
        ArrayList<model.Event> participants = new ArrayList<>();

        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM " + TABLE_PARTICIPANTS, null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("participant_id"));
            String register_number = cursor.getString(cursor.getColumnIndex("register_number"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String mail = cursor.getString(cursor.getColumnIndex("mail"));
            //participants.add(new Participant(id, register_number, name, mail));
        }

        cursor.close();

        return participants;
    }

    public static Participant getLast() {
        Participant participant = null;

        String getAllQuery = "SELECT * FROM " + TABLE_PARTICIPANTS + " ORDER BY ID DESC";

        Cursor cursor = gw.getDatabase().rawQuery(getAllQuery, null);

        while (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("participant_id"));
            String register_number = cursor.getString(cursor.getColumnIndex("register_number"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String mail = cursor.getString(cursor.getColumnIndex("mail"));
            participant = new Participant(id, register_number, name, mail);
        }

        cursor.close();

        return participant;
    }

}
