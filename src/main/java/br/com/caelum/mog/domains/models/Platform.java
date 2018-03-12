package br.com.caelum.mog.domains.models;

import br.com.caelum.mog.rest.ClassroomCoursesClient;
import br.com.caelum.mog.rest.CoursesClient;
import br.com.caelum.mog.rest.OnlineCoursesClient;

public enum Platform {
    CLASSROOM(new ClassroomCoursesClient(), "Presencial"),
    ONLINE(new OnlineCoursesClient(), "Online");


    private final CoursesClient client;
    private String description;

    Platform(CoursesClient client, String description){
        this.client = client;
        this.description = description;
    }

    public Course getCourseByCode(String code) {
        return client.getCourseByCode(code);
    }

    public String getDescription(){
        return description;
    }
}