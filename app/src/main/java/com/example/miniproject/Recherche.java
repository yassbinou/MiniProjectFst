package com.example.miniproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recherche extends AppCompatActivity {
    private LivreViewModel mLivreViewModel;
    private List<Livre> livres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        final Button recherche = findViewById(R.id.button2);


        final TextInputEditText motCle = (TextInputEditText) findViewById(R.id.motCle);



        RecyclerView recyclerView = findViewById(R.id.listRech);
        final LivreListAdapter adapter = new LivreListAdapter(new LivreListAdapter.LivreDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mLivreViewModel = new ViewModelProvider(this).get(LivreViewModel.class);

        mLivreViewModel.getAllLivre().observe(this, livre -> {
            // Update the cached copy of the words in the adapter.

            adapter.submitList(livre);
            livres = livre;

        });

        recherche.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {
                List<Livre> ls = new ArrayList<Livre>();

                for(Livre l : livres)
                    if(l.getTitre().contains(motCle.getEditableText().toString()))
                        ls.add(l);
                adapter.submitList(ls);
            }
        });
    }
}