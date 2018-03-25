package br.com.caelum.mog.rest;

import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.CourseSummaryItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OnlineCoursesRestClientTest {

    @Autowired
    private OnlineCoursesRestClient client;


    @Test
    void shouldGetSingleCourseWithCodeSpringboot(){
        Course course = client.getCourseByCode("springboot");
        Integer expectedWorkload = 10;
        List<CourseSummaryItem> summary = course.getSummary();


        assertAll(
                () -> assertEquals("springboot", course.getCode()),
                () -> assertEquals("Spring Boot: Agilidade no desenvolvimento java com Spring", course.getName()),
                () -> assertEquals(expectedWorkload, course.getWorkload()),
                () -> assertEquals(5, summary.size()),
                () -> assertEquals("Criando nossa primeira aplicação com o Spring Boot", summary.get(0).getTitle()),
                () -> assertEquals(4, summary.get(0).getContents().size()),
                () -> assertEquals("Criar nossa aplicação Maven com Spring", summary.get(0).getContents().get(0)),
                () -> assertEquals("Spring Starter Web", summary.get(0).getContents().get(1)),
                () -> assertEquals("Configurando nossa aplicação com uso das anotações", summary.get(0).getContents().get(2)),
                () -> assertEquals("Subindo nossa aplicação web através de um método main", summary.get(0).getContents().get(3))

        );
    }
}