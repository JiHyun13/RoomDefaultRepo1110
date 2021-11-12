package com.example.roomdefaultrepo

import androidx.room.*

@Dao
interface MemoDao {


    @Query("SELECT * FROM Memo") //SQL 처럼
    fun getAll() : List<Memo>

    @Query("SELECT content FROM Memo")
    fun getAllContent() : List<String>

    @Insert
    fun insertData(vararg memo : Memo) //vararg : 몇개가 들어오든 상관X

    @Delete
    fun deleteData(memo : Memo)

    @Update
    fun  updateData(memo : Memo)


}