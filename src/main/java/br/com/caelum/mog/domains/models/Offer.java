package br.com.caelum.mog.domains.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Offer {

    @Id
    private String id;

    private Customer customer;

    private List<Course> courses =  new ArrayList<>();


    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Offer() { }

    public Offer(Customer customer, Course... courses) {
        this(customer,List.of(courses));
    }

    public Offer(Customer customer, List<Course> courses){
        this.customer = customer;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
