package parseandstoreindb.com.parseandstoreindb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import parseandstoreindb.com.parseandstoreindb.log.MyLog;
import parseandstoreindb.com.parseandstoreindb.log.MyToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        performVolleyRequest();
    }

    private void performVolleyRequest(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.import.io/store/data/468092da-b39e-4741-8744-108cb34b91c9/_query?input/webpage/url=http%3A%2F%2Fbattigayo.com%2Fschedule&_user=9233c692-537f-4594-b799-fb2205a1074e&_apikey=9233c692537f4594b799fb2205a1074eb39e630c37c0914ed01fcb84dd0748a4ccc3d573dd764382db3e8c0568e20bd5e65e2670b26bdcedeb163b073146057551faa3cfd012eede3a59028fe3ede24e";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String responseString) {
                MyLog.showLog(responseString);
                if(!responseString.isEmpty()){
                    MyToast.showToast(getApplicationContext() , responseString);
                    parseJsonData(responseString);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                MyLog.showLog("onErrorResponse: "+volleyError.toString());
            }
        });
        requestQueue.add(stringRequest);
    }

    private void parseJsonData(String stringResponse){
        try {
            JSONObject jsonObject = new JSONObject(stringResponse);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            JSONObject jsonObject1 = jsonArray.getJSONObject(1);
            MyLog.showLog(jsonObject1.toString());
        } catch (JSONException e) {
            e.printStackTrace();
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
