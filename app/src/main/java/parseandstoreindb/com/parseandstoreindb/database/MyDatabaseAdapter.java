package parseandstoreindb.com.parseandstoreindb.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import parseandstoreindb.com.parseandstoreindb.log.MyLog;

/**
 * Created by Dell on 10/23/2015.
 */
public class MyDatabaseAdapter {

    private MySQLiteHelper helper;
    private SQLiteDatabase database;
    public MyDatabaseAdapter(Context context){
        helper = new MySQLiteHelper(context);
        database = helper.getWritableDatabase();
    }

    public class MySQLiteHelper extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "my_database";
        public static final int DATABASE_VERSION = 7;
        public static final String TABLE_NAME = "my_table";
        public static final String UID = "_id";
        public static final String GROUP_1 = "Group_1";
        public static final String GROUP_2 = "Group_2";
        public static final String GROUP_3 = "Group_3";
        public static final String GROUP_4 = "Group_4";
        public static final String GROUP_5 = "Group_5";
        public static final String GROUP_6 = "Group_6";
        public static final String GROUP_7 = "Group_7";

        private static final String CREATE_TABLE= "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+GROUP_1+" Varchar(255) , "+GROUP_2+"  VARCHAR(255) , "+GROUP_3+" VARCHAR(255) , "+GROUP_4+" VARCHAR(255) , "+GROUP_5+" VARCHAR(255) , "+GROUP_6+" VARCHAR(255) , "+GROUP_7+" VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;


        public MySQLiteHelper(Context context) {
            super(context , DATABASE_NAME , null , DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                sqLiteDatabase.execSQL(CREATE_TABLE);
                MyLog.showLog("SQLiteDB onCreateSQLite database execute");
            } catch (SQLException e) {
                MyLog.showLog("SQLiteDB onCreateSQLite database: "+ e);
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            MyLog.showLog("SQLiteDB onUpdate()");
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }
    }
}
