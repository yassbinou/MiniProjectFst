package com.example.miniproject;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class LivreListAdapter extends ListAdapter<Livre, LivreViewHolder> {

    public LivreListAdapter(@NonNull DiffUtil.ItemCallback<Livre> diffCallback) {
        super(diffCallback);
    }

    @Override
    public LivreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return LivreViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(LivreViewHolder holder, int position) {
        Livre current = getItem(position);
        holder.bind(current.getTitre(), current.getIsbn());
    }

    static class LivreDiff extends DiffUtil.ItemCallback<Livre> {

        @Override
        public boolean areItemsTheSame(@NonNull Livre oldItem, @NonNull Livre newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Livre oldItem, @NonNull Livre newItem) {
            return oldItem.getIsbn().equals(newItem.getIsbn());
        }
    }
}
