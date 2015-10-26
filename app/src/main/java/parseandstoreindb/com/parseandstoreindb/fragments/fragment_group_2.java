package parseandstoreindb.com.parseandstoreindb.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import parseandstoreindb.com.parseandstoreindb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_group_2 extends android.support.v4.app.Fragment {


    public Fragment_group_2() {
        // Required empty public constructor
    }

    public static Fragment_group_2 newInstance(){
        Fragment_group_2 fragment_group_2 = new Fragment_group_2();
        return fragment_group_2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group_2, container, false);
    }


}
