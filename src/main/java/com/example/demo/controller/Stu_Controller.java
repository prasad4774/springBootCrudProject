package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Student;
import com.example.demo.service.serviceI;

import jakarta.websocket.server.PathParam;

@RestController
public class Stu_Controller 
{
	
	@Autowired 
	private serviceI  serviceI;
	
	
	@PostMapping("/Student")
	public ResponseEntity<String> saveStu(@RequestBody Student stu)
	{
		serviceI.saveData(stu);
		return new ResponseEntity<String>("Student Data Saved", HttpStatus.CREATED);
	}
	
	@GetMapping("/Student/{stuId}")
	public ResponseEntity<Student>  getData(@PathVariable("stuId")int id)
	{
		Student singleData = serviceI.getSingleData(id);
		
		return  new ResponseEntity<Student>(singleData, HttpStatus.OK);
	}
	
	@PutMapping("/Student/{stuId}")
	public ResponseEntity<String> updateData(@RequestBody Student stu, @PathVariable("stuId") int id) {
	    try {
	        boolean isUpdated = (boolean) serviceI.updateData(stu, id);
	        
	        if (isUpdated) {
	            return new ResponseEntity<>("Data Updated", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Update Failed", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	@DeleteMapping("/Student/{stuId}")
    public ResponseEntity<String> deleteData(@PathVariable("stuId") int id) {
        try {
            boolean deleteData = serviceI.deleteData(id);
            
            if (deleteData) {
                return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/Student")
	public ResponseEntity<List<Student>>  getData()
	{
		List<Student> allData = serviceI.getAllData();
		
		return  new ResponseEntity<List<Student>>(allData, HttpStatus.OK);
	}
	


}
