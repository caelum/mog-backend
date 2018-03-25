package br.com.caelum.mog.rest.representations;

import br.com.caelum.mog.domains.dtos.CourseDTO;
import br.com.caelum.mog.domains.models.Platform;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

public class CourseRepresentation {

   @JsonProperty("slug")
    private String code;

    @JsonProperty("nome")
    private String name;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private CourseRepresentation() {}

    public CourseRepresentation(String code, String name) {
        Assert.hasText(code, "Code required");
        Assert.hasText(name, "Name required");

        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public CourseDTO toCourseDTO(Platform platform){
        return new CourseDTO(name, code, platform);
    }
}
