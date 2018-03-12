package br.com.caelum.mog.domains.models;

import br.com.caelum.mog.rest.ClassroomCoursesRestClient;
import br.com.caelum.mog.rest.CoursesRestClient;
import br.com.caelum.mog.rest.OnlineCoursesRestClient;

public enum Platform {
    CLASSROOM(new ClassroomCoursesRestClient(), "Presencial"),
    ONLINE(new OnlineCoursesRestClient(), "Online");


    private final CoursesRestClient client;
    private String description;

    Platform(CoursesRestClient client, String description){
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