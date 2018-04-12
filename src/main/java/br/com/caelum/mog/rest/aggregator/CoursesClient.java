package br.com.caelum.mog.rest.aggregator;

import br.com.caelum.mog.domains.dtos.CourseDTO;
import br.com.caelum.mog.repositories.CoursesRepository;
import br.com.caelum.mog.rest.ClassroomCoursesRestClient;
import br.com.caelum.mog.rest.OnlineCoursesRestClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CoursesClient implements CoursesRepository {


    private final ClassroomCoursesRestClient classroomClient;
    private final OnlineCoursesRestClient onlineClient;

    public CoursesClient(ClassroomCoursesRestClient classroomClient, OnlineCoursesRestClient onlineClient) {
        this.classroomClient = classroomClient;
        this.onlineClient = onlineClient;
    }

    @Override
    @Cacheable("courses")
    public Iterable<CourseDTO> findAll() {
        List<CourseDTO> classroomCourses = classroomClient.getAllSimplesCourse();
        List<CourseDTO> onlineCourses = onlineClient.getAllSimplesCourse();

        return Stream.concat( classroomCourses.stream(), onlineCourses.stream() ).collect(Collectors.toList());
    }
}
