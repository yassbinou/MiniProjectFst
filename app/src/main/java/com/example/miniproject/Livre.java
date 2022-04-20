package com.example.miniproject;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "livre")
public class Livre implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "titre")
    private String titre;
    @ColumnInfo(name = "isbn")
    private String isbn;

    public Livre(int id, String titre, String isbn) {
        this.id = id;
        this.titre = titre;
        this.isbn = isbn;
    }

    public Livre() {
    }

    public Livre(String titre, String isbn) {
        this.titre = titre;
        this.isbn = isbn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
