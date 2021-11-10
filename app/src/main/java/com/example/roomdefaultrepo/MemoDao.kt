package com.example.roomdefaultrepo

import androidx.room.*

@Dao
interface MemoDao {


    @Query("SELECT * FROM Memo") //SQL 처럼
    fun getAll() : List<Memo>


    @Insert
    fun insertData(memo : Memo)

    @Delete
    fun deleteData(memo : Memo)

    @Update
    fun  updateData(memo : Memo)


}