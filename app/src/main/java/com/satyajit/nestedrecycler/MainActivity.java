package com.satyajit.nestedrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.satyajit.nestedrecycler.Adapters.ChildAdapter;
import com.satyajit.nestedrecycler.Adapters.ParentAdapter;
import com.satyajit.nestedrecycler.model.ChildRecyclerViewItem;
import com.satyajit.nestedrecycler.model.ParentRecyclerViewItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ParentAdapter parentAdapter;

    ArrayList<ParentRecyclerViewItem> parentList;
    ArrayList<ChildRecyclerViewItem> childArraylist;

    private RecyclerView parentRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        parentRecyclerView = findViewById(R.id.Recycler_view_parent);
        parentRecyclerView.setHasFixedSize(true);
        parentRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        parentList = new ArrayList<>();
        childArraylist = new ArrayList<>();

        parentAdapter = new ParentAdapter(this,parentList,childArraylist);

        parentRecyclerView.setAdapter(parentAdapter);


        String arr[] = new String[]{"Trending","Sc-fi","Horror","Action","Adventure","Animation"};
        int imgArr[] = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
                R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,
                R.drawable.img10,R.drawable.img11,R.drawable.img12};

        getData(arr,imgArr);
        parentAdapter.notifyDataSetChanged();
    }

    private void getData(String[] arr, int[] imgArr) {

        for(int i = 0;i<arr.length;i++){
            parentList.add(new ParentRecyclerViewItem(arr[i]));
            if(i<imgArr.length) {
                childArraylist.add(new ChildRecyclerViewItem(imgArr[i]));
            }
        }
    }
}