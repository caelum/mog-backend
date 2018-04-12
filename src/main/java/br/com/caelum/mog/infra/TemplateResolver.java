package br.com.caelum.mog.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@Component
@Scope("singleton")
public class TemplateResolver {


    private final String templatePath;

    public TemplateResolver(@Value("${mog.template.path}") String path) {
        templatePath = path;
    }

    public InputStream getCurrentTemplate() {
        try {
            ClassPathResource classPathResource = new ClassPathResource(templatePath);

            return classPathResource.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException("Can't resolve template file", e);
        }
    }
}
