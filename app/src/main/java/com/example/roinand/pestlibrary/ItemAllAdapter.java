package com.example.roinand.pestlibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by User on 7/23/2016.
 */
public class ItemAllAdapter extends RecyclerView.Adapter<ItemAllAdapter.AllItemViewHolder> {
    List<ItemAll> data = Collections.emptyList();
    private LayoutInflater inflater;
    private int type;

    private ClickListener clickListener;

    public ItemAllAdapter (Context context, List<ItemAll> data, int type) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.type = type;
    }

    public void setClickListener (ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public AllItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_all, parent, false);
        AllItemViewHolder holder = new AllItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AllItemViewHolder holder, int position) {
        ItemAll current = data.get(position);
        holder.screenshot.setImageResource(current.imageId);
        if (type == 1) holder.name.setText(current.pestName);
        else if (type == 2) holder.name.setText(current.diseaseName);
        holder.commonNames.setText(current.commonNames);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class AllItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView screenshot;
        TextView name;
        TextView commonNames;

        public AllItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            screenshot = (ImageView) itemView.findViewById(R.id.item_all_image);
            name = (TextView) itemView.findViewById(R.id.item_all_name);
            commonNames = (TextView) itemView.findViewById(R.id.item_all_commonnames);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClick(v, name.getText().toString());
            }
        }
    }

    public interface ClickListener {
        public void itemClick (View view, String name);
    }
}
