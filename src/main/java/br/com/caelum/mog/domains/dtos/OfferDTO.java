package br.com.caelum.mog.domains.dtos;

import br.com.caelum.mog.domains.models.Course;
import br.com.caelum.mog.domains.models.Customer;
import br.com.caelum.mog.domains.models.Offer;
import br.com.caelum.mog.domains.models.CaelumInfo;
import br.com.caelum.mog.domains.models.Responsible;
import br.com.caelum.mog.enums.CaelumDistrict;
import br.com.caelum.mog.services.CoursesService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notEmpty;

public class OfferDTO {

    private String commercialName;
    private String responsibleName;
    private String caelumDistrict;
    private List<CourseDTO> courses = new ArrayList<>();

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private OfferDTO() { }

    public OfferDTO(String commercialName, String responsibleName, String caelumDistrict, CourseDTO... courses) {
        hasText(commercialName, "Commercial name required");
        notEmpty(courses, "At least one course must be informed");
        hasText(responsibleName, "Responsible name required");
        hasText(caelumDistrict, "Caelum District required");

        this.commercialName = commercialName;
        this.courses = List.of(courses);
        this.responsibleName = responsibleName;
        this.caelumDistrict = caelumDistrict;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public String getCaelumDistrict() {
        return caelumDistrict;
    }

    public Offer toOffer(CoursesService service) {

        List<Course> mappedCourses = this.courses.stream().map(dto -> dto.toCourse(service)).collect(Collectors.toList());

        Customer customer = new Customer(commercialName);

        Responsible responsible = new Responsible(responsibleName);

        CaelumDistrict district = CaelumDistrict.valueOf(caelumDistrict);
        CaelumInfo caelumInfo = new CaelumInfo(district);

        return new Offer(customer, mappedCourses, LocalDate.now(), responsible, caelumInfo);
    }
}
