package com.example.roomdefaultrepo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1) //Memo entity 에서 변수를 추가하거나 삭제하거나 하면 버전 올려줌
abstract class AppDataBase : RoomDatabase(){ //얘는 인터페이스랑 다르게 생성자를 가짐
    abstract fun memoDao() : MemoDao
}