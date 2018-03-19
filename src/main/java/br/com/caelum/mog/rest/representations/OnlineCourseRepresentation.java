package br.com.caelum.mog.rest.representations;

import br.com.caelum.mog.domains.dtos.CourseDTO;
import br.com.caelum.mog.domains.models.Platform;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OnlineCourseRepresentation implements UnitCourseRepresentation {

    @JsonProperty("slug")
    private String code;

    @JsonProperty("nome")
    private String name;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    public OnlineCourseRepresentation() {}

    public OnlineCourseRepresentation(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public CourseDTO toCourseDTO(){
        return new CourseDTO(name, code, Platform.ONLINE);
    }
}
