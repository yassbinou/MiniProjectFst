package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity3 extends AppCompatActivity {

    private LivreViewModel mLivreViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        mLivreViewModel = new ViewModelProvider(this).get(LivreViewModel.class);



        Intent i = new Intent(this, Activity_listview.class);
        Intent e = new Intent(this, Recherche.class);

        // livreRepository.insert(new Livre("xd", "ss"));



        final Button inserer = findViewById(R.id.insrt);


        final TextInputEditText isbn =  findViewById(R.id.isbn);
        final TextInputEditText titre = findViewById(R.id.titre);

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