package com.example.ha8i8eh.wordcounter_hassanabadi.Main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ha8i8eh.wordcounter_hassanabadi.R;
import com.example.ha8i8eh.wordcounter_hassanabadi.Result.ResultViewPager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.main_tabLayout);

        final Button startBtn = findViewById(R.id.main_btn_start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ViewPager viewPager = findViewById(R.id.main_vp);
                viewPager.setAdapter(new ResultViewPager(getSupportFragmentManager(),MainActivity.this));
                startBtn.setVisibility(View.GONE);
                tabLayout.setupWithViewPager(viewPager);
                viewPager.setCurrentItem(1);


            }
        });
    }

}

