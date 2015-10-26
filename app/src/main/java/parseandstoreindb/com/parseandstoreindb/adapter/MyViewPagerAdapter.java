package parseandstoreindb.com.parseandstoreindb.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import parseandstoreindb.com.parseandstoreindb.fragments.Fragment_group_1;
import parseandstoreindb.com.parseandstoreindb.fragments.Fragment_group_2;
import parseandstoreindb.com.parseandstoreindb.fragments.Fragment_group_3;

/**
 * Created by Dell on 10/26/2015.
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    private int count;
    public MyViewPagerAdapter(FragmentManager fm , int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment_group_1.newInstance();
                break;
            case 1:
                Fragment_group_2.newInstance();
                break;
            case 2:
                Fragment_group_3.newInstance();
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return count;
    }
}
