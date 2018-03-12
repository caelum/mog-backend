package br.com.caelum.mog.rest;

import br.com.caelum.mog.domains.models.Course;

public interface CoursesClient {
    Course getCourseByCode(String code);
}
