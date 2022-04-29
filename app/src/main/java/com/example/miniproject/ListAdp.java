package com.example.miniproject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdp extends BaseAdapter {

    //Dữ liệu liên kết bởi Adapter là một mảng các sản phẩm
    final List<Livre> listLivres;

    ListAdp(List<Livre> listLivres) {
        this.listLivres = listLivres;
    }

    @Override
    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView

        return listLivres.size();
    }

    @Override
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        //có chỉ số position trong listProduct
        return listLivres.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Trả về một ID của phần
        return listLivres.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
        //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
        //Nếu null cần tạo mới

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.recyclerview_item, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
        Livre livre = (Livre) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.textView6)).setText( livre.getIsbn());
        ((TextView) viewProduct.findViewById(R.id.textView)).setText( livre.getTitre());


        return viewProduct;
    }
}

