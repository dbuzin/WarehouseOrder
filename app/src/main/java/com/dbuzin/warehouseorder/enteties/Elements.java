package com.dbuzin.warehouseorder.enteties;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import dagger.Provides;

@Entity
public class Elements {

    @PrimaryKey(autoGenerate = true)
    public long elementId = 0;

    public String name;

    public Elements(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
