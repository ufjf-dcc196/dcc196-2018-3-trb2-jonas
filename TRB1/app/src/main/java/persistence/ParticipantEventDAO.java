package persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import model.Participant;
import model.Event;

public class ParticipantEventDAO {

    private static final String TABLE_PARTICIPANT_EVENT = "participant_event";
    private static DBGateway gw;

    public ParticipantEventDAO(Context ctx){
        gw = DBGateway.getInstance(ctx);
    }

    public static boolean create(int participant_id, int event_id){
        ContentValues cv = new ContentValues();
        cv.put("participant_id", participant_id);
        cv.put("event_id", event_id);
        return gw.getDatabase().insert(TABLE_PARTICIPANT_EVENT, null, cv) > 0;
    }

    public static ArrayList<Participant> getParticipants(Context ctx, int eventId) {
        ArrayList<Participant> participants = new ArrayList<>();

        Cursor cursor = gw.getDatabase().rawQuery("SELECT participant_id FROM " + TABLE_PARTICIPANT_EVENT +
                                                      " WHERE event_id =" + eventId, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("participant_id"));

            ParticipantDAO participantDAO = new ParticipantDAO(ctx);
            participants.add(participantDAO.read(id));
        }

        cursor.close();

        return participants;
    }

    public static ArrayList<Event> getEvents(Context ctx, int participantId) {
        ArrayList<Event> events = new ArrayList<>();

        Cursor cursor = gw.getDatabase().rawQuery("SELECT event_id FROM " + TABLE_PARTICIPANT_EVENT +
                " WHERE participant_id =" + participantId, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("event_id"));

            EventDAO eventDAO = new EventDAO(ctx);
            events.add(eventDAO.read(id));
        }

        cursor.close();

        return events;
    }

    public static int getId(int participantId, int eventId){
        int id = -1;
        String getAllQuery ="SELECT participant_event_id FROM " + TABLE_PARTICIPANT_EVENT +
                            " WHERE participant_id == " + participantId +
                            " AND event_id == " + eventId;

        Cursor cursor = gw.getDatabase().rawQuery(getAllQuery, null);

        if (cursor.moveToFirst()){
            id = cursor.getInt(cursor.getColumnIndex("participant_event_id"));
            cursor.close();
        }

        return id;
    }

    public static boolean delete(int id){
        return gw.getDatabase().delete(TABLE_PARTICIPANT_EVENT, "participant_event_id=?", new String[]{ id + "" }) > 0;
    }
}
