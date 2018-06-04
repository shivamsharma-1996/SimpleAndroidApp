package com.developer.techies.retrofittutorial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer.techies.retrofittutorial.R;
import com.developer.techies.retrofittutorial.adapter.holder.ResponseHolder;
import com.developer.techies.retrofittutorial.model.Item;
import com.developer.techies.retrofittutorial.utils.ItemListener;

import java.util.List;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseHolder>{

    private List<Item> items;
    private Context mContext;
    private ItemListener<Item> listener;

    public ResponseAdapter(Context context, List<Item> items, ItemListener<Item> listener){

        this.items = items;
        this.mContext = context;
        this.listener = listener;
    }

    public void updateAnswers(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResponseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_answers, parent, false);
        return new ResponseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseHolder holder, int position) {

        Item item = items.get(position);
        holder.titleTv.setText(item.getOwner().getDisplayName());
    }

    @Override
    public int getItemCount() {
        return this.items != null ? items.size() : 0;
    }

}
