package com.example.ha8i8eh.wordcounter_hassanabadi.Result.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ha8i8eh.wordcounter_hassanabadi.R;

public class WordCountAdapter extends RecyclerView.Adapter<WordCountAdapter.WordCountViewHolder> {

    private String[] wordCounts;

    public void setWordCounts(String[] wordCounts) {
        this.wordCounts = wordCounts;
    }

    @NonNull
    @Override
    public WordCountViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new WordCountViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.word_count_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordCountViewHolder wordCountViewHolder, int i) {
            wordCountViewHolder.wordCountBind(wordCounts[i]);
    }

    @Override
    public int getItemCount() {
        return wordCounts.length;
    }

    public class WordCountViewHolder extends RecyclerView.ViewHolder{

        private TextView word;
        private TextView count;

        public WordCountViewHolder(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.itemWordCount_tv_word);
            count = itemView.findViewById(R.id.itemWordCount_tv_count);
        }
        public void wordCountBind(String wordCount){

            String[] WC = wordCount.split(":");
            word.setText(WC[0]);
            count.setText(WC[1]);


        }
    }
}
