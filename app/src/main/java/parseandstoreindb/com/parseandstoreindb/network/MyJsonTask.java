package parseandstoreindb.com.parseandstoreindb.network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import parseandstoreindb.com.parseandstoreindb.database.MyDatabaseAdapter;
import parseandstoreindb.com.parseandstoreindb.database.MySQLiteHelper;

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
                        MyDatabaseAdapter.insertData(MySQLiteHelper.GROUP_1, jsonObject1.toString());
                        break;
                    case 1:
                        MyDatabaseAdapter.insertData(MySQLiteHelper.GROUP_2, jsonObject1.toString());
                        break;
                    case 2:
                        MyDatabaseAdapter.insertData(MySQLiteHelper.GROUP_3 , jsonObject1.toString());
                        break;
                    case 3:
                        MyDatabaseAdapter.insertData(MySQLiteHelper.GROUP_4 , jsonObject1.toString());
                        break;
                    case 4:
                        MyDatabaseAdapter.insertData(MySQLiteHelper.GROUP_5 , jsonObject1.toString());
                        break;
                    case 5:
                        MyDatabaseAdapter.insertData(MySQLiteHelper.GROUP_6 , jsonObject1.toString());
                        break;
                    case 6:
                        MyDatabaseAdapter.insertData(MySQLiteHelper.GROUP_7 , jsonObject1.toString());
                        break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
