package br.com.caelum.mog.domains.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseSummaryItem {
	@JsonProperty("capitulo")
    private String title;
	
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

    @Override
    public String toString() {
        return "CourseSummaryItem{" +
                "title='" + title + '\'' +
                ", contents=" + contents +
                '}';
    }
}
