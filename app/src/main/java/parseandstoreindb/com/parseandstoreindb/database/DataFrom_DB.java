package parseandstoreindb.com.parseandstoreindb.database;

import parseandstoreindb.com.parseandstoreindb.log.MyLog;

/**
 * Created by Dell on 10/23/2015.
 */
public class DataFrom_DB {

    public static void getDBData() {
        String[] columnData = {
                MyDatabaseAdapter.MySQLiteHelper.GROUP_1, MyDatabaseAdapter.MySQLiteHelper.GROUP_2,
                MyDatabaseAdapter.MySQLiteHelper.GROUP_3, MyDatabaseAdapter.MySQLiteHelper.GROUP_4,
                MyDatabaseAdapter.MySQLiteHelper.GROUP_5, MyDatabaseAdapter.MySQLiteHelper.GROUP_6,
                MyDatabaseAdapter.MySQLiteHelper.GROUP_6};
        for(int i = 0 ; i < columnData.length; i++){
            switch (i){
                case 0:
                    String column1 = MyDatabaseAdapter.getColumnData(columnData, 0);
                    int length = column1.length();
                    MyLog.showLog(column1);
                    break;
                case 1:
                    String column2 = MyDatabaseAdapter.getColumnData(columnData, 1);
                    int length2 = column2.length();
                    MyLog.showLog(column2);
                    break;
                case 2:
                    String column3 = MyDatabaseAdapter.getColumnData(columnData, 2);
                    int length3 = column3.length();
                    MyLog.showLog(column3);
                    break;
            }
        }

    }

}
