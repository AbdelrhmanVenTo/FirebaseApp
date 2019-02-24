package com.example.typicaldesigntask.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.typicaldesigntask.Model.Data;
import com.example.typicaldesigntask.R;

import java.util.List;

public class ShowListRecyclerViewAdapter extends RecyclerView.Adapter<ShowListRecyclerViewAdapter.ViewHolder> {
    List<Data> dataList;

    public ShowListRecyclerViewAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_info , viewGroup , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        Data data = dataList.get(pos);
        viewHolder.userName.setText(data.getUserName());
        viewHolder.eMail.setText(data.getEmail());
        viewHolder.phone.setText(String.valueOf(data.getPhone()));
    }

    @Override
    public int getItemCount() {
        if(dataList==null)return 0;
        return dataList.size();
    }

    public void  changeData(List<Data> data) {
        this.dataList = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName , eMail , phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.getName);
            eMail = itemView.findViewById(R.id.getEmail);
            phone = itemView.findViewById(R.id.getPhone);

        }
    }
}
