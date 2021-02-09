package com.dbuzin.warehouseorder.views;

import com.dbuzin.warehouseorder.enteties.Elements;

public interface RecyclerViewActionListener {
    void onDeletedClicked(int clickedViewId, int clickedItemPosition, Elements element);
    void onUpdateClicked(int clickedViewId, int clickedItemPosition, Elements element);
}
