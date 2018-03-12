package br.com.caelum.mog.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@Component
public class TemplateResolver {


    private final String templatePath;

    public TemplateResolver(@Value("${mog.template.path}") String path) {
        templatePath = path;
    }

    public File getCurrentTemplate() {
        try {
            URI uri = Objects.requireNonNull(getClass().getClassLoader().getResource(templatePath)).toURI();
            return new File(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Can't resolve template file" );
        }
    }
}
