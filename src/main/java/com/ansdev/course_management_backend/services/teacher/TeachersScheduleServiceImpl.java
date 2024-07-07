package com.ansdev.course_management_backend.services.teacher;
import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.models.mybatis.teacher.TeachersSchedule;
import com.ansdev.course_management_backend.repository.TeachersScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeachersScheduleServiceImpl implements TeachersScheduleService {

    private final TeachersScheduleRepository teachersScheduleRepository;


    @Override
    public TeachersSchedule findById(Long id) {
        return teachersScheduleRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(
                        TeachersSchedule.class.getSimpleName(),
                        "id",
                        id
                )
        );
    }

    @Override
    public List<TeachersSchedule> findAll() {
        return teachersScheduleRepository.findAll();
    }

    @Transactional
    @Override
    public void insert(TeachersSchedule teachersSchedule) {
        teachersScheduleRepository.insert(teachersSchedule);
    }

    @Transactional
    @Override
    public void update(TeachersSchedule teachersSchedule) {
        teachersScheduleRepository.update(teachersSchedule);
    }
}