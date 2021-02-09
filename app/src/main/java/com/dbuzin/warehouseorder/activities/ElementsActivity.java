package com.dbuzin.warehouseorder.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.dbuzin.warehouseorder.R;
import com.dbuzin.warehouseorder.adapters.ElementsRecyclerAdapter;
import com.dbuzin.warehouseorder.databinding.ActivityElementsBinding;
import com.dbuzin.warehouseorder.enteties.Elements;
import com.dbuzin.warehouseorder.presenters.ActivityElementsPresenter;
import com.dbuzin.warehouseorder.views.ActivityElementsView;
import com.dbuzin.warehouseorder.views.RecyclerViewActionListener;

import java.util.List;

import javax.inject.Inject;

public class ElementsActivity extends MvpAppCompatActivity implements ActivityElementsView, RecyclerViewActionListener {

    ActivityElementsBinding activityElementsBinding;
    Button addElementButton;
    RecyclerView elementsListRecyclerView;
    EditText elementName;
    AlertDialog alertDialog;
    AlertDialog updatingAlertDialog;
    ElementsRecyclerAdapter elementsRecyclerAdapter;
    LayoutInflater li; // inflater for dialog views
    View addingView; // view for adding dialog

    @InjectPresenter
    ActivityElementsPresenter activityElementsPresenter;

    Elements element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityElementsBinding = ActivityElementsBinding.inflate(getLayoutInflater());
        View view = activityElementsBinding.getRoot();

        activityElementsPresenter.loadData(); //load data from db to recyclerview

        setContentView(view);

        addElementButton = activityElementsBinding.addElementButton;

        li = LayoutInflater.from(super.getBaseContext());
        addingView = li.inflate(R.layout.adding_dialog_layout, null);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
        alertDialogBuilder.setView(addingView);
        elementName = (EditText) addingView.findViewById(R.id.elementNameText);

        alertDialogBuilder // adding dialog
                .setCancelable(true)
                .setPositiveButton(R.string.save_button, (dialog, which) -> {
                    if(!TextUtils.isEmpty(elementName.getText().toString())){
                        try {
                            element = new Elements(elementName.getText().toString());
                            activityElementsPresenter.addElement(element);
                            dialog.dismiss();
                        }
                        catch (NullPointerException e){
                            e.printStackTrace();
                        }
                    }
                    else {
                        elementName.setError("" + R.string.empty_text);
                    }
                })
                .setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());
        alertDialog = alertDialogBuilder.create();

        addElementButton.setOnClickListener(v -> alertDialog.show());
    }

    @Override
    public void onAdding() {
        Toast.makeText(this, elementName.getText().toString() + " " + R.string.created_toast, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDelete() {
        Toast.makeText(this, R.string.deleting_toast, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpdate() {
        Toast.makeText(this, elementName.getText().toString() + " " + R.string.updating_toast, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadData(List<Elements> elements) {
        elementsRecyclerAdapter = new ElementsRecyclerAdapter(elements, this);
        elementsListRecyclerView = activityElementsBinding.elementsList;
        elementsListRecyclerView.setAdapter(elementsRecyclerAdapter);
    }

    @Override
    public void onDeletedClicked(int clickedViewId, int clickedItemPosition, Elements element) {
        activityElementsPresenter.deleteElement(element);
    }

    @Override
    public void onUpdateClicked(int clickedViewId, int clickedItemPosition, Elements element) {
        final AlertDialog.Builder updatingAlertDialogBuilder = new AlertDialog.Builder(ElementsActivity.this);
        updatingAlertDialogBuilder.setView(addingView);
        updatingAlertDialogBuilder
                .setCancelable(true)
                .setPositiveButton(R.string.save_button, (dialog, which) -> {
                    if(!TextUtils.isEmpty(elementName.getText().toString())){
                        try {
                            element.setName(elementName.getText().toString());
                            activityElementsPresenter.updateElement(element);
                            dialog.dismiss();
                        }
                        catch (NullPointerException e){
                            e.printStackTrace();
                        }
                    }
                    else {
                        elementName.setError("" + R.string.empty_text);
                    }
                })
                .setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());
        updatingAlertDialog = updatingAlertDialogBuilder.create();
        updatingAlertDialog.show();
    }
}