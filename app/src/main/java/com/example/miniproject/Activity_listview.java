package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class Activity_listview extends AppCompatActivity {

    private LivreViewModel mLivreViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final LivreListAdapter adapter = new LivreListAdapter(new LivreListAdapter.LivreDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mLivreViewModel = new ViewModelProvider(this).get(LivreViewModel.class);

        mLivreViewModel.getAllLivre().observe(this, livre -> {
            // Update the cached copy of the words in the adapter.

            adapter.submitList(livre);

        });


    }
}