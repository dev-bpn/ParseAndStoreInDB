package parseandstoreindb.com.parseandstoreindb.database;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import parseandstoreindb.com.parseandstoreindb.log.MyLog;

/**
 * Created by Dell on 10/23/2015.
 */
public class MyDatabase{

    public static ArrayList<String> group_1 = new ArrayList<>();
    public static ArrayList<String> group_2 = new ArrayList<>();
    public static ArrayList<String> group_3 = new ArrayList<>();
    public static ArrayList<String> group_4 = new ArrayList<>();
    public static ArrayList<String> group_5 = new ArrayList<>();
    public static ArrayList<String> group_6 = new ArrayList<>();
    public static ArrayList<String> group_7 = new ArrayList<>();

    public static void getDBData() {
        String[] columnData = {
                MySQLiteHelper.GROUP_1, MySQLiteHelper.GROUP_2,
                MySQLiteHelper.GROUP_3, MySQLiteHelper.GROUP_4,
                MySQLiteHelper.GROUP_5, MySQLiteHelper.GROUP_6,
                MySQLiteHelper.GROUP_6};
        for(int i = 0 ; i < columnData.length; i++){
            switch (i){
                case 0:
                    String column1 = MyDatabaseAdapter.getColumnData(columnData, 0);
                    group_1 = getDays(column1);
                    MyLog.showLog("GROUP_1 "+group_1.toString());
                    break;
                case 1:
                    String column2 = MyDatabaseAdapter.getColumnData(columnData, 1);
                    column2 = column2.replace("null" , "");
                    group_2 = getDays(column2);
                    MyLog.showLog("GROUP_2 "+group_2.toString());
                    break;
                case 2:
                    String column3 = MyDatabaseAdapter.getColumnData(columnData, 2);
                    column3 = column3.replace("null" , "");
                    group_3 = getDays(column3);
                    MyLog.showLog("GROUP_3 "+group_3.toString());
                    break;
                case 3:
                    String column4 = MyDatabaseAdapter.getColumnData(columnData, 3);
                    column4 = column4.replace("null" , "");
                    group_4 = getDays(column4);
                    MyLog.showLog("GROUP_4 "+group_4.toString());
                    break;
                case 4:
                    String column5 = MyDatabaseAdapter.getColumnData(columnData, 4);
                    column5 = column5.replace("null" , "");
                    group_5 = getDays(column5);
                    MyLog.showLog("GROUP_5 "+group_5.toString());
                    break;
                case 5:
                    String column6 = MyDatabaseAdapter.getColumnData(columnData, 5);
                    column6 = column6.replace("null" , "");
                    group_6 = getDays(column6);
                    MyLog.showLog("GROUP_6 "+group_6.toString());
                    break;
                case 6:
                    String column7 = MyDatabaseAdapter.getColumnData(columnData, 6);
                    column7 = column7.replace("null" , "");
                    group_7 = getDays(column7);
                    MyLog.showLog("GROUP_7 "+group_7.toString());
                    break;
            }
        }

    }


    public static ArrayList<String> getDays(String jsonString){
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            String sunday = jsonObject.getString("sunday");
            String monday = jsonObject.getString("monday");
            String tuesday = jsonObject.getString("tuesday");
            String wednesday = jsonObject.getString("wednesday");
            String thursday = jsonObject.getString("thursday");
            String friday = jsonObject.getString("friday");
            String saturday = jsonObject.getString("saturday");

            arrayList.add(sunday);
            arrayList.add(monday);
            arrayList.add(tuesday);
            arrayList.add(wednesday);
            arrayList.add(thursday);
            arrayList.add(friday);
            arrayList.add(saturday);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
