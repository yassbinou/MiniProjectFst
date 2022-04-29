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


    @Query("UPDATE  livre SET titre= :titre, isbn=:isbn WHERE id = :id" )
    void updateById(int id,String titre, String isbn);

    @Query("UPDATE  livre SET titre= :titre WHERE id = :id" )
    void updateTitreById(int id,String titre);

    @Query("UPDATE  livre SET  isbn=:isbn WHERE id = :id" )
    void updateIsbnById(int id, String isbn);

    @Query("DELETE FROM livre")
    void deleteAll();

    @Query("DELETE FROM livre Where id = :id")
    void deleteById(int id);

}
