package com.example.ha8i8eh.wordcounter_hassanabadi.Result.ResultFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.example.ha8i8eh.wordcounter_hassanabadi.R;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TenthCharFragment extends BaseFragment {

    private char tenth;
    private TextView tenthChar_tv;

    private LottieAnimationView progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tenth_char_fragment, container, false);
        tenthChar_tv = view.findViewById(R.id.result_tv_tenthChar);

        progressBar = view.findViewById(R.id.Tenth_Fragment_lottie_pb);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resultViewModel.getProgressBarSubject()
                .subscribeOn(Schedulers.newThread())
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

        resultViewModel.tenthChar()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySingleObserver<Text>(compositeDisposable) {
                    @Override
                    public void onSuccess(Text text) {
                        tenth = resultViewModel.tenthCharRet(text);
                        tenthChar_tv.setText(Character.toString(tenth));


                    }
                });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);



    }

    @Override
    public void onStart() {
        super.onStart();

    }

    public static TenthCharFragment newInstance() {

        TenthCharFragment fragment = new TenthCharFragment();
        return fragment;
    }


}
