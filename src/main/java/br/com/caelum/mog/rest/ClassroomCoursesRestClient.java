package br.com.caelum.mog.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.mog.domains.dtos.CourseDTO;
import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.Platform;
import br.com.caelum.mog.rest.representations.CourseRepresentation;

@Component
public class ClassroomCoursesRestClient implements CoursesRestClient {


    private final String classroomAllCoursesURL;
    private final String classroomSingleCourseURL;
    private final RestTemplate restTemplate;

    public ClassroomCoursesRestClient(@Value("${mog.classroom.all-courses.url}") String classroomAllCoursesURL,
                                      @Value("${mog.classroom.single-courses.url}") String classroomSingleCourseURL,
                                      RestTemplate restTemplate) {
        this.classroomAllCoursesURL = classroomAllCoursesURL;
        this.classroomSingleCourseURL = classroomSingleCourseURL;
        this.restTemplate = restTemplate;
    }

    @Override
    public Course getCourseByCode(String code) {
        return restTemplate.getForObject(classroomSingleCourseURL, Course.class, code);
    }

    public List<CourseDTO> getAllSimplesCourse() {
        CourseRepresentation[] courses = restTemplate.getForObject(classroomAllCoursesURL, CourseRepresentation[].class);

        return Stream.of(courses).map(this::toClassroomCourseDTO).collect(Collectors.toList());
    }

    private CourseDTO toClassroomCourseDTO(CourseRepresentation representation) {
        return representation.toCourseDTO(Platform.CLASSROOM);
    }
}
