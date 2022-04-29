package com.example.miniproject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdp extends BaseAdapter {


    final List<Livre> listLivres;

    ListAdp(List<Livre> listLivres) {
        this.listLivres = listLivres;
    }

    @Override
    public int getCount() {
        return listLivres.size();
    }

    @Override
    public Object getItem(int position) {
        return listLivres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listLivres.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.recyclerview_item, null);
        } else viewProduct = convertView;

        Livre livre = (Livre) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.textView6)).setText( livre.getIsbn());
        ((TextView) viewProduct.findViewById(R.id.textView)).setText( livre.getTitre());


        return viewProduct;
    }
}

