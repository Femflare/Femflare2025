package com.klef.flemflare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.flemflare.model.Student;
import com.klef.flemflare.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String StuRegistration(Student stu) 
    {
        studentRepository.save(stu);
        return "Student Registered Successfully";
    }

    @Override
    public Student checkstulogin(String stuemail, String stupwd) 
    {
        return studentRepository.checkstulogin(stuemail, stupwd);
    }

    @Override
    public String updateStudentProfile(Student student) 
    {
        Student s = studentRepository.findById(student.getSno()).get();
        
        s.setName(student.getName());
        s.setContact(student.getContact());
        s.setDepartment(student.getDepartment());   
        s.setPassword(student.getPassword());
        
        studentRepository.save(s);
        
        return "Student Profile Updated Successfully";
    }

    @Override
    public Student displayStudentbyID(int sid) 
    {
        return studentRepository.findById(sid).get();
    }
}
