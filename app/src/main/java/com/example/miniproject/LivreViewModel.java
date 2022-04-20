package com.example.miniproject;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LivreViewModel extends AndroidViewModel {
    private LivreRepository mRepository;
    private final LiveData<List<Livre>> mAllWords;

    public LivreViewModel(Application application) {
        super(application);
        mRepository = new LivreRepository(application);
        mAllWords = mRepository.getmAllLivre();
    }

    LiveData<List<Livre>> getAllLivre() {
        return mAllWords;
    }

    void insert(Livre livre) {
        mRepository.insert(livre);
    }
}
