package com.dbuzin.warehouseorder.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.dbuzin.warehouseorder.components.App;
import com.dbuzin.warehouseorder.dao.ElementsDao;
import com.dbuzin.warehouseorder.enteties.Elements;
import com.dbuzin.warehouseorder.views.ActivityElementsView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ActivityElementsPresenter extends MvpPresenter<ActivityElementsView> {
    @Inject
    ElementsDao elementsDao;

    public ActivityElementsPresenter(){
        App.getAppComponent().inject(this);//calling the dagger's injector to inject dependency.
    }

    public void addElement(Elements element){
        elementsDao = App.getAppComponent().elementsDao();
        elementsDao.insert(element).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableMaybeObserver<Long>() {
                    @Override
                    public void onSuccess(@NonNull Long aLong) {
                        Log.d("Added", String.valueOf(aLong));
                        getViewState().onAdding();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getViewState().onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void loadData(){
        elementsDao.getAll().observeOn(AndroidSchedulers.mainThread())
                .subscribe(elements -> getViewState().loadData(elements));
    }
    public void deleteElement(Elements element) {
        elementsDao = App.getAppComponent().elementsDao();
        elementsDao.delete(element)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Integer>() {
                    @Override
                    public void onSuccess(@NonNull Integer integer) {
                        Log.d("Success", integer + " удален");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getViewState().onError(e.getMessage());
                    }
                });
    }
    public void updateElement(Elements element){
        elementsDao.update(element)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Integer>() {
                    @Override
                    public void onSuccess(@NonNull Integer integer) {
                        Log.d("Success", integer + " обновлен");
                        getViewState().onUpdate();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getViewState().onError(e.getMessage());
                    }
                });
    }
}
