package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
@Service
public class ServiceImp implements serviceI {
	
	List<Student>  slist = new ArrayList<Student>();


	@Override
	public void saveData(Student stu) 
	{
		slist.add(stu);
		
	}


	@Override
	public Student getSingleData(int id) 
	{
		
		for (int i = 0; i < slist.size(); i++) {
	        Student student = slist.get(i);
	        if (student.getStuId() == id) {
	            // Update the existing student data
	            Student student2 = slist.get(i);
	            return student2;
	        }
	    }
	    // Student not found
	    return null;
	}


	@Override
	public boolean updateData(Student stu, int id) {
	    // Find the student by ID
	    for (int i = 0; i < slist.size(); i++) {
	        Student student = slist.get(i);
	        if (student.getStuId() == id) {
	            // Update the existing student data
	            slist.set(i, stu);
	            return true;
	        }
	    }
	    // Student not found
	    return false;
	}

	
	 @Override
	    public boolean deleteData(int id) {
	        for (int i = 0; i < slist.size(); i++) {
	            Student stu = slist.get(i);
	            if (stu.getStuId() == id) {
	                slist.remove(i);
	                return true;
	            }
	        }
	        return false;
	    }


	@Override
	public List<Student> getAllData() 
	{
			return new ArrayList<Student>(slist);
	}

		
		
	}

