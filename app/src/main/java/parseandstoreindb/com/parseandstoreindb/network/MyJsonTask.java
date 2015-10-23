package parseandstoreindb.com.parseandstoreindb.network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import parseandstoreindb.com.parseandstoreindb.database.MyDatabaseAdapter;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabaseAdapter.MySQLiteHelper;
import parseandstoreindb.com.parseandstoreindb.log.MyLog;

/**
 * Created by Dell on 10/23/2015.
 */
public class MyJsonTask {

    public static void parseJsonData(String stringResponse){
        try {
            JSONObject jsonObject = new JSONObject(stringResponse);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            JSONObject jsonObject1 = null;
            for (int i = 0 ; i < jsonArray.length() ; i++){
                jsonObject1 = jsonArray.getJSONObject(i);
                switch (i){
                    case 0:
                        long returnVal = MyDatabaseAdapter.insertData(MySQLiteHelper.GROUP_1, jsonObject1.toString());
                        break;
                    case 1:
                        long returnVal1 = MyDatabaseAdapter.insertData(MySQLiteHelper.GROUP_2, jsonObject1.toString());
                        break;
                }
            }

            MyLog.showLog(jsonObject1.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void getDays(JSONObject jsonObject){

        try {
            String sunday = jsonObject.getString("sunday");
            String monday = jsonObject.getString("monday");
            String tuesday = jsonObject.getString("tuesday");
            String wednesday = jsonObject.getString("wednesday");
            String thursday = jsonObject.getString("thursday");
            String friday = jsonObject.getString("friday");
            String saturday = jsonObject.getString("saturday");

            MyLog.showLog("");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
