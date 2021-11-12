package com.example.roomdefaultrepo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Memo(
    var content : String
){
    @PrimaryKey(autoGenerate = true) //id를 primaryKey로 지정. 2개씩은 안되지만 List로 만들어서 넣으면 가능
    var id : Long = 0 //1씩 증가. 여기 중괄호에 넣으면 기본 변수가됨
}
