package com.StudentManagement.controller;

import com.StudentManagement.entities.GradesSubject;
import com.StudentManagement.entities.Profesor;
import com.StudentManagement.entities.Student;
import com.StudentManagement.entities.StudentGrade;
import com.StudentManagement.services.GradesSubjectService;
import com.StudentManagement.services.ProfesorService;
import com.StudentManagement.services.StudentGradeService;
import com.StudentManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;
    @Autowired
    GradesSubjectService gradesSubjectService;
    @Autowired
    StudentGradeService studentGradeService;
    @Autowired
    StudentService studentService;


    @PostMapping("/addOrUpdate")
    public Profesor createProfesor(@Valid @RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }

    @GetMapping("/all")
    public List<Profesor> getAll() {
        return profesorService.findAll();
    }


    @PostMapping("/delete")
    public void deleteProfesor(@Valid @RequestBody Profesor profesor) {
        profesorService.delete(profesor);
    }

    @GetMapping("/addGrade")
    public void addGrade(@RequestParam("profesor") String profesor, @RequestParam("grade") Integer grade, @RequestParam("student") String mail) {

        int idSubject = profesorService.findByUsername(profesor).getSubject();
        List<GradesSubject> gradesSubjects = gradesSubjectService.findByGradeAndSubject(grade, idSubject);
       System.out.println(gradesSubjects.toString());
        if (gradesSubjects.isEmpty()) {
             gradesSubjectService.saveOrUpdate(new GradesSubject(grade, idSubject));

        }
        Student student = studentService.findByEmail(mail);
            studentGradeService.save(new StudentGrade(student.getIdStudent(), gradesSubjects.get(0).getIdgradesubject()));


    }

}
