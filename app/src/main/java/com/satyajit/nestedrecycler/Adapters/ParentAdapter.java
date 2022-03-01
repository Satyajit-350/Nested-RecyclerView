package com.satyajit.nestedrecycler.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.satyajit.nestedrecycler.DetailActivity;
import com.satyajit.nestedrecycler.R;
import com.satyajit.nestedrecycler.model.ChildRecyclerViewItem;
import com.satyajit.nestedrecycler.model.ParentRecyclerViewItem;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {

    Context context;
    ArrayList<ParentRecyclerViewItem> parentArrayList;
    ArrayList<ChildRecyclerViewItem> childList;

    public ParentAdapter(Context context, ArrayList<ParentRecyclerViewItem> parentArrayList, ArrayList<ChildRecyclerViewItem> childList) {
        this.context = context;
        this.parentArrayList = parentArrayList;
        this.childList = childList;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_list_items,parent,false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {

        ParentRecyclerViewItem parentRecyclerViewItem = parentArrayList.get(position);

        holder.title.setText(parentRecyclerViewItem.getTitleName());

        ChildAdapter childAdapter = new ChildAdapter(childList);
        holder.childRecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.childRecyclerView.setAdapter(childAdapter);

        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return parentArrayList.size();
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView more;
        private RecyclerView childRecyclerView;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_name);
            more = itemView.findViewById(R.id.more_text_view);
            childRecyclerView = itemView.findViewById(R.id.child_recycler_view);
        }
    }
}
