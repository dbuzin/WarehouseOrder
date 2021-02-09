package com.dbuzin.warehouseorder.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.dbuzin.warehouseorder.databinding.ActivityMainBinding;
import com.dbuzin.warehouseorder.presenters.MainPresenter;
import com.dbuzin.warehouseorder.views.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    ActivityMainBinding activityMainBinding;
    Button createOrderButton;
    Button goOrdersButton;
    Button goBoardsButton;
    Button goElementsButton;

    @InjectPresenter
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        createOrderButton = activityMainBinding.createOrderButton;
        goOrdersButton = activityMainBinding.goOrdersButton;
        goBoardsButton = activityMainBinding.goOrdersButton;
        goElementsButton = activityMainBinding.goElementsButton;

        goElementsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ElementsActivity.class);
                startActivity(intent);
            }
        });
    }
}