package com.example.liststudent.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.liststudent.R
import com.example.liststudent.models.Student

class StudentAdapter(private val context: Context, private var students: List<Student>) : BaseAdapter() {

    override fun getCount(): Int = students.size
    override fun getItem(position: Int): Any = students[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_student, parent, false)
        val student = students[position]
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvMSSV: TextView = view.findViewById(R.id.tvMSSV)
        tvName.text = student.name
        tvMSSV.text = student.mssv

        return view
    }

    fun updateData(newStudents: List<Student>) {
        students = newStudents
        notifyDataSetChanged()
    }
}
