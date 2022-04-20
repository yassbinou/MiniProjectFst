package com.example.miniproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LivreDao {
    @Query("SELECT * FROM livre")
    LiveData<List<Livre>> getAll();
    @Insert
    void insert(Livre livre);

    @Delete
    void delete(Livre livre);

    @Update
    void update(Livre livre);

    @Query("DELETE FROM livre")
    void deleteAll();
}
