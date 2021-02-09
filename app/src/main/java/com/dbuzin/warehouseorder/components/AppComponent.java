package com.dbuzin.warehouseorder.components;

import android.app.Application;

import com.dbuzin.warehouseorder.activities.BoardsActivity;
import com.dbuzin.warehouseorder.activities.ElementsActivity;
import com.dbuzin.warehouseorder.activities.MainActivity;
import com.dbuzin.warehouseorder.dao.BoardsDao;
import com.dbuzin.warehouseorder.dao.ElementsDao;
import com.dbuzin.warehouseorder.dao.OrderDao;
import com.dbuzin.warehouseorder.database.AppDatabase;
import com.dbuzin.warehouseorder.modules.AppModule;
import com.dbuzin.warehouseorder.modules.DatabaseModule;
import com.dbuzin.warehouseorder.presenters.ActivityElementsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {},modules = {AppModule.class, DatabaseModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(ElementsActivity elementsActivity);
    void inject(ActivityElementsPresenter activityElementsPresenter);
    void inject(BoardsActivity boardsActivity);

    OrderDao orderDao();
    BoardsDao boardsDao();
    ElementsDao elementsDao();

    AppDatabase appDatabase();

    Application application();
}
