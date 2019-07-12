package com.example.ha8i8eh.wordcounter_hassanabadi.Result.ResultFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ha8i8eh.wordcounter_hassanabadi.Base.BaseFragment;
import com.example.ha8i8eh.wordcounter_hassanabadi.Base.MyObserver;
import com.example.ha8i8eh.wordcounter_hassanabadi.Base.MySingleObserver;
import com.example.ha8i8eh.wordcounter_hassanabadi.Data.Text;
import com.example.ha8i8eh.wordcounter_hassanabadi.Data.TextManipulation;
import com.example.ha8i8eh.wordcounter_hassanabadi.R;
import com.example.ha8i8eh.wordcounter_hassanabadi.Result.adapters.AllTenthCharAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AllTenthCharFragment extends BaseFragment {


    private char[] allTenthChar;
    private LottieAnimationView progressBar;
    private RecyclerView recyclerView;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_tenth_char_fragment, container, false);
        recyclerView = view.findViewById(R.id.allTenthFragment_rv);
        progressBar = view.findViewById(R.id.allTenthFragment_lottie_pb);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resultViewModel.getProgressBarSubject()
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Boolean>(compositeDisposable) {
                    @Override
                    public void onNext(Boolean mustShow) {

                        progressBar.setVisibility(mustShow ? View.VISIBLE : View.GONE);
                    }


                    @Override
                    public void onComplete() {

                    }
                });
        resultViewModel.AllTenthChar()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySingleObserver<Text>(compositeDisposable) {

                    @Override
                    public void onSuccess(Text text) {
                        allTenthChar = resultViewModel.AllTenthCharRet(text);
                        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),5,LinearLayoutManager.VERTICAL,false));
                        AllTenthCharAdapter allTenthCharAdapter = new AllTenthCharAdapter();
                        allTenthCharAdapter.setAllTenth(allTenthChar);
                        recyclerView.setAdapter(allTenthCharAdapter);

                    }
                });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    public static AllTenthCharFragment newInstance() {

        AllTenthCharFragment fragment = new AllTenthCharFragment();
        return fragment;
    }
}
