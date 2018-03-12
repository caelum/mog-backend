package br.com.caelum.mog.domains.models;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String code;
    private List<CourseSummaryItem> summary = new ArrayList<>();
    private Platform platform;


    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    public Course() { }

    public Course(String code, Platform platform, CourseSummaryItem... items) {
        this.code = code;
        this.summary = List.of(items);
        this.platform = platform;
    }

    public String getCode() {
        return code;
    }

    public List<CourseSummaryItem> getSummary() {
        return summary;
    }

    public Platform getPlatform() {
        return platform;
    }
}
