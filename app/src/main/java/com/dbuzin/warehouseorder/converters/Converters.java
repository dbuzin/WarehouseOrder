package com.dbuzin.warehouseorder.converters;

import androidx.room.TypeConverter;

import com.dbuzin.warehouseorder.enteties.Boards;
import com.dbuzin.warehouseorder.enteties.Elements;
import com.dbuzin.warehouseorder.enteties.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Flowable;

public class Converters {
    @TypeConverter
    public static HashMap<Long, Integer> toHashMap(String value){
        Type mapType = new TypeToken<HashMap<Long, Integer>>(){}.getType();
        return new Gson().fromJson(value, mapType);
    }

    @TypeConverter
    public static Flowable<List<Order>> toListOrder(String value){
        Type orderType = new TypeToken<Flowable<List<Order>>>(){}.getType();
        return new Gson().fromJson(value, orderType);
    }

    @TypeConverter
    public static Flowable<List<Boards>> toListBoards(String value){
        Type boardsType = new TypeToken<Flowable<List<Boards>>>(){}.getType();
        return new Gson().fromJson(value, boardsType);
    }

    @TypeConverter
    public static Flowable<List<Elements>> toListElements(String value){
        Type elementsType = new TypeToken<Flowable<List<Elements>>>(){}.getType();
        return new Gson().fromJson(value, elementsType);
    }

    @TypeConverter
    public static String fromHashMap(HashMap<Long, Integer> hashMap){
        return new Gson().toJson(hashMap);
    }

    @TypeConverter
    public static String fromListOrder(Flowable<List<Order>> listOrder){
        return new Gson().toJson(listOrder);
    }

    @TypeConverter
    public static String fromListBoards(Flowable<List<Boards>> listBoards){
        return new Gson().toJson(listBoards);
    }

    @TypeConverter
    public static String fromListElements(Flowable<List<Elements>> listElements){
        return new Gson().toJson(listElements);
    }

    @TypeConverter
    public Date fromTimestamp(Long value){
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public Long dateToTimestamp(Date date){
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public Long toLong(long id){
        return Long.valueOf(id);
    }

    @TypeConverter
    public long fromLong(Long id){
        return id.longValue();
    }
}
