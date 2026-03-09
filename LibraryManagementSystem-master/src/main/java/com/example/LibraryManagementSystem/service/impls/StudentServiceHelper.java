package com.example.LibraryManagementSystem.service.impls;

import com.example.LibraryManagementSystem.DTO.RequestDto.StudentDTO.StudentGetByIdDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.StudentDTO.StudentReqDto;
import com.example.LibraryManagementSystem.DTO.ResponceDto.CardResponseDto;
import com.example.LibraryManagementSystem.DTO.ResponceDto.StudentResponseDto;
import com.example.LibraryManagementSystem.entity.Card;
import com.example.LibraryManagementSystem.entity.Student;
import com.example.LibraryManagementSystem.enums.Status;
import com.example.LibraryManagementSystem.repository.StudentRepository;
import com.example.LibraryManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceHelper implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String add(StudentReqDto studentReqDto){

        Card card = new Card();
        card.setStatus(Status.ACTIVATED);
        card.setValidTill("03-08-2040");
        card.setIssueDate(new Date());
        //created student
        Student student = new Student();
        //set all variable of student from student Dto
        student.setName(studentReqDto.getName());
        student.setAge(studentReqDto.getAge());
        student.setEmail(studentReqDto.getEmail());
        student.setDepartment(studentReqDto.getDepartment());
        student.setMobNo(studentReqDto.getMobNo());

        //save student in card
        card.setStudent(student);

        //save card in the student
        student.setCard(card);
        studentRepository.save(student);
        return "Student added successfully";
    }

    @Override
    public String updateMobileNumber(String mobNo, int id) {
        Student student;
        try{
             student = studentRepository.findById(id).get();
            student.setMobNo(mobNo);
            studentRepository.save(student);
        }catch (Exception e){
            return e.getMessage();
        }
        return "Mobile number updated successfully and newly added mobile number is "+mobNo+" for "+student.getName();
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        List<Student> students =studentRepository.findAll();
        List<StudentResponseDto> list = new ArrayList<>();
        for(Student student:students){
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setName(student.getName());
            studentResponseDto.setEmail(student.getEmail());
            studentResponseDto.setAge(student.getAge());
            studentResponseDto.setMobNo(student.getMobNo());
            studentResponseDto.setDepartment(student.getDepartment());
            studentResponseDto.setId(student.getId());
            CardResponseDto cardResponseDto = new CardResponseDto();
            cardResponseDto.setId(student.getCard().getId());
            cardResponseDto.setCardStatus(student.getCard().getStatus());
            cardResponseDto.setIssueDate(student.getCard().getIssueDate());
            cardResponseDto.setValidTill(student.getCard().getValidTill());
            studentResponseDto.setCardResponseDto(cardResponseDto);
            list.add(studentResponseDto);
        }
        return list;
    }

    @Override
    public String deleteById(StudentGetByIdDto studentGetByIdDto) {
        Optional<Student> optionalStudent = studentRepository.findById(studentGetByIdDto.getId());
        if(optionalStudent.isPresent() && optionalStudent.get().getName().equalsIgnoreCase(studentGetByIdDto.getName())){
            studentRepository.deleteById(studentGetByIdDto.getId());
            return "Student Deleted successfully";
        }
        return "Student With given id and name not found";
    }

}
