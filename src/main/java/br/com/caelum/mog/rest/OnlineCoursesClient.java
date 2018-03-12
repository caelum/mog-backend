package br.com.caelum.mog.rest;

import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.CourseSummaryItem;
import br.com.caelum.mog.domains.models.Platform;

public class OnlineCoursesClient implements CoursesClient {
    @Override
    public Course getCourseByCode(String code) {

        return new Course("docker-e-docker-compose", Platform.ONLINE,
                new CourseSummaryItem("Introdução ao Docker", "introdução", "O problema das máquinas virtuais", "A era dos containers"),
                new CourseSummaryItem("Trabalhando com as imagens", "Comandos básicos com containers", "Layered filesystem", "Praticando com docker run")
        );
    }
}