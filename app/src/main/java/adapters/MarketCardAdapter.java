package adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.farmersmarket.john.sokoni.R;

import java.util.List;

import other.Ads;

/**
 * Created by John on 4/30/2017.
 */

public class MarketCardAdapter extends RecyclerView.Adapter<MarketCardAdapter.MarketViewHolder> {

    public static class MarketViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView headingView;
        TextView priceView;
        TextView locationView;
        TextView timeView;
        ImageView adPhoto;

        MarketViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.market_card);
            headingView = (TextView)itemView.findViewById(R.id.heading_market);
            priceView = (TextView)itemView.findViewById(R.id.price);
            locationView = (TextView)itemView.findViewById(R.id.location);
            timeView = (TextView)itemView.findViewById(R.id.time);
            adPhoto = (ImageView)itemView.findViewById(R.id.markert_photo);
        }
    }

    private List<Ads> adsList;

    public MarketCardAdapter(List<Ads> adsList){
        this.adsList = adsList;
    }


    @Override
    public MarketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.market_card, parent, false);
        MarketViewHolder pvh = new MarketViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(MarketViewHolder holder, int position) {
        holder.headingView.setText(adsList.get(position).heading);
        holder.priceView.setText(adsList.get(position).price);
        holder.locationView.setText(adsList.get(position).location);
        holder.timeView.setText(adsList.get(position).time);
        holder.adPhoto.setImageResource(adsList.get(position).adPhoto);
    }

    @Override
    public int getItemCount() {
        return adsList.size();
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
