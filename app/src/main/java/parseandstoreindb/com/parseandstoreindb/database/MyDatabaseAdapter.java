package parseandstoreindb.com.parseandstoreindb.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Dell on 10/23/2015.
 */
public class MyDatabaseAdapter {

    private MySQLiteHelper helper;
    private static SQLiteDatabase database;

    public MyDatabaseAdapter(Context context){
        helper = new MySQLiteHelper(context);
        database = helper.getWritableDatabase();
    }

    public static long insertData(String groupNo , String strValue){
        ContentValues contentValues = new ContentValues();
        contentValues.put(groupNo , strValue);
        long id = database.insert(MySQLiteHelper.TABLE_NAME , null , contentValues);
        return id;
    }

    public static String getColumnData(String[] columnName , int position){
        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME, columnName, null, null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()){
            String data  = cursor.getString(position);
            stringBuffer.append(data);
        }
        return stringBuffer.toString();

    }

    public static int deleteColumnData(){
        int rowAffected = database.delete(MySQLiteHelper.TABLE_NAME, null, null);
        return rowAffected;
    }

    public static boolean checkIfTableExists(){
        String[] columns = {};
        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME, columns, null, null, null, null, null, "1");
        if (cursor.moveToFirst()) {
            return true; // a row was found
        }
        return false; // no row was found
    }

}
