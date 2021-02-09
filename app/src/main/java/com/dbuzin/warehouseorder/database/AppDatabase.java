package com.dbuzin.warehouseorder.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.dbuzin.warehouseorder.converters.Converters;
import com.dbuzin.warehouseorder.dao.BoardsDao;
import com.dbuzin.warehouseorder.dao.ElementsDao;
import com.dbuzin.warehouseorder.dao.OrderDao;
import com.dbuzin.warehouseorder.enteties.Boards;
import com.dbuzin.warehouseorder.enteties.Elements;
import com.dbuzin.warehouseorder.enteties.Order;

@Database(entities = {Order.class, Boards.class, Elements.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract OrderDao getOrderDao();
    public abstract BoardsDao getBoardsDao();
    public abstract ElementsDao getElementsDao();
}
