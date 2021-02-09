package com.dbuzin.warehouseorder.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dbuzin.warehouseorder.enteties.Order;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface OrderDao {
    @Query("SELECT * FROM   `order`")
    Flowable<List<Order>> getAll();

    @Query("SELECT * FROM `order` WHERE name LIKE '%' || :name || '%'")
    Maybe<Order> getByName(String name); //TODO добавить конвертер

    @Insert
    Maybe<Long> insert(Order order); //TODO сделать void
    @Update
    Single<Integer> update(Order order);
    @Delete
    Single<Integer> delete(Order order);
}
