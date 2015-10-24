package parseandstoreindb.com.parseandstoreindb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import parseandstoreindb.com.parseandstoreindb.database.ArrayResponse;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabase;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabaseAdapter;
import parseandstoreindb.com.parseandstoreindb.log.MyLog;
import parseandstoreindb.com.parseandstoreindb.log.MyToast;
import parseandstoreindb.com.parseandstoreindb.menu.Main_menu;
import parseandstoreindb.com.parseandstoreindb.network.MyJsonTask;
import parseandstoreindb.com.parseandstoreindb.utils.MyAppUtils;

public class MainActivity extends AppCompatActivity implements ArrayResponse{

    private MyDatabaseAdapter adapter;
    public static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        MyDatabase.response = this;

        adapter = new MyDatabaseAdapter(this);
        showData();

    }


    private void showData(){
        if(MyDatabaseAdapter.checkIfTableExists()){
            MyLog.showLog("File exists");
            MyDatabase.getDBData();

            listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MyDatabase.group_1));
            MyToast.showToast(this, MyDatabase.group_1.toString());

        }else{
            MyLog.showLog("File don't exists");
            MyJsonTask.performVolleyRequest(this, MyAppUtils.URL);
        }
    }


    public void add(View view){
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MyDatabase.group_7));
    }

    @Override
    public void processFinish(ArrayList results) {
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results));
        MyLog.showLog(results.toString());
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
