package br.com.caelum.mog.domains.models;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String title;
    private String code;
    private List<CourseSummaryItem> summary = new ArrayList<>();
    private Platform platform;


    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    public Course() { }

    public Course(String title, String code, Platform platform, CourseSummaryItem... items) {
        this.title = title;
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

    public String getTitle() {
        return title;
    }
}
