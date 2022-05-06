package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.concurrent.atomic.AtomicReference;
public class Activity_listview extends AppCompatActivity {

    private LivreViewModel mLivreViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ListView listView = findViewById(R.id.listView);

        Intent e = new Intent(this, MainActivity2.class);

        AtomicReference<ListAdp> listAdp = new AtomicReference<>(new ListAdp(null));
        mLivreViewModel = new ViewModelProvider(this).get(LivreViewModel.class);

               mLivreViewModel.getAllLivre().observe(this, livre -> {
            // Update the cached copy of the words in the adapter.
            listAdp.set(new ListAdp(livre));
            listView.setAdapter(listAdp.get());
            //adapter.submitList(livre);

        });




listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Livre product = (Livre) listAdp.get().getItem(position);
        System.out.println(product.getIsbn());
        e.putExtra("id", product.getId());
        startActivity(e);

    }
});
    }
}