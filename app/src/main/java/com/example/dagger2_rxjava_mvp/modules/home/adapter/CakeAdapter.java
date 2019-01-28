package com.example.dagger2_rxjava_mvp.modules.home.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dagger2_rxjava_mvp.R;
import com.example.dagger2_rxjava_mvp.mvp.model.Cake;

import java.util.ArrayList;
import java.util.List;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Cake> mcakeList=new ArrayList<>();

    public CakeAdapter(LayoutInflater inflater) {
        mLayoutInflater = inflater;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= mLayoutInflater.inflate(R.layout.list_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( CakeAdapter.ViewHolder viewHolder, int i) {
     viewHolder.bind(mcakeList.get(i));
    }

    @Override
    public int getItemCount() {
        return mcakeList.size();
    }

    public void addCakes(List<Cake> cakes){
        mcakeList.addAll(cakes);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView){
            super(itemView);
        }

        public void bind(Cake cake) {
        }
    }
}
