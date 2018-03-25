package br.com.caelum.mog.domains.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Course {

	@JsonProperty("nome")
    private String name;
	
	@JsonProperty("slug")
    private String code;
	
	@JsonProperty("ementa")
    private List<CourseSummaryItem> summary = new ArrayList<>();

	@JsonProperty("carga_horaria")
	private Integer workload;


    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Course() { }

    public Course(String name, String code, Integer workload , CourseSummaryItem... items) {
        this.name = name;
        this.code = code;
        this.workload = workload;
        this.summary = List.of(items);
    }

    public String getCode() {
        return code;
    }

    public List<CourseSummaryItem> getSummary() {
        return summary;
    }

    public String getName() {
        return name;
    }

    public Integer getWorkload() {
        return workload;
    }
}
