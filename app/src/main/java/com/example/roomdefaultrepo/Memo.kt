package com.example.roomdefaultrepo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    @PrimaryKey(autoGenerate = true) //id를 primaryKey로 지정. 2개씩은 안되지만 List로 만들어서 넣으면 가능
    val id : Long,
    var content : String
)
