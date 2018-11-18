package persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "events.db";

    private static final String TABLE_PARTICIPANTS = "participants";
    private static final String COLUMN_PARTICIPANT_ID = "participant_id";
    private static final String COLUMN_REGISTER_NUMBER = "register_number";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_MAIL = "mail";

    private static final String TABLE_EVENTS = "events";
    private static final String COLUMN_EVENT_ID = "event_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DAY = "day";
    private static final String COLUMN_HOUR = "hour";
    private static final String COLUMN_FACILITATOR = "facilitator";
    private static final String COLUMN_DESCRIPTION = "description";

    private static final String TABLE_PARTICIPANT_EVENT = "participant_event";
    private static final String COLUMN_DATE = "date";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_participant_table = "CREATE TABLE " + TABLE_PARTICIPANTS + "(" +
                COLUMN_PARTICIPANT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_REGISTER_NUMBER + " INTEGER " +
                COLUMN_NAME + " TEXT " +
                COLUMN_MAIL + " TEXT" +
                ");";

        db.execSQL(create_participant_table);

        String create_event_table = "CREATE TABLE " + TABLE_EVENTS + "(" +
                COLUMN_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_TITLE + " TEXT " +
                COLUMN_DAY + " INTEGER " +
                COLUMN_HOUR + " INTEGER " +
                COLUMN_FACILITATOR + " TEXT" +
                COLUMN_DESCRIPTION + " TEXT" +
                ");";

        db.execSQL(create_event_table);

        String create_participant_event_table = "CREATE TABLE " + TABLE_PARTICIPANT_EVENT + "(" +
                COLUMN_PARTICIPANT_ID + " INTEGER " +
                COLUMN_EVENT_ID + " INTEGER " +
                COLUMN_DATE + " TEXT " +
                ");";

        db.execSQL(create_participant_event_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARTICIPANTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARTICIPANT_EVENT);
        onCreate(db);
    }
}
