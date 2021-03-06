package parseandstoreindb.com.parseandstoreindb.menu;

import android.content.Context;

import parseandstoreindb.com.parseandstoreindb.MainActivity;
import parseandstoreindb.com.parseandstoreindb.R;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabaseAdapter;
import parseandstoreindb.com.parseandstoreindb.log.MyLog;
import parseandstoreindb.com.parseandstoreindb.network.MyJsonTask;
import parseandstoreindb.com.parseandstoreindb.utils.MyAppUtils;

/**
 * Created by Dell on 10/24/2015.
 */
public class Main_menu {

    public static void getMenu(int id , Context context){
        if (id == R.id.action_refresh) {

            if(MyDatabaseAdapter.checkIfTableExists()){
                int rowAffected = MyDatabaseAdapter.deleteColumnData();
                if(rowAffected > 0)
                {
                    MyLog.showLog("DataDeleted " + rowAffected);
                    MyJsonTask.performVolleyRequest(context, MyAppUtils.URL);
                }
            }else{
                MyJsonTask.performVolleyRequest(context, MyAppUtils.URL);
            }


        }
    }
}
