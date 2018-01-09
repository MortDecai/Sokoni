package adapters;

/**
 * Created by John on 4/29/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.farmersmarket.john.sokoni.R;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private ArrayList<String> groupItem, tempChild;
    private ArrayList<Object> Childtem = new ArrayList<Object>();
    private Context context;


    public ExpandableListAdapter(ArrayList<String> grList, ArrayList<Object> childItem, Context context) {
        this.groupItem = grList;
        this.Childtem = childItem;
        this.context = context;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        // TODO Auto-generated method stub
        TextView text = null;
        tempChild = (ArrayList<String>) Childtem.get(groupPosition);

        if(convertView==null){
            LayoutInflater childInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = childInflater.inflate(R.layout.child_row, null);
        }
        text = (TextView)convertView.findViewById(R.id.childTextView);
        text.setText(tempChild.get(childPosition));
        return convertView;

        /*
        tempChild = (ArrayList<String>) Childtem.get(groupPosition);
        TextView text = null;
        if (convertView == null) {
            convertView = minflater.inflate(R.layout.child_row, null);
        }
        text = (TextView) convertView.findViewById(R.id.textView1);
        text.setText(tempChild.get(childPosition));
        convertView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, tempChild.get(childPosition),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return convertView; */
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ((ArrayList<String>) Childtem.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return groupItem.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        TextView text = null;
        tempChild = (ArrayList<String>) Childtem.get(groupPosition);

        if(convertView==null){
            LayoutInflater groupinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = groupinflater.inflate(R.layout.group_row, null);
        }

        ((CheckedTextView) convertView).setText(groupItem.get(groupPosition));
        ((CheckedTextView) convertView).setChecked(isExpanded);
        return convertView;


       /* if (convertView == null) {
            convertView = minflater.inflate(R.layout.group_row, parent);
        }
        ((CheckedTextView) convertView).setText(groupItem.get(groupPosition));
        ((CheckedTextView) convertView).setChecked(isExpanded);
        return convertView; */
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}

