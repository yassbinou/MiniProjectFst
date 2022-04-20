package com.example.miniproject;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LivreRepository  {

    private LivreDao mLivreDao;
    public LiveData<List<Livre>>  mAllLivre;


    public LivreRepository(Application application) {

        AppDatabase db = AppDatabase.getDatabase(application);
        mLivreDao = db.livreDao();
        mAllLivre = mLivreDao.getAll();
    }
    LiveData<List<Livre>> getmAllLivre() { return mAllLivre;}
    void insert(Livre livre){
        AppDatabase.databaseWriteExecutor.execute(() ->{
            mLivreDao.insert(livre);

        });
    }
}
