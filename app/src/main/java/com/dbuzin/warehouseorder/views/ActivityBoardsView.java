package com.dbuzin.warehouseorder.views;

import com.arellomobile.mvp.MvpView;
import com.dbuzin.warehouseorder.enteties.Boards;

import java.util.List;

public interface ActivityBoardsView extends MvpView {
    void onAdding();
    void onDelete();
    void onUpdate();
    void onError(String error);
    void loadData(List<Boards> boards);
}
