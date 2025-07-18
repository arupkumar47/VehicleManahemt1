package com.infybuzz.cloud.student_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infybuzz.cloud.student_service.dto.StudentDTO;
import com.infybuzz.cloud.student_service.request.StudentRequest;
import com.infybuzz.cloud.student_service.service.SudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	SudentService sudentService;

	@PostMapping("/create")
	ResponseEntity<StudentDTO> createStudent(@RequestBody StudentRequest studentRequest){
		System.out.println(studentRequest.getFirstName());
	return ResponseEntity.status(HttpStatus.CREATED).body(sudentService.createStudent(studentRequest));
			}
	@GetMapping("/getById/{id}")
	ResponseEntity<StudentDTO> getById(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(sudentService.getStudentById(id));
	}
	
}
