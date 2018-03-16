package br.com.caelum.mog.domains.dtos;

import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.Platform;
import br.com.caelum.mog.services.CoursesService;

public class CourseDTO {
    private String name;
    private String code;
    private Platform platform;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private CourseDTO() { }

    public CourseDTO(String name, String code, Platform platform) {
        this.name = name;
        this.code = code;
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Platform getPlatform() {
        return platform;
    }

    public Course toCourse(CoursesService service) {
        return service.getCourseByCodeAndPlatform(code, platform);
    }
}
