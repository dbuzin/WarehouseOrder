package com.dbuzin.warehouseorder.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dbuzin.warehouseorder.enteties.Elements;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface ElementsDao {
    @Query("SELECT * FROM   `elements`")
    Flowable<List<Elements>> getAll();

    @Query("SELECT * FROM `elements` WHERE name LIKE '%' || :name || '%'")
    Maybe<Elements> getByName(String name);

    @Insert
    Maybe<Long> insert(Elements element);
    @Update
    Single<Integer> update(Elements element);
    @Delete
    Single<Integer> delete(Elements element);
}
