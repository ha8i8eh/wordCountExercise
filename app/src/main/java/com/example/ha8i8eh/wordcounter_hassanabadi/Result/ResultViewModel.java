package com.example.ha8i8eh.wordcounter_hassanabadi.Result;

import com.example.ha8i8eh.wordcounter_hassanabadi.Data.ApiService;
import com.example.ha8i8eh.wordcounter_hassanabadi.Data.ApiServiceInjector;
import com.example.ha8i8eh.wordcounter_hassanabadi.Data.Text;
import com.example.ha8i8eh.wordcounter_hassanabadi.Data.TextManipulation;

import java.util.HashMap;

import io.reactivex.Single;
import io.reactivex.subjects.BehaviorSubject;

public class ResultViewModel {
    protected ApiService apiService = ApiServiceInjector.getInstance();
    protected BehaviorSubject<Boolean> progressBarSubject = BehaviorSubject.create();

    public BehaviorSubject<Boolean> getProgressBarSubject() {
        return progressBarSubject;
    }

    public Single<Text> tenthChar() {
        progressBarSubject.onNext(true);
        return apiService.tenthChar()
                .doOnEvent((text, throwable) -> progressBarSubject.onNext(false));


    }

    public Single<Text> AllTenthChar() {
        progressBarSubject.onNext(true);
        return apiService.AllTenthChar()
                .doOnEvent((text, throwable) -> progressBarSubject.onNext(false));
    }

    public Single<Text> wordCounter() {
       progressBarSubject.onNext(true);
        return apiService.wordCounter()
                .doOnEvent((text, throwable) -> progressBarSubject.onNext(false));
    }

    public char tenthCharRet(Text text) {
        return TextManipulation.TenthChar(text);
    }

    public char[] AllTenthCharRet(Text text) {
        return TextManipulation.AllTenthChar(text);
    }

    public HashMap<String, Integer> WordsCount(Text text) {
        return TextManipulation.WordsCount(text);
    }
}
