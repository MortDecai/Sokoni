package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.farmersmarket.john.sokoni.R;

import java.util.ArrayList;
import java.util.List;

import adapters.ListAdapter;
import other.ListItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListAdapter adapter;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.list_settings);
        adapter = new ListAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private List<ListItem> getData() {

        List<ListItem> data = new ArrayList<>();

        String[] titles = getResources().getStringArray(R.array.settings_list_menu);

        for(int i = 0; i < titles.length; i++){
            ListItem current = new ListItem(titles[i]);
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }
}
