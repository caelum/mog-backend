package br.com.caelum.mog.repositories;

import br.com.caelum.mog.domains.dtos.CourseDTO;

public interface CoursesRepository {
    Iterable<CourseDTO> findAll();
}
