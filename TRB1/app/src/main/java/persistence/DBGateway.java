package persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBGateway {

    private static DBGateway gw;
    private SQLiteDatabase db;

    private DBGateway(Context ctx){
        DBHandler helper = new DBHandler(ctx);
        db = helper.getWritableDatabase();
    }

    public static DBGateway getInstance(Context ctx){
        if(gw == null)
            gw = new DBGateway(ctx);
        return gw;
    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }

}
