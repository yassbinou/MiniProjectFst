package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private LivreViewModel mLivreViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLivreViewModel = new ViewModelProvider(this).get(LivreViewModel.class);



        Intent i = new Intent(this, Activity_listview.class);
        Intent e = new Intent(this, Recherche.class);

        // livreRepository.insert(new Livre("xd", "ss"));



        final Button affichage = findViewById(R.id.affichage);
        final Button recherche = findViewById(R.id.recherche);
        final Button inserer = findViewById(R.id.inserer);

        final TextInputEditText isbn = (TextInputEditText) findViewById(R.id.isbn);
        final TextInputEditText titre = (TextInputEditText) findViewById(R.id.titre);

        affichage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                // livreRepository.getmAllLivre().observe(this, livres -> System.out.println(livres.get(0)));
                // System.out.println(livreRepository.getmAllLivre().getValue().get(0).toString());
                startActivity(i);
            }
        });
        recherche.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                // livreRepository.getmAllLivre().observe(this, livres -> System.out.println(livres.get(0)));
                // System.out.println(livreRepository.getmAllLivre().getValue().get(0).toString());
                startActivity(e);
            }
        });
        inserer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Livre livre = new Livre(titre.getText().toString(), isbn.getText().toString());
                mLivreViewModel.insert(livre);
                startActivity(i);
            }
        });

    }
}