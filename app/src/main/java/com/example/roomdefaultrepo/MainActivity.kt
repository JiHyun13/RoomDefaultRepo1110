package com.example.roomdefaultrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.PrimaryKey
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db : AppDataBase
    private lateinit var contentList : List<String>
    private lateinit var memoList : List<Memo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDataBase.getInstance(this)!!



        loadData()

        findViewById<Button>(R.id.saveDataButton).setOnClickListener {
            val content : String = findViewById<EditText>(R.id.saveDataEditText).text.toString()
            CoroutineScope(Dispatchers.IO).launch {
               db.memoDao().insertData(Memo(content))
                loadData()
            }

        }

        findViewById<Button>(R.id.deleteDataButton).setOnClickListener {
            val deleteEditText : EditText = findViewById(R.id.deleteDataEditText)
            val index : Int = deleteEditText.text.toString().toInt()
            val deleteData : Memo = memoList[index]
            CoroutineScope(Dispatchers.IO).launch {
                db.memoDao().deleteData(deleteData)
                loadData()
            }
        }


    }

    private fun loadData() {
        CoroutineScope(Dispatchers.IO).launch {
            //비동기 코드(뒤에서 돌아가는 코드, 레트로핏 서버, 테이블 관련 작업(db))
            //Dispatchers.Main 은 runOnUiThread처럼 동기코드가 된다

            memoList = db.memoDao().getAll()
            contentList = db.memoDao().getAllContent()

            runOnUiThread {
                //동기코드 (앞에서 돌아가는 코드, .setText 어뎁터 설정, 뷰 설정)
                findViewById<TextView>(R.id.resultDataText).text = contentList.toString()


            }
        }
    }

}