package br.com.caelum.mog.domains.dtos;

import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.Customer;
import br.com.caelum.mog.domains.models.Offer;
import br.com.caelum.mog.services.CoursesService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfferDTO {

    private String commercialName;
    private List<CourseDTO> courses = new ArrayList<>();

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private OfferDTO() { }

    public OfferDTO(String commercialName, CourseDTO... courses) {
        this.commercialName = commercialName;
        this.courses = List.of(courses);
    }

    public String getCommercialName() {
        return commercialName;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public Offer toOffer(CoursesService service) {

        List<Course> mappedCourses = this.courses.stream().map(dto -> dto.toCourse(service)).collect(Collectors.toList());

        Customer customer = new Customer(commercialName);

        return new Offer(customer, mappedCourses, LocalDate.now());
    }
}
