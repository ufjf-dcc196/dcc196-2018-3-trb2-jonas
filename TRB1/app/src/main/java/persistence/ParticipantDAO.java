package persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import model.Participant;

public class ParticipantDAO {

    private static final String TABLE_PARTICIPANTS = "participants";
    private static DBGateway gw;

    public ParticipantDAO(Context ctx){
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
        Participant participant;

        String getAllQuery = "SELECT * FROM " + TABLE_PARTICIPANTS + " WHERE name LIKE '%" + participantName + "%'";

        Cursor cursor = gw.getDatabase().rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("participant_id"));
            String register_number = cursor.getString(cursor.getColumnIndex("register_number"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String mail = cursor.getString(cursor.getColumnIndex("mail"));
            participant = new Participant(id, register_number, name, mail);

            cursor.close();

            return participant;
        }

        return null;
    }

    public static boolean update(int id, String registerNumber, String name, String mail) {
        if (!(id > 0))
            return create(registerNumber, name, mail);

        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("register_number", registerNumber);
        cv.put("mail", mail);

        return gw.getDatabase().update(TABLE_PARTICIPANTS, cv, "participant_id=?", new String[]{ id + "" }) > 0;
    }

    public static int getId(String name){
        int id = -1;
        String getAllQuery = "SELECT participant_id FROM " + TABLE_PARTICIPANTS + " WHERE name LIKE '%" + name + "%'";

        Cursor cursor = gw.getDatabase().rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()){
            id = cursor.getInt(cursor.getColumnIndex("participant_id"));
            cursor.close();
        }

        return id;
    }

    public static ArrayList<Participant> getAll() {
        ArrayList<Participant> participants = new ArrayList<>();

        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM " + TABLE_PARTICIPANTS, null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("participant_id"));
            String register_number = cursor.getString(cursor.getColumnIndex("register_number"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String mail = cursor.getString(cursor.getColumnIndex("mail"));
            participants.add(new Participant(id, register_number, name, mail));
        }

        cursor.close();

        return participants;
    }

    public static Participant getLast() {
        Participant participant;

        String getAllQuery = "SELECT * FROM " + TABLE_PARTICIPANTS + " ORDER BY participant_id DESC";

        Cursor cursor = gw.getDatabase().rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("participant_id"));
            String register_number = cursor.getString(cursor.getColumnIndex("register_number"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String mail = cursor.getString(cursor.getColumnIndex("mail"));
            participant = new Participant(id, register_number, name, mail);
            cursor.close();

            return participant;
        }

        return null;
    }

    public static Participant read(int id) {
        Participant participant;

        String getAllQuery = "SELECT * FROM " + TABLE_PARTICIPANTS + " WHERE participant_id =" + id;

        Cursor cursor = gw.getDatabase().rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()){
            String register_number = cursor.getString(cursor.getColumnIndex("register_number"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String mail = cursor.getString(cursor.getColumnIndex("mail"));
            participant = new Participant(id, register_number, name, mail);


            cursor.close();

            return participant;
        }

        return null;

    }
}
