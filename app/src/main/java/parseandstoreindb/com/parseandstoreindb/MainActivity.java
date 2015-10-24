package parseandstoreindb.com.parseandstoreindb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import org.json.JSONException;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabase;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabaseAdapter;
import parseandstoreindb.com.parseandstoreindb.log.MyLog;
import parseandstoreindb.com.parseandstoreindb.log.MyToast;
import parseandstoreindb.com.parseandstoreindb.menu.Main_menu;
import parseandstoreindb.com.parseandstoreindb.utils.MyAppUtils;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyDatabaseAdapter(this);
        showData();

    }

    private void showData(){
        if(MyDatabaseAdapter.checkIfTableExists()){
            MyLog.showLog("File exists");
            try {
                MyDatabase.getDBData();
                MyToast.showToast(this, MyDatabase.group_1.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            MyLog.showLog("File don't exists");
            MyAppUtils.performVolleyRequest(this, MyAppUtils.URL);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        Main_menu.getMenu(id , this);
        return super.onOptionsItemSelected(item);
    }
}
