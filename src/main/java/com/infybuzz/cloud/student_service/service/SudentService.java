package com.infybuzz.cloud.student_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.infybuzz.cloud.student_service.dto.AddressDTO;
import com.infybuzz.cloud.student_service.dto.CreateAddressRequest;
import com.infybuzz.cloud.student_service.dto.StudentDTO;
import com.infybuzz.cloud.student_service.entity.Student;
import com.infybuzz.cloud.student_service.repository.StudentRepository;
import com.infybuzz.cloud.student_service.request.StudentRequest;


@Service
public class SudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    WebClient webClient;

    public StudentDTO createStudent(StudentRequest studentRequest) {
        // Save student entity
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());

        Student savedStudent = studentRepository.save(student);

        // Prepare CreateAddressRequest
        CreateAddressRequest createAddressRequest = new CreateAddressRequest();
        createAddressRequest.setStreet(studentRequest.getStreet());
        createAddressRequest.setCity(studentRequest.getCity());

        // Send address to Address Service
        AddressDTO savedAddressDTO = createAddress(createAddressRequest);

        // Update student with addressId
        savedStudent.setAddressId(savedAddressDTO.getId());
        studentRepository.save(savedStudent);

        // Prepare StudentDTO
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(savedStudent.getId());
        studentDTO.setFirstName(savedStudent.getFirstName());
        studentDTO.setLastName(savedStudent.getLastName());
        studentDTO.setEmail(savedStudent.getEmail());
        studentDTO.setAddress(savedAddressDTO);

        return studentDTO;
    }

    // Helper method to send address to Address Service
    private AddressDTO createAddress(CreateAddressRequest createAddressRequest) {
        return webClient.post()
            .uri("/create") // Replace with actual endpoint
            .bodyValue(createAddressRequest)
            .retrieve()
            .bodyToMono(AddressDTO.class)
            .block();
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));

        AddressDTO addressDTO = getAddressById(student.getAddressId());

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setAddress(addressDTO);

        return studentDTO;
    }

    private AddressDTO getAddressById(Long addressId) {
        return webClient.get()
            .uri("/getById/" + addressId)
            .retrieve()
            .bodyToMono(AddressDTO.class)
            .block();
    }
}
