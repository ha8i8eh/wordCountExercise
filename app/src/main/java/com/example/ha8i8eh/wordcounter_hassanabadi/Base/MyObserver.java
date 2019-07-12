package com.example.ha8i8eh.wordcounter_hassanabadi.Base;

import com.example.ha8i8eh.wordcounter_hassanabadi.Exception.ExceptionMessageFactory;
import com.example.ha8i8eh.wordcounter_hassanabadi.Exception.MyException;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class MyObserver<T> implements Observer<T> {

    private CompositeDisposable compositeDisposable;

    public MyObserver(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onError(Throwable e) {
        EventBus.getDefault().post(new MyException(ExceptionMessageFactory.getMessage(e)));
    }
}
