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
    void delete(Livre livre){
        AppDatabase.databaseWriteExecutor.execute(() ->{
            mLivreDao.delete(livre);

        });
    }
    void deleteById(int id){
        AppDatabase.databaseWriteExecutor.execute(() ->{
            mLivreDao.deleteById(id);

        });
    }
    void updateById(int id, String titre, String isbn){
        AppDatabase.databaseWriteExecutor.execute(() ->{
            mLivreDao.updateById(id, titre, isbn);

        });
    }
    void updateTitreById(int id, String titre){
        AppDatabase.databaseWriteExecutor.execute(() ->{
            mLivreDao.updateTitreById(id, titre);

        });
    }
    void updateIsbnById(int id,  String isbn){
        AppDatabase.databaseWriteExecutor.execute(() ->{
            mLivreDao.updateIsbnById(id, isbn);

        });
    }
}
