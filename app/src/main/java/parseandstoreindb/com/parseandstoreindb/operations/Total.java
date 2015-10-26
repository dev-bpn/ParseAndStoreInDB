package parseandstoreindb.com.parseandstoreindb.operations;

import parseandstoreindb.com.parseandstoreindb.log.MyLog;

/**
 * Created by Dell on 10/26/2015.
 */
public class Total {

    public static int getTotal(String string){

        String[] str1 = string.split(" ");
        MyLog.showLog("");

        String st1 = str1[0];
        String[] aa = st1.split("-");


        String aa1 = aa[0];
        String aaa[] = aa1.split(":");
        String a = aaa[0];
        String b = aaa[1];
        // ------------
        String aa2 = aa[1];
        String[] aaa2 = aa2.split(":");
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
}
