package com.dbuzin.warehouseorder.components;

import android.app.Application;

import com.dbuzin.warehouseorder.enteties.Elements;
import com.dbuzin.warehouseorder.modules.AppModule;
import com.dbuzin.warehouseorder.modules.DatabaseModule;

public class App extends Application {
    private static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }
    private void initDagger(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
