package com.dbuzin.warehouseorder.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dbuzin.warehouseorder.enteties.Boards;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface BoardsDao {
    @Query("SELECT * FROM   `boards`")
    Flowable<List<Boards>> getAll();

    @Query("SELECT * FROM `boards` WHERE name LIKE '%' || :name || '%'")
    Maybe<Boards> getByName(String name);

    @Insert
    Maybe<Long> insert(Boards board);
    @Update
    Single<Integer> update(Boards board);
    @Delete
    Single<Integer> delete(Boards board);
}
