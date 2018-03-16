package br.com.caelum.mog.rest;

import br.com.caelum.mog.domains.dtos.CourseDTO;
import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.CourseSummaryItem;
import br.com.caelum.mog.domains.models.Platform;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClassroomCoursesRestClient implements CoursesRestClient {
    @Override
    public Course getCourseByCode(String code) {

        return new Course("Java e orientação a objetos","FJ-11", Platform.CLASSROOM,
                                        new CourseSummaryItem("Como aprender java", "O que é realmente importante?", "Sobre os exercícios", "Tirando Dúvida"),
                                        new CourseSummaryItem("O que é o java", "Java", "Uma breve histório do java", "Maquina virtual"));
    }

    public List<CourseDTO> getAllSimplesCourse() {
        return List.of("FJ-21").stream()
                .map(code -> new CourseDTO("Java e orientação a objetos", code, Platform.CLASSROOM))
                .collect(Collectors.toList());
    }
}
