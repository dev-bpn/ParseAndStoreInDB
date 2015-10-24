package parseandstoreindb.com.parseandstoreindb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONException;

import parseandstoreindb.com.parseandstoreindb.database.DataFrom_DB;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabaseAdapter;
import parseandstoreindb.com.parseandstoreindb.log.MyLog;
import parseandstoreindb.com.parseandstoreindb.log.MyToast;
import parseandstoreindb.com.parseandstoreindb.utils.MyAppUtils;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyDatabaseAdapter(this);

        if(MyDatabaseAdapter.checkIfTableExists()){
            MyLog.showLog("File exists");
            try {
                DataFrom_DB.getDBData();
                MyToast.showToast(this, DataFrom_DB.group_1.toString());
                MyToast.showToast(this , DataFrom_DB.group_2.toString());
                MyToast.showToast(this , DataFrom_DB.group_3.toString());
                MyToast.showToast(this , DataFrom_DB.group_4.toString());
                MyToast.showToast(this , DataFrom_DB.group_5.toString());
                MyToast.showToast(this , DataFrom_DB.group_6.toString());
                MyToast.showToast(this , DataFrom_DB.group_7.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            MyLog.showLog("File don't exists");
            MyAppUtils.performVolleyRequest(this, MyAppUtils.URL);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
