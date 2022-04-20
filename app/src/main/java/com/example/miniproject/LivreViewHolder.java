package com.example.miniproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LivreViewHolder extends RecyclerView.ViewHolder {
    private final TextView isbn;
    private final TextView titre;

    private LivreViewHolder(View itemView) {
        super(itemView);
        isbn = itemView.findViewById(R.id.textView6);
        titre = itemView.findViewById(R.id.textView);
    }

    public void bind(String title, String isb) {
        titre.setText(title);
        isbn.setText(isb);
    }

    static LivreViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new LivreViewHolder(view);
    }
}
