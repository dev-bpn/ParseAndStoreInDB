package parseandstoreindb.com.parseandstoreindb.operations;

import java.util.Calendar;

import parseandstoreindb.com.parseandstoreindb.log.MyLog;

/**
 * Created by Dell on 10/26/2015.
 */
public class Total {

    public static int getTotal(String string){

        if(string.startsWith(" ")){
            string = string.replaceFirst(" ","");
        }

        String[] str1 = string.split(" ");
        MyLog.showLog("");

        String st1 = str1[0];
        String[] aa = st1.split("-");


        String a1 = aa[0];
        String aaa[] = a1.split(":");
        String a = aaa[0];
        String b = aaa[1];
        // ------------
        String a2 = aa[1];
        String[] aaa2 = a2.split(":");
        String c = aaa2[0];
        String d = aaa2[1];

        //-----------------------------------------------------

        String st2 = str1[1];
        String[] stt2 = st2.split("-");


        String b1 = stt2[0];
        String[] mm = b1.split(":");
        String e = mm[0];
        String f = mm[1];

        //---------------

        String b2 = stt2[1];
        String[] nn = b2.split(":");
        String g = nn[0];
        String h = nn[1];

        getAmPm(a1 , a2 , b1 , b2);

        int z1 = Integer.valueOf(a) * 60 * 60;
        int z2 = Integer.valueOf(b) * 60;
        int z3 = Integer.valueOf(c) * 60 * 60;
        int z4 = Integer.valueOf(d) * 60;
        int total1 = ((z1 + z2 ) - (z3 + z4))/3600;
        String result1 = String.valueOf(total1).replaceAll("[-+.^:,]","");

        int y1 = Integer.valueOf(e) * 60 * 60;
        int y2 = Integer.valueOf(f) * 60;
        int y3 = Integer.valueOf(g) * 60 * 60;
        int y4 = Integer.valueOf(h) * 60;
        int total2 = ((y1 + y2 ) - (y3 + y4))/3600;
        String result2 = String.valueOf(total1).replaceAll("[-+.^:,]","");

        int result = Integer.parseInt(result1) + Integer.parseInt(result2);
        MyLog.showLog("");

        return result;
    }

    public static String getDay(){

        String weekDay = "";

        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        if (Calendar.TUESDAY == dayOfWeek) {
            weekDay = "tuesday";
        } else if (Calendar.WEDNESDAY == dayOfWeek) {
            weekDay = "wednesday";
        } else if (Calendar.THURSDAY == dayOfWeek) {
            weekDay = "thursday";
        } else if (Calendar.FRIDAY == dayOfWeek) {
            weekDay = "friday";
        } else if (Calendar.SATURDAY == dayOfWeek) {
            weekDay = "saturday";
        } else if (Calendar.MONDAY == dayOfWeek) {
            weekDay = "monday";
        } else if (Calendar.SUNDAY == dayOfWeek) {
            weekDay = "sunday";
        }

        return weekDay;

    }

    public static String getAmPm(String a1 , String a2 , String b1 , String b2){

        String aaa[] = a1.split(":");
        int a = Integer.parseInt(aaa[0]);
        // ------------

        String[] aaa2 = a2.split(":");
        int c = Integer.parseInt(aaa2[0]);

        //----------------------------

        String[] mm = b1.split(":");
        int e = Integer.parseInt(mm[0]);

        //---------------

        String[] nn = b2.split(":");
        int g = Integer.parseInt(nn[0]);

        if(c < a){
            a2 = a2.concat(" pm ");
        }else{
            a2 = a2.concat(" am ");
        }

        a1 = a1.concat(" am ");
        b1 = b1.concat(" pm ");
        b2 = b2.concat(" pm ");

        String res = a1 + a2 + b1 + b2;

        return a1 + a2 + b1 + b2;
    }

    
}
