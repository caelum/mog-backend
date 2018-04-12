package br.com.caelum.mog.domains.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class CourseSummaryItem {
	@JsonProperty(value = "capitulo")
    private String title;
	
	@JsonProperty("secoes")
    private List<String> contents = new ArrayList<>();

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private CourseSummaryItem() { }

    public CourseSummaryItem(String title, String... contents) {
        Assert.hasText(title, "Title required");
        Assert.notEmpty(contents, "Content required");
        Assert.noNullElements(contents, "Content required");
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
