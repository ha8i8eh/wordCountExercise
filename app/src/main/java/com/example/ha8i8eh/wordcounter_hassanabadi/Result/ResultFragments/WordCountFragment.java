package com.example.ha8i8eh.wordcounter_hassanabadi.Result.ResultFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.example.ha8i8eh.wordcounter_hassanabadi.Result.ResultViewModel;
import com.example.ha8i8eh.wordcounter_hassanabadi.Result.adapters.AllTenthCharAdapter;
import com.example.ha8i8eh.wordcounter_hassanabadi.Result.adapters.WordCountAdapter;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class WordCountFragment extends BaseFragment {

    private HashMap<String, Integer> wordCounts;
    private RecyclerView recyclerView;
    private LottieAnimationView progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_count_fragment, container, false);
        recyclerView = view.findViewById(R.id.countFragment_rv);
        progressBar = view.findViewById(R.id.countFragment_lottie_pb);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

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
        resultViewModel.wordCounter()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySingleObserver<Text>(compositeDisposable) {
                    @Override
                    public void onSuccess(Text text) {
                        wordCounts = resultViewModel.WordsCount(text);
                        String[] result = TextManipulation.PrintWordCount(wordCounts);
                        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));
                        WordCountAdapter wordCountAdapter = new WordCountAdapter();
                        wordCountAdapter.setWordCounts(result);
                        recyclerView.setAdapter(wordCountAdapter);
                    }
                });

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    public static WordCountFragment newInstance() {

        WordCountFragment fragment = new WordCountFragment();
        return fragment;
    }
}
