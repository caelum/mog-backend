package br.com.caelum.mog.domains.models;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;

public class Offer {

    private Customer customer;
    private Responsible responsible;
    private CaelumInfo caelumInfo;
    private List<Course> courses =  new ArrayList<>();
    private LocalDate date;
    private CareOf careOfName;


    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Offer() { }

    public Offer(Customer customer, List<Course> courses, LocalDate date, Responsible responsible, CareOf careOfName, CaelumInfo caelumInfo){
        Assert.notNull(customer, "Customer required");
        Assert.notEmpty(courses, "Courses required");
        Assert.notNull(date, "Date required");

        this.customer = customer;
        this.courses = courses;
        this.date = date;
        this.responsible = responsible;
        this.caelumInfo = caelumInfo;
        this.careOfName = careOfName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public LocalDate getDate() {
        return date;
    }

    public CaelumInfo getCaelumInfo() {
        return caelumInfo;
    }

    public String getFormattedDate(){
        Locale locale = LocaleContextHolder.getLocale();

        int day = date.getDayOfMonth();
        String month = date.getMonth().getDisplayName(TextStyle.FULL, locale);
        int year = date.getYear();

        return String.format(locale, "%s de %s de %s", day, month, year);
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public CareOf getCareOfName() {
		return careOfName;
	}
}
