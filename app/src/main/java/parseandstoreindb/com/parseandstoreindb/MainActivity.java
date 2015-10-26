package parseandstoreindb.com.parseandstoreindb;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import parseandstoreindb.com.parseandstoreindb.adapter.MyViewPagerAdapter;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabase;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabaseAdapter;
import parseandstoreindb.com.parseandstoreindb.interfaces.MyArrayResponse;
import parseandstoreindb.com.parseandstoreindb.log.MyLog;
import parseandstoreindb.com.parseandstoreindb.log.MyToast;
import parseandstoreindb.com.parseandstoreindb.menu.Main_menu;
import parseandstoreindb.com.parseandstoreindb.network.MyJsonTask;
import parseandstoreindb.com.parseandstoreindb.operations.Total;
import parseandstoreindb.com.parseandstoreindb.utils.MyAppUtils;

public class MainActivity extends AppCompatActivity implements MyArrayResponse{

    private ViewPager viewPager;
    private MyDatabaseAdapter adapter;

    public static ArrayList<String> group_1 ;
    public static ArrayList<String> group_2 ;
    public static ArrayList<String> group_3 ;
    public static ArrayList<String> group_4 ;
    public static ArrayList<String> group_5 ;
    public static ArrayList<String> group_6 ;
    public static ArrayList<String> group_7 ;
    public static String[] def_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager() , 3));
        viewPager.getAdapter().notifyDataSetChanged();

        MyDatabase.response = this;
        adapter = new MyDatabaseAdapter(this);

        showData();

        def_group = getResources().getStringArray(R.array.default_data);

    }


    private void showData(){
        if(MyDatabaseAdapter.checkIfTableExists()){
            MyLog.showLog("File exists");
            MyDatabase.getDBData();
            MyToast.showToast(this, group_1.toString());

        }else{
            MyLog.showLog("File don't exists");
            MyJsonTask.performVolleyRequest(this, MyAppUtils.URL);
        }
    }

    public void totalTime(View view){

        if(Total.getDay().equals("sunday")) {

            String str = group_1.get(0);
            int totalTime = Total.getTotal(str);

        }else if(Total.getDay().equals("monday") ){

            String str = group_1.get(1);
            int totalTime = Total.getTotal(str);

        }else if(Total.getDay().equals("tuesday") ){

            String str = group_1.get(2);
            int totalTime = Total.getTotal(str);

        }else if(Total.getDay().equals("wednesday") ){

            String str = group_1.get(3);
            int totalTime = Total.getTotal(str);

        }else if(Total.getDay().equals("thursday") ){

            String str = group_1.get(4);
            int totalTime = Total.getTotal(str);

        }else if(Total.getDay().equals("friday") ){

            String str = group_1.get(5);
            int totalTime = Total.getTotal(str);

        }else if(Total.getDay().equals("saturday") ){

            String str = group_1.get(6);
            int totalTime = Total.getTotal(str);

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

        group_1_str = group_1_str.replaceAll("\\[", "").replaceAll("\\]","");
        group_2_str = group_2_str.replaceAll("\\[", "").replaceAll("\\]","");
        group_3_str = group_3_str.replaceAll("\\[", "").replaceAll("\\]","");
        group_4_str = group_4_str.replaceAll("\\[", "").replaceAll("\\]","");
        group_5_str = group_5_str.replaceAll("\\[", "").replaceAll("\\]","");
        group_6_str = group_6_str.replaceAll("\\[", "").replaceAll("\\]","");
        group_7_str = group_7_str.replaceAll("\\[", "").replaceAll("\\]","");


        group_1 = new ArrayList<String>(Arrays.asList(group_1_str.split(",")));
        group_2 = new ArrayList<String>(Arrays.asList(group_2_str.split(",")));
        group_3 = new ArrayList<String>(Arrays.asList(group_3_str.split(",")));
        group_4 = new ArrayList<String>(Arrays.asList(group_4_str.split(",")));
        group_5 = new ArrayList<String>(Arrays.asList(group_5_str.split(",")));
        group_6 = new ArrayList<String>(Arrays.asList(group_6_str.split(",")));
        group_7 = new ArrayList<String>(Arrays.asList(group_7_str.split(",")));

        MyToast.showToast(this, group_1.toString());

        viewPager.getAdapter().notifyDataSetChanged();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
