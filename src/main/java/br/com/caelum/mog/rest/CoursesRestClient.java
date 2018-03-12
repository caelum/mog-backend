package br.com.caelum.mog.rest;

import br.com.caelum.mog.domains.dtos.CourseDTO;
import br.com.caelum.mog.domains.models.Course;

import java.util.List;

public interface CoursesRestClient {
    Course getCourseByCode(String code);
    List<CourseDTO> getAllSimplesCourse();
}
