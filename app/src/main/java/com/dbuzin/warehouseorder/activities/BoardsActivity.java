package com.dbuzin.warehouseorder.activities;

import android.os.Bundle;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.dbuzin.warehouseorder.R;
import com.dbuzin.warehouseorder.databinding.ActivityBoardsBinding;
import com.dbuzin.warehouseorder.enteties.Boards;
import com.dbuzin.warehouseorder.presenters.ActivityBoardsPresenter;
import com.dbuzin.warehouseorder.views.ActivityBoardsView;

import java.util.List;

public class BoardsActivity extends MvpAppCompatActivity implements ActivityBoardsView {

    ActivityBoardsBinding activityBoardsBinding;

    @InjectPresenter
    ActivityBoardsPresenter activityBoardsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBoardsBinding = ActivityBoardsBinding.inflate(getLayoutInflater());
        View view = activityBoardsBinding.getRoot();
        setContentView(view);
    }

    @Override
    public void onAdding() {

    }

    @Override
    public void onDelete() {

    }

    @Override
    public void onUpdate() {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void loadData(List<Boards> boards) {

    }
}