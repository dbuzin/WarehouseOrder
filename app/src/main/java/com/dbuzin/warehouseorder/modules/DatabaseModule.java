package com.dbuzin.warehouseorder.modules;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dbuzin.warehouseorder.dao.BoardsDao;
import com.dbuzin.warehouseorder.dao.ElementsDao;
import com.dbuzin.warehouseorder.dao.OrderDao;
import com.dbuzin.warehouseorder.database.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    private AppDatabase appDatabase;
    public DatabaseModule(Application mApplication){
        appDatabase = Room.databaseBuilder(mApplication, AppDatabase.class,"dbWarehouse")
                .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                .build();
    }

    @Singleton
    @Provides
    public AppDatabase provideDatabase(){
        return appDatabase;
    }

    @Singleton
    @Provides
    OrderDao providesOrderDao(AppDatabase appDatabase){
        return appDatabase.getOrderDao();
    }

    @Singleton
    @Provides
    BoardsDao providesBoardsDao(AppDatabase appDatabase){
        return appDatabase.getBoardsDao();
    }

    @Singleton
    @Provides
    ElementsDao providesElementsDao(AppDatabase appDatabase){
        return appDatabase.getElementsDao();
    }
}
