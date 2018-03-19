package br.com.caelum.mog.domains.models;

public enum Platform {
    CLASSROOM("Presencial"),
    ONLINE("Online");

    private String description;

    Platform(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }
}