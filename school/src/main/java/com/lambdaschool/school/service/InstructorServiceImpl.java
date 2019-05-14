package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "instructorService")
public class InstructorServiceImpl implements InstructorService
{
    @Autowired
    private InstructorRepository instructrepos;

    @Transactional
    @Override
    public Instructor save(Instructor instructor) {
        Instructor newInstructor = new Instructor();
        newInstructor.setInstructname(instructor.getInstructname());
        newInstructor.setInstructid(instructor.getInstructid());


        return instructrepos.save( newInstructor);

    }
}
