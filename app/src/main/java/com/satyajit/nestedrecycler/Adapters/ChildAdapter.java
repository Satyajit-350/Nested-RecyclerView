package com.satyajit.nestedrecycler.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.satyajit.nestedrecycler.R;
import com.satyajit.nestedrecycler.model.ChildRecyclerViewItem;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    ArrayList<ChildRecyclerViewItem> childArrayList;

    public ChildAdapter(ArrayList<ChildRecyclerViewItem> childArrayList) {
        this.childArrayList = childArrayList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_list_items,parent,false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {

        ChildRecyclerViewItem childRecyclerViewItem = childArrayList.get(position);

        holder.imageView.setImageResource(childRecyclerViewItem.getImageItems());

    }

    @Override
    public int getItemCount() {
        return childArrayList.size();
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view_item);
        }
    }
}
