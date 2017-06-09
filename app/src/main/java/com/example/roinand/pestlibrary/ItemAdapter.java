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
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    List<Item> data = Collections.emptyList();
    private int type;
    private LayoutInflater inflater;

    private ClickListener clickListenerRice;
    private ClickListener clickListenerCorn;
    private ClickListener clickListenerBanana;
    private ClickListener clickListenerCacao;
    private ClickListener clickListenerCoffee;
    private ClickListener clickListenerCoco;

    public ItemAdapter (Context context, List<Item> data, int type) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.type = type;
    }

    public void setClickListenerRice (ClickListener clickListenerRice) {
        this.clickListenerRice = clickListenerRice;
    }

    public void setClickListenerCorn (ClickListener clickListenerCorn) {
        this.clickListenerCorn = clickListenerCorn;
    }

    public void setClickListenerBanana (ClickListener clickListenerBanana) {
        this.clickListenerBanana = clickListenerBanana;
    }

    public void setClickListenerCacao (ClickListener clickListenerCacao) {
        this.clickListenerCacao = clickListenerCacao;
    }

    public void setClickListenerCoffee (ClickListener clickListenerCoffee) {
        this.clickListenerCoffee = clickListenerCoffee;
    }

    public void setClickListenerCoco (ClickListener clickListenerCoco) {
        this.clickListenerCoco = clickListenerCoco;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item current = data.get(position);
        if (type == 1) holder.name.setText(current.pestName);
        else if (type == 2) holder.name.setText(current.diseaseName);
        holder.screenshot.setImageResource(current.imageId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView screenshot;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.item_name);
            screenshot = (ImageView) itemView.findViewById(R.id.item_screenshot);
        }

        @Override
        public void onClick(View v) {
            if (clickListenerRice != null) {
                clickListenerRice.itemClickRice(v, name.getText().toString());
            }

            if (clickListenerCorn != null) {
                clickListenerCorn.itemClickCorn(v, name.getText().toString());
            }

            if (clickListenerBanana != null) {
                clickListenerBanana.itemClickBanana(v, name.getText().toString());
            }

            if (clickListenerCacao != null) {
                clickListenerCacao.itemClickCacao(v, name.getText().toString());
            }

            if (clickListenerCoffee != null) {
                clickListenerCoffee.itemClickCoffee(v, name.getText().toString());
            }

            if (clickListenerCoco != null) {
                clickListenerCoco.itemClickCoco(v, name.getText().toString());
            }
        }
    }

    public interface ClickListener {
        public void itemClickRice (View view, String name);
        public void itemClickCorn (View view, String name);
        public void itemClickBanana (View view, String name);
        public void itemClickCacao (View view, String name);
        public void itemClickCoffee (View view, String name);
        public void itemClickCoco (View view, String name);
    }
}
