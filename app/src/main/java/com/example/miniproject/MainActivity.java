package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private LivreViewModel mLivreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(c.getTime());

        mLivreViewModel = new ViewModelProvider(this).get(LivreViewModel.class);


        Intent i = new Intent(this, Activity_listview.class);
        Intent e = new Intent(this, Recherche.class);
        Intent s = new Intent(this, MainActivity3.class);



        final Button affichage = findViewById(R.id.affichage);
        final Button recherche = findViewById(R.id.recherche);
        final Button ins = findViewById(R.id.insertion);
        final Button maps = findViewById(R.id.maps);

        final TextView date = findViewById(R.id.date);

        date.setText(strDate);
        affichage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);*/
                startActivity(s);
            }
        });
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }
}