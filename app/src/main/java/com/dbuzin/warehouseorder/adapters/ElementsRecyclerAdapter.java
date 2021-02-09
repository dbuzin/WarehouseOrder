package com.dbuzin.warehouseorder.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dbuzin.warehouseorder.R;
import com.dbuzin.warehouseorder.enteties.Elements;
import com.dbuzin.warehouseorder.views.RecyclerViewActionListener;

import java.util.List;

public class ElementsRecyclerAdapter extends RecyclerView.Adapter<ElementsRecyclerAdapter.ElementsViewHolder> {

    List<Elements> elementsList;
    private RecyclerViewActionListener mListener;

    public ElementsRecyclerAdapter(List<Elements> elementsList, RecyclerViewActionListener mListener){
        this.elementsList = elementsList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ElementsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_elements, parent,false);
        return new ElementsViewHolder(view);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementsViewHolder holder, int position) {

        holder.elementName.setText(elementsList.get(position).getName());
        holder.deleteButton.setOnClickListener(v -> mListener.onDeletedClicked(v.getId(),holder.getAdapterPosition(),elementsList.get(position)));
        holder.updateButton.setOnClickListener(v -> mListener.onUpdateClicked(v.getId(),holder.getAdapterPosition(),elementsList.get(position)));
    }

    @Override
    public int getItemCount() {
        return elementsList.size();
    }

    public static class ElementsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView elementName;
        Button updateButton;
        Button deleteButton;
        View view;

        public ElementsViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            linearLayout = (LinearLayout) itemView.findViewById(R.id.list_elements_layout);
            elementName = (TextView) itemView.findViewById(R.id.element_name);
            updateButton = (Button) itemView.findViewById(R.id.update_element);
            deleteButton = (Button) itemView.findViewById(R.id.delete_element);
        }

    }
}
