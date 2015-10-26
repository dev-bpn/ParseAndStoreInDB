package parseandstoreindb.com.parseandstoreindb.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class Fragment_group_1 extends android.support.v4.app.Fragment {

    private ListView listView;
    public Fragment_group_1() {
        // Required empty public constructor
    }

    public static Fragment_group_1 newInstance(){
        Fragment_group_1 fragment_group_1 = new Fragment_group_1();
        return fragment_group_1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group_1, container, false);
        listView = (ListView) view.findViewById(R.id.listView1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setAdapter(new ArrayAdapter<String>(getActivity() , android.R.layout.simple_list_item_1 , MainActivity.group_1));
    }
}
