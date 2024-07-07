package com.ansdev.course_management_backend.services.student;

import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.models.mybatis.student.Student;
import com.ansdev.course_management_backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void insert(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(Student.class.getSimpleName(), "student", String.valueOf(id))
        );
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudentToGroup(long id, long groupId) {
        studentRepository.addStudentToGroup(id, groupId);
    }

    @Override
    public boolean checkStudentAlreadyAddedToGroup(long id) {
        return studentRepository.checkStudentAlreadyAddedToGroup(id);
    }


}