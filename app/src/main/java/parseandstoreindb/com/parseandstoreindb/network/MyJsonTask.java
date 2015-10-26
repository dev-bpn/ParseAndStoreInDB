package parseandstoreindb.com.parseandstoreindb.network;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import parseandstoreindb.com.parseandstoreindb.database.MyDatabase;
import parseandstoreindb.com.parseandstoreindb.database.MyDatabaseAdapter;
import parseandstoreindb.com.parseandstoreindb.database.MySQLiteHelper;
import parseandstoreindb.com.parseandstoreindb.log.MyLog;
import parseandstoreindb.com.parseandstoreindb.log.MyToast;
import parseandstoreindb.com.parseandstoreindb.utils.MyAppUtils;

/**
 * Created by Dell on 10/23/2015.
 */
public class MyJsonTask{

    private static ProgressDialog progressDialog;

    public static void performVolleyRequest(final Context context , String url) {
        if (MyAppUtils.isNetworkConnected(context)) {

            showProgressDialog(context, "Loading for first time, Please wait...");
            RequestQueue requestQueue = Volley.newRequestQueue(context);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String responseString) {
                    MyLog.showLog(responseString);
                    if(!responseString.isEmpty()){
                        insertParsedJsonData(responseString);
                        progressDialog.dismiss();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    MyLog.showLog("onErrorResponse: "+volleyError.toString());
                    progressDialog.dismiss();
                    MyToast.showToast(context , "onErrorResponse" );
                }
            });
            requestQueue.add(stringRequest);
        }else{
            MyToast.showToast(context, "No internet connection");
        }
    }


    private static void insertParsedJsonData(String stringResponse){
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
        }finally {
            MyDatabase.getDBData();
        }
    }

    public static void showProgressDialog(Context context , String message){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
}
