package br.com.caelum.mog.rest;

import br.com.caelum.mog.domains.dtos.CourseDTO;
import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.CourseSummaryItem;
import br.com.caelum.mog.domains.models.Platform;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OnlineCoursesRestClient implements CoursesRestClient {
    @Override
    public Course getCourseByCode(String code) {

        return new Course("Docker: Criando containers sem dor de cabeça", "docker-e-docker-compose", Platform.ONLINE,
                new CourseSummaryItem("Introdução ao Docker", "introdução", "O problema das máquinas virtuais", "A era dos containers"),
                new CourseSummaryItem("Trabalhando com as imagens", "Comandos básicos com containers", "Layered filesystem", "Praticando com docker run")
        );
    }

    @Override
    public List<CourseDTO> getAllSimplesCourse() {
        return List.of("docker-e-docker-compose")
                .stream()
                .map(code -> new CourseDTO("Docker: Criando containers sem dor de cabeça", code, Platform.ONLINE))
                .collect(Collectors.toList());
    }
}