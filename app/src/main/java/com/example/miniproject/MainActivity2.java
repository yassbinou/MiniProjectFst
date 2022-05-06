package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {

    private LivreViewModel mLivreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = new Intent(this, Activity_listview.class);

        final Button modif = findViewById(R.id.modif);
        final Button supp = findViewById(R.id.button);
        final TextInputEditText isbn = findViewById(R.id.isbn2);
        final TextInputEditText titre = findViewById(R.id.titre2);

        mLivreViewModel = new ViewModelProvider(this).get(LivreViewModel.class);

        supp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                mLivreViewModel.deleteById(getIntent().getIntExtra("id", 1));
                finish();

            }
        });
        modif.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                System.out.println(isbn.getText().toString());
                if (!isbn.getText().toString().equals("") && !titre.getText().toString().equals("")) {
                    mLivreViewModel.updateById(getIntent().getIntExtra("id", 1), titre.getText().toString(), isbn.getText().toString());
                } else if (isbn.getText().toString().equals("") && !titre.getText().toString().equals("")) {
                    mLivreViewModel.updateTitreById(getIntent().getIntExtra("id", 1), titre.getText().toString());
                } else if (!isbn.getText().toString().equals("") && titre.getText().toString().equals("")) {
                    mLivreViewModel.updateIsbnById(getIntent().getIntExtra("id", 1), isbn.getText().toString());
                }

                finish();
            }
        });

    }
}