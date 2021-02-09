package com.dbuzin.warehouseorder.enteties;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.HashMap;

import dagger.Provides;

@Entity
public class Order {
    @PrimaryKey(autoGenerate = true)
    public Long orderId;
    public String name;
    public Date date; //timestamp
    public HashMap<Long,Integer> content; //boards ids as key, amount as value
    public String description;
}
