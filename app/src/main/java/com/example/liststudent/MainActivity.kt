package com.example.liststudent

import com.example.liststudent.adapters.StudentAdapter
import com.example.liststudent.models.Student
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var listView: ListView
    private lateinit var studentAdapter: StudentAdapter

    private val students = listOf(
        Student("Phan Tat Thang", "20210372"),
        Student("Tran Hoang Son", "20210744"),
        Student("Tran Nhat Hoa", "20210118"),
        Student("Pham Dinh Chien", "20200356"),
        Student("Nguyen Van Bang", "20205778"),
        Student("Tran Han Minh", "20215322")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSearch = findViewById(R.id.etSearch)
        listView = findViewById(R.id.listView)

        studentAdapter = StudentAdapter(this, students)
        listView.adapter = studentAdapter

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val keyword = s.toString()

                if (keyword.length > 2) {
                    val filteredList = students.filter {
                        it.name.contains(keyword, ignoreCase = true) || it.mssv.contains(keyword, ignoreCase = true)
                    }
                    studentAdapter.updateData(filteredList)
                } else {
                    studentAdapter.updateData(students)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
