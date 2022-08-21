package com.fujitalabs.periodic_table;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ElementsDao {

    @Query("SELECT * FROM elements")
    List<Element> getAll();

}
