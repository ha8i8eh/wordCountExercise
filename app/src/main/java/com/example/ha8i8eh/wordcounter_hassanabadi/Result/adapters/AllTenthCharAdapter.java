package com.example.ha8i8eh.wordcounter_hassanabadi.Result.adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ha8i8eh.wordcounter_hassanabadi.R;

import java.util.Random;

public class AllTenthCharAdapter  extends RecyclerView.Adapter<AllTenthCharAdapter.AllTenthCharViewHolder>{

    private char[] AllTenth;

    public void setAllTenth(char[] allTenth) {
        AllTenth = allTenth;
    }

    @NonNull
    @Override
    public AllTenthCharViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AllTenthCharViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.all_tenth_char_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AllTenthCharViewHolder allTenthCharViewHolder, int i) {
        allTenthCharViewHolder.BindChar(AllTenth[i],i+1);
    }

    @Override
    public int getItemCount() {
        return AllTenth.length;
    }

    public class AllTenthCharViewHolder extends RecyclerView.ViewHolder{

        private TextView tenthChar_tv;
        private TextView tenthCharNum_tv;

        public AllTenthCharViewHolder(@NonNull View itemView) {
            super(itemView);
            tenthChar_tv = itemView.findViewById(R.id.item_tv_allTenth);
            tenthCharNum_tv = itemView.findViewById(R.id.item_tv_allTenthNum);
        }
        public void BindChar(char tenthChar, int i){
            if (tenthChar != ' ' ) {
                tenthChar_tv.setText(tenthChar + "");
            }
            else{
                tenthChar_tv.setText("ws");
            }
            tenthCharNum_tv.setText(Integer.toString(i));


        }
    }
}
