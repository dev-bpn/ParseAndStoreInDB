package parseandstoreindb.com.parseandstoreindb;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

import parseandstoreindb.com.parseandstoreindb.database.MyArrayResponse;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabase;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabaseAdapter;
import parseandstoreindb.com.parseandstoreindb.log.MyLog;
import parseandstoreindb.com.parseandstoreindb.log.MyToast;
import parseandstoreindb.com.parseandstoreindb.menu.Main_menu;
import parseandstoreindb.com.parseandstoreindb.network.MyJsonTask;
import parseandstoreindb.com.parseandstoreindb.utils.MyAppUtils;

public class MainActivity extends AppCompatActivity implements MyArrayResponse {

    private ViewPager viewPager;
    private MyDatabaseAdapter adapter;
    public static ArrayList<String> group_1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        MyDatabase.response = this;
        adapter = new MyDatabaseAdapter(this);

        showData();

    }


    private void showData(){
        if(MyDatabaseAdapter.checkIfTableExists()){
            MyLog.showLog("File exists");
            MyToast.showToast(this, "CHECK MAH "+group_1.toString());

        }else{
            MyLog.showLog("File don't exists");
            MyJsonTask.performVolleyRequest(this, MyAppUtils.URL);
        }
    }

    @Override
    public void processFinish(Object results) {
        MyLog.showLog(results.toString());

        ArrayList myArrayList = (ArrayList) results;
        String group_1_str = myArrayList.get(0).toString();
        String group_2_str = myArrayList.get(1).toString();
        String group_3_str = myArrayList.get(2).toString();
        String group_4_str = myArrayList.get(3).toString();
        String group_5_str = myArrayList.get(4).toString();
        String group_6_str = myArrayList.get(5).toString();
        String group_7_str = myArrayList.get(6).toString();

        group_1 = new ArrayList<String>(Arrays.asList(group_1_str.split(",")));

        MyToast.showToast(this, group_1.toString());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Main_menu.getMenu(id, this);
        return super.onOptionsItemSelected(item);
    }
}
