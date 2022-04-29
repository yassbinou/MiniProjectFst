package com.example.miniproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Recherche extends AppCompatActivity {
    private LivreViewModel mLivreViewModel;
    private List<Livre> livres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);

        Intent e = new Intent(this, MainActivity2.class);

        final Button recherche = findViewById(R.id.button2);
        final TextInputEditText motCle = (TextInputEditText) findViewById(R.id.motCle);
        final ListView listView = findViewById(R.id.list);

        AtomicReference<ListAdp> listAdp = new AtomicReference<>(new ListAdp(null));
        mLivreViewModel = new ViewModelProvider(this).get(LivreViewModel.class);

        mLivreViewModel.getAllLivre().observe(this, livre -> {
            // Update the cached copy of the words in the adapter.
            livres = livre;
            listAdp.set(new ListAdp(livre));
            listView.setAdapter(listAdp.get());


        });

        recherche.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                List<Livre> ls = new ArrayList<Livre>();

                for (Livre l : livres)
                    if (l.getTitre().contains(motCle.getEditableText().toString()))
                        ls.add(l);
                listAdp.set(new ListAdp(ls));
                listView.setAdapter(listAdp.get());
            }
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