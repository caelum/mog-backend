package br.com.caelum.mog.domains.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CourseToOffer {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("workhoue")
    private Integer workhour;

    @JsonProperty("price")
    private BigDecimal price;

    @Deprecated
    public CourseToOffer(){}

    public CourseToOffer(Course course) {
        this.name = course.getName();
        this.workhour = course.getWorkload();
        this.price = course.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkhour() {
        return workhour;
    }

    public void setWorkhour(Integer workhour) {
        this.workhour = workhour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
