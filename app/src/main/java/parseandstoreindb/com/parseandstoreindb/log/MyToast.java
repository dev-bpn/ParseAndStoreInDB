package parseandstoreindb.com.parseandstoreindb.log;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Dell on 10/23/2015.
 */
public class MyToast {
    public static void showToast(Context context , String message){
        Toast.makeText(context , message , Toast.LENGTH_SHORT).show();
    }
}
