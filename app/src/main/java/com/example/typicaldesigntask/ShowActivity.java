package com.example.typicaldesigntask;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.typicaldesigntask.Adapter.ShowListRecyclerViewAdapter;
import com.example.typicaldesigntask.Base.BaseActivity;
import com.example.typicaldesigntask.FireBaseUtils.MyDataBase;
import com.example.typicaldesigntask.Model.Data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends BaseActivity {
    RecyclerView userRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    ShowListRecyclerViewAdapter adapter;
    List<Data> dataList;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userRecyclerView = findViewById(R.id.userInfo_view);
        adapter = new ShowListRecyclerViewAdapter(null);
        layoutManager = new LinearLayoutManager(activity);
        userRecyclerView.setAdapter(adapter);
        userRecyclerView.setLayoutManager(layoutManager);
        MyDataBase.getUsersBranch().addValueEventListener(usersValueEventListener);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowActivity.this , InsertActivity.class);
                startActivity(intent);
            }
        });


    }

    ValueEventListener usersValueEventListener= new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            dataList =new ArrayList<>();
            for(DataSnapshot itemData :dataSnapshot.getChildren()){
                data =  itemData.getValue(Data.class);
                dataList.add(data);

            }
            adapter.changeData(dataList);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            showMessage(getString(R.string.fail),databaseError.getMessage());
        }
    };

}
