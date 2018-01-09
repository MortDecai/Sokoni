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

import other.News;

/**
 * Created by John on 4/29/2017.
 */

public class NewsCardAdapter extends RecyclerView.Adapter<NewsCardAdapter.HomeViewHolder> {

        public static class HomeViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView headingView;
        TextView bodyView;
        TextView authorView;
        TextView dateView;
        ImageView newsPhoto;

       HomeViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.homecard);
            headingView = (TextView)itemView.findViewById(R.id.heading);
            bodyView = (TextView)itemView.findViewById(R.id.body);
            authorView = (TextView)itemView.findViewById(R.id.author);
            dateView = (TextView)itemView.findViewById(R.id.date);
            newsPhoto = (ImageView)itemView.findViewById(R.id.news);
        }

    }

    List<News> newsList;

    public NewsCardAdapter(List<News> newsList){
        this.newsList = newsList;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card, parent, false);
        HomeViewHolder pvh = new HomeViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.headingView.setText(newsList.get(position).heading);
        holder.bodyView.setText(newsList.get(position).body);
        holder.authorView.setText(newsList.get(position).author);
        holder.dateView.setText(newsList.get(position).date);
        holder.newsPhoto.setImageResource(newsList.get(position).newsPhoto);

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
