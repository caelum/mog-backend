package br.com.caelum.mog.rest;

import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.CourseSummaryItem;
import br.com.caelum.mog.domains.models.Platform;

public class ClassroomCoursesClient implements CoursesClient{
    @Override
    public Course getCourseByCode(String code) {

        return new Course("FJ-11", Platform.CLASSROOM,    new CourseSummaryItem("Como aprender java", "O que é realmente importante?", "Sobre os exercícios", "Tirando Dúvida"),
                                                                new CourseSummaryItem("O que é o java", "Java", "Uma breve histório do java", "Maquina virtual"));
    }
}
