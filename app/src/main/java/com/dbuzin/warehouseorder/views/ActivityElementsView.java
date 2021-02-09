package com.dbuzin.warehouseorder.views;

import com.arellomobile.mvp.MvpView;
import com.dbuzin.warehouseorder.enteties.Elements;

import java.util.List;

public interface ActivityElementsView extends MvpView {
    void onAdding();
    void onDelete();
    void onUpdate();
    void onError(String error);
    void loadData(List<Elements> elements);
}
