package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.farmersmarket.john.sokoni.R;

import java.util.Collections;
import java.util.List;

import other.ListItem;

/**
 * Created by John on 5/6/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder>{


    List<ListItem> data = Collections.EMPTY_LIST;
    private LayoutInflater inflater;

    public ListAdapter(Context context, List<ListItem> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyViewHolder holder, int position) {

        ListItem current = data.get(position);
        holder.textView.setText(current.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.list_title);
        }
    }
}



