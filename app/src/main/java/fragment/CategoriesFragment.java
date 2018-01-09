package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.farmersmarket.john.sokoni.R;

import java.util.ArrayList;

import adapters.ExpandableListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {


    public CategoriesFragment() {
        // Required empty public constructor
    }

    ArrayList<String> groupItem = new ArrayList<String>();
    ArrayList<Object> childItem = new ArrayList<Object>();

    ExpandableListAdapter mExpandableListAdapter;
    ExpandableListView expandableListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        setGroupData();
        setChildGroupData();

        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expandableListView = (ExpandableListView) getView().findViewById(R.id.explistView);
        mExpandableListAdapter = new ExpandableListAdapter(groupItem,childItem, getContext());
        expandableListView.setAdapter(mExpandableListAdapter);

        expandableListView.setDividerHeight(3);
        expandableListView.setGroupIndicator(null);
        expandableListView.setClickable(true);

    }


    public void setGroupData() {
        groupItem.add("Food Crops");
        groupItem.add("Cash Crops");
        groupItem.add("Equipments");
        groupItem.add("Livestock");
        groupItem.add("Real Estates");
    }
    public void setChildGroupData() {
        /**
         * Add Data For Food Crops
         */
        ArrayList<String> child = new ArrayList<String>();
        child.add("Rice");
        child.add("Potatoes");
        child.add("Maize");
        child.add("Beans");
        childItem.add(child);

        /**
         * Add Data For Cash Crops
         */
        child = new ArrayList<String>();
        child.add("cacao");
        child.add("Cotton");
        child.add("Tobaco");
        childItem.add(child);
        /**
         * Add Data For Equipments
         */
        child = new ArrayList<String>();
        child.add("Tractor");
        child.add("Trailer");
        childItem.add(child);

        ;
        /**
         * Add Data For Livestock
         */
        child = new ArrayList<String>();
        child.add("Cattle");
        child.add("Donkey");
        child.add("Goat");
        child.add("Sheep");
        childItem.add(child);
        /**
         * Add Data For Real Estates
         */
        child = new ArrayList<String>();
        child.add("Plantations");
        child.add("Farms");
        child.add("Bushes");
        childItem.add(child);
    }

}
