package com.example.ha8i8eh.wordcounter_hassanabadi.Base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ha8i8eh.wordcounter_hassanabadi.Exception.MyException;
import com.example.ha8i8eh.wordcounter_hassanabadi.Result.ResultViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class BaseFragment extends Fragment {
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    public ResultViewModel resultViewModel = new ResultViewModel();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        compositeDisposable.clear();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMyException(MyException myException){
        Toast.makeText(getActivity(), myException.message,Toast.LENGTH_SHORT).show();
    }
}
