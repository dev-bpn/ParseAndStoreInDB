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
public class Fragment_group_3 extends Fragment {


    public Fragment_group_3() {
        // Required empty public constructor
    }

    public static Fragment_group_3 newInstance(){
        Fragment_group_3 fragment_group_3 = new Fragment_group_3();
        return fragment_group_3;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fraagment_group_3, container, false);
    }


}
