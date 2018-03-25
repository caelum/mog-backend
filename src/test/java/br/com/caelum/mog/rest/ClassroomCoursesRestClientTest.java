package br.com.caelum.mog.rest;

import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.CourseSummaryItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ClassroomCoursesRestClientTest {

    @Autowired
    private ClassroomCoursesRestClient client;



    @Test
    void  shouldGetSingleCourseWithCodeFJ_11(){

        Course course = client.getCourseByCode("FJ-11");
        Integer expectedWorkload = 40;
        List<CourseSummaryItem> summary = course.getSummary();


        assertAll(
                () -> assertEquals("FJ-11", course.getCode()),
                () -> assertEquals("Java e Orientação a Objetos", course.getName()),
                () -> assertEquals(expectedWorkload, course.getWorkload()),
                () -> assertEquals(22, summary.size()),
                () -> assertEquals("Como Aprender Java", summary.get(0).getTitle()),
                () -> assertEquals(3, summary.get(0).getContents().size()),
                () -> assertEquals("O que é realmente importante?", summary.get(0).getContents().get(0)),
                () -> assertEquals("Sobre os exercícios", summary.get(0).getContents().get(1)),
                () -> assertEquals("Tirando dúvidas e indo além", summary.get(0).getContents().get(2))

        );

    }


}
