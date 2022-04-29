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

    void delete(Livre livre){
        mRepository.delete(livre);
    }
    void deleteById(int id){
        mRepository.deleteById(id);
    }

    void updateById(int id, String titre, String isbn){
        mRepository.updateById(id, titre, isbn);
    }
    void updateTitreById(int id, String titre){
        mRepository.updateTitreById(id, titre);
    }
    void updateIsbnById(int id, String isbn){
        mRepository.updateIsbnById(id, isbn);
    }
}
