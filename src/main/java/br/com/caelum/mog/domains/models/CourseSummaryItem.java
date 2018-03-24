package br.com.caelum.mog.domains.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CourseSummaryItem {
	@JsonProperty(value = "capitulo")
    private String title = "Avisar O Teteu para mudar o nome da property 'nome'->'capitulo'";
	
	@JsonProperty("secoes")
    private List<String> contents = new ArrayList<>();

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private CourseSummaryItem() { }

    public CourseSummaryItem(String title, String... contents) {
        this.title = title;
        this.contents = List.of(contents);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getContents() {
        return contents;
    }

}
