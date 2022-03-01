package com.satyajit.nestedrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.satyajit.nestedrecycler.Adapters.ChildAdapter;
import com.satyajit.nestedrecycler.model.ChildRecyclerViewItem;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ChildAdapter childAdapter;
    ArrayList<ChildRecyclerViewItem> arrayList;

    private RecyclerView detailRecyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai);

        toolbar = findViewById(R.id.custom_toolbar);

        setSupportActionBar(toolbar);

        detailRecyclerView = findViewById(R.id.detail_rv);

        detailRecyclerView.setHasFixedSize(true);

        arrayList = new ArrayList<>();
        childAdapter = new ChildAdapter(this,arrayList);

        detailRecyclerView.setAdapter(childAdapter);

        int arr[] = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
                R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,
                R.drawable.img10,R.drawable.img11,R.drawable.img12,R.drawable.img1,R.drawable.img2,
                R.drawable.img3,R.drawable.img4,
                R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,
                R.drawable.img10,R.drawable.img11,R.drawable.img12};
        getData(arr);

        childAdapter.notifyDataSetChanged();

    }

    private void getData(int[] arr) {

        for(int i = 0;i<arr.length;i++){
            arrayList.add(new ChildRecyclerViewItem(arr[i]));
        }

    }
}