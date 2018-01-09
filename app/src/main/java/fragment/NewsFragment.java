package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.farmersmarket.john.sokoni.R;
import com.farmersmarket.john.sokoni.activities.NewsDestinationActivity;

import java.util.ArrayList;
import java.util.List;

import adapters.NewsCardAdapter;
import other.News;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private List<News> newsDatas;
    private RecyclerView rv;
    private News news;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        initializeData();

        NewsCardAdapter adapter = new NewsCardAdapter(newsDatas);
        rv.setAdapter(adapter);


        rv.addOnItemTouchListener(new MarketFragment.RecyclerTouchListener(getActivity(), rv, new MarketFragment.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                news = newsDatas.get(position);

                Intent intent = new Intent(getActivity(),NewsDestinationActivity.class);
                //based on item add info to intent
                intent.putExtra("news",news);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(), "onLongClick"+position, Toast.LENGTH_SHORT).show();
            }
        }));

        return v;
    }

    private void initializeData(){
        newsDatas = new ArrayList<>();
        newsDatas.add(new News("Kilimo mkombozi wa mtanzania", "Kilimo kinavozidi kumkomboa mkulima wa leo ...","Yohana Tubike",
                "30 min ago",R.drawable.field_agriculture_ukraine));
        newsDatas.add(new News("Athari za mimea", "Mimea isipofyekya kuzunguka mashamba ...",
                "Yohana Tubike", "35 min ago", R.drawable.istocklarge));
        newsDatas.add(new News("Watafiti kutoka sua", "Tazama ugunduzi muhimu uliofanyika chuo cha ...",
                "Yohana Tubike","50 min ago", R.drawable.farms_landing_page));
        newsDatas.add(new News("Kilimo mkombozi wa mtanzania", "Kilimo kinavozidi kumkomboa mkulima wa leo ...","Yohana Tubike",
                "60 min ago",R.drawable.field_agriculture_ukraine));
        newsDatas.add(new News("Watafiti kutoka sua", "Tazama ugunduzi muhimu uliofanyika chuo cha ...",
                "Yohana Tubike","60 min ago", R.drawable.farms_landing_page));
        newsDatas.add(new News("Kilimo mkombozi wa mtanzania", "Kilimo kinavozidi kumkomboa mkulima wa leo ...","Yohana Tubike",
                "60 min ago",R.drawable.field_agriculture_ukraine));
        newsDatas.add(new News("Athari za mimea", "Mimea isipofyekya kuzunguka mashamba ...",
                "Yohana Tubike", "60 min ago", R.drawable.istocklarge));
        newsDatas.add(new News("Watafiti kutoka sua", "Tazama ugunduzi muhimu uliofanyika chuo cha ...",
                "Yohana Tubike","60 min ago", R.drawable.farms_landing_page));
        newsDatas.add(new News("Kilimo mkombozi wa mtanzania", "Kilimo kinavozidi kumkomboa mkulima wa leo ...","Yohana Tubike",
                "60 min ago",R.drawable.field_agriculture_ukraine));
        newsDatas.add(new News("Watafiti kutoka sua", "Tazama ugunduzi muhimu uliofanyika chuo cha ...",
                "Yohana Tubike","60 min ago", R.drawable.farms_landing_page));
    }

}
