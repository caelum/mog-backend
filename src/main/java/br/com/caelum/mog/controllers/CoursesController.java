package br.com.caelum.mog.controllers;


import br.com.caelum.mog.domains.dtos.CourseDTO;
import br.com.caelum.mog.repositories.CoursesRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("courses")
public class CoursesController {


    private final CoursesRepository repository;

    public CoursesController(CoursesRepository repository) {
        this.repository = repository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CourseDTO> findAll(){
        return repository.findAll();
    }

}
