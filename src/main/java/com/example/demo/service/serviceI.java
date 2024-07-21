package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.Student;

public interface serviceI {

	public void  saveData(Student stu);

	public Student getSingleData(int id);

	public boolean updateData(Student stu, int id);

	public boolean deleteData(int id);

	public List<Student> getAllData();

	//public String updateData(Student stu, int id);

}
