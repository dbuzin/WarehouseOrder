package com.dbuzin.warehouseorder.enteties;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.HashMap;


@Entity
public class Boards {
    @PrimaryKey(autoGenerate = true)
    public Long boardId;
    public String name;
    public HashMap<Long,Integer> elements; // elements ids as key, amount as value
}
