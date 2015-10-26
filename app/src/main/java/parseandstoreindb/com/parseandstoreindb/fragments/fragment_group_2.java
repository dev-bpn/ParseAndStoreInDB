package parseandstoreindb.com.parseandstoreindb.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import parseandstoreindb.com.parseandstoreindb.MainActivity;
import parseandstoreindb.com.parseandstoreindb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_group_2 extends android.support.v4.app.Fragment {

    private ListView listView;
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
        View view = inflater.inflate(R.layout.fragment_group_2, container, false);
        listView = (ListView) view.findViewById(R.id.listView2);
        if(MainActivity.group_2 != null){
            listView.setAdapter(new ArrayAdapter<String>(getActivity() , android.R.layout.simple_list_item_1 , MainActivity.group_2));
        }else{
            listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, MainActivity.def_group));
        }
        return view;
    }

}
