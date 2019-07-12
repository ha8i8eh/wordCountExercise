package com.example.ha8i8eh.wordcounter_hassanabadi.Result;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ha8i8eh.wordcounter_hassanabadi.Data.Text;
import com.example.ha8i8eh.wordcounter_hassanabadi.Data.TextManipulation;
import com.example.ha8i8eh.wordcounter_hassanabadi.R;
import com.example.ha8i8eh.wordcounter_hassanabadi.Result.ResultFragments.AllTenthCharFragment;
import com.example.ha8i8eh.wordcounter_hassanabadi.Result.ResultFragments.TenthCharFragment;
import com.example.ha8i8eh.wordcounter_hassanabadi.Result.ResultFragments.WordCountFragment;
import com.example.ha8i8eh.wordcounter_hassanabadi.Result.adapters.WordCountAdapter;

public class ResultViewPager extends FragmentPagerAdapter {
        private Context context;
    public ResultViewPager(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AllTenthCharFragment.newInstance();
            case 1:
                return TenthCharFragment.newInstance();
            case 2:
                return WordCountFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.all_tenth_char_header);
            case 1:
                return context.getString(R.string.first_tenth_char_header);
            case 2:
                return context.getString(R.string.word_count_header);

        }
        return null;
    }
}
