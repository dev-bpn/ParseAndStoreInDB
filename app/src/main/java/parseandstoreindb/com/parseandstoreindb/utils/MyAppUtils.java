package parseandstoreindb.com.parseandstoreindb.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import parseandstoreindb.com.parseandstoreindb.log.MyLog;
import parseandstoreindb.com.parseandstoreindb.log.MyToast;
import parseandstoreindb.com.parseandstoreindb.network.MyJsonTask;

/**
 * Created by Dell on 10/23/2015.
 */
public class MyAppUtils {

    public static final String URL = "https://api.import.io/store/data/10332935-d928-4f84-a4e4-ad1c449fc95b/_query?input/webpage/url=http%3A%2F%2Fbattigayo.com%2Fschedule&_user=9233c692-537f-4594-b799-fb2205a1074e&_apikey=9233c692537f4594b799fb2205a1074eb39e630c37c0914ed01fcb84dd0748a4ccc3d573dd764382db3e8c0568e20bd5e65e2670b26bdcedeb163b073146057551faa3cfd012eede3a59028fe3ede24e";

    public static void performVolleyRequest(final Context context , String url) {
        if (isNetworkConnected(context)) {
            RequestQueue requestQueue = Volley.newRequestQueue(context);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String responseString) {
                    MyLog.showLog(responseString);
                    if(!responseString.isEmpty()){
                    MyToast.showToast(context, responseString);
                        MyJsonTask.parseJsonData(responseString);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    MyLog.showLog("onErrorResponse: "+volleyError.toString());
                }
            });
            requestQueue.add(stringRequest);
        }else{
            MyToast.showToast(context, "No internet connection");
        }
    }

    public static boolean isNetworkConnected(Context context){

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo == null){
            return false;
        }else{
            return networkInfo.getType() == ConnectivityManager.TYPE_WIFI ||
                    networkInfo.getType() == ConnectivityManager.TYPE_MOBILE ||
                    networkInfo.getType() == ConnectivityManager.TYPE_WIMAX;
        }
    }
}
