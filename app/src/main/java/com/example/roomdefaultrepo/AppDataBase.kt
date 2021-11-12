package com.example.roomdefaultrepo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Memo::class], version = 1) //Memo entity 에서 변수를 추가하거나 삭제하거나 하면 버전 올려줌
abstract class AppDataBase : RoomDatabase(){ //얘는 인터페이스랑 다르게 생성자를 가짐
    abstract fun memoDao() : MemoDao

    companion object{
        private var instance : AppDataBase? = null

        fun getInstance(context : Context) : AppDataBase?{
            instance = Room.databaseBuilder(
                context, //1.context, 여기서는 applicationcontext가 안되서 main걸 가져와야함(매개변수로)
                AppDataBase::class.java, //2.db
                "meno-table" //3.이름
            ).build()

            return instance
        }
    } //싱글톤. room을 적극적으로 활용할 때 인스턴스가 계속 쌓이는 것을 방지

}