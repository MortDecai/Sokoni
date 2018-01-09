package fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.farmersmarket.john.sokoni.R;
import com.farmersmarket.john.sokoni.activities.PostAdActivity;
import com.farmersmarket.john.sokoni.activities.MarketDestinationActivity;

import java.util.ArrayList;
import java.util.List;

import adapters.MarketCardAdapter;
import other.Ads;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarketFragment extends Fragment {

    private List<Ads> adsList;
    private RecyclerView recyclerView;
    private Context context;
    private Ads ads;
    MarketCardAdapter adapter = new MarketCardAdapter(adsList);
    private FloatingActionButton fab;

    public MarketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_market, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PostAdActivity.class));
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        initializeData();
        MarketCardAdapter adapter = new MarketCardAdapter(adsList);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ads = adsList.get(position);

                Intent intent = new Intent(getActivity(),MarketDestinationActivity.class);
                //based on item add info to intent
                intent.putExtra("ads", ads);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(), "onLongClick"+position, Toast.LENGTH_SHORT).show();
            }
        }));

        return v;
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private GestureDetector gestureDetector;

        private ClickListener clickListener;
        public String TAG = "YOHANA";

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener){
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());

                    if (childView != null && clickListener != null){
                        clickListener.onClick(childView, recyclerView.getChildAdapterPosition(childView));
                    }
                    return super.onSingleTapUp(e);
                }

                @Override
                public void onLongPress(MotionEvent e) {
                   View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());

                    if (childView != null && clickListener != null){
                        clickListener.onLongClick(childView, recyclerView.getChildAdapterPosition(childView));
                    }
                    super.onLongPress(e);
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View childView = rv.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && clickListener != null && gestureDetector.onTouchEvent(e)){
                clickListener.onClick(childView, rv.getChildAdapterPosition(childView));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            Log.d(TAG, "onTouchEvent: "+gestureDetector.onTouchEvent(e) +" " + e);

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    public static interface ClickListener{
        public void onClick(View view, int position);
        public void onLongClick(View view, int position);
    }

    private void initializeData() {
        adsList = new ArrayList<>();
        adsList.add(new Ads("Shamba linauzwa", "4,500,000 TZS", "Mkuranga",
                "3hrs ago", R.drawable.ic_farm));
        adsList.add(new Ads("Mahindi yanauzwa", "60,000 TZS", "Iringa",
                "4hrs ago", R.drawable.ic_dried_maize));
        adsList.add(new Ads("Dried Spinach for sale", "6,000 TZS", "Dar es salaam",
                "4hrs ago", R.drawable.ic_baby_spinach));
        adsList.add(new Ads("Tumbaku iliyokaushwa", "5,000,000 TZS", "Tabora",
                "4hrs ago", R.drawable.ic_pipe_tobacco_7pic1));
        adsList.add(new Ads("Mahindi yanauzwa", "60,000 TZS", "Iringa",
                "4hrs ago", R.drawable.ic_dried_maize));
        adsList.add(new Ads("Dried Spinach for sale", "6,000 TZS", "Dar es salaam",
                "4hrs ago", R.drawable.ic_baby_spinach));
        adsList.add(new Ads("Shamba linauzwa", "4,500,000 TZS", "Mkuranga",
                "3hrs ago", R.drawable.ic_farm));
        adsList.add(new Ads("Mahindi yanauzwa", "60,000 TZS", "Iringa",
                "4hrs ago", R.drawable.ic_dried_maize));
        adsList.add(new Ads("Dried Spinach for sale", "6,000 TZS", "Dar es salaam",
                "4hrs ago", R.drawable.ic_baby_spinach));
        adsList.add(new Ads("Tumbaku iliyokaushwa", "5,000,000 TZS", "Tabora",
                "4hrs ago", R.drawable.ic_pipe_tobacco_7pic1));
        adsList.add(new Ads("Mahindi yanauzwa", "60,000 TZS", "Iringa",
                "4hrs ago", R.drawable.ic_dried_maize));
        adsList.add(new Ads("Dried Spinach for sale", "6,000 TZS", "Dar es salaam",
                "4hrs ago", R.drawable.ic_baby_spinach));
    }

}
