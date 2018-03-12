package br.com.caelum.mog.services;

import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.Platform;
import org.springframework.stereotype.Service;

@Service
public class CoursesService {

    public Course getCourseByCodeAndPlatform(String code, Platform platform) {
        return platform.getCourseByCode(code);
    }

}
