package br.com.caelum.mog.domains.models;

import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Offer {
    private String id;

    private Customer customer;

    private List<Course> courses =  new ArrayList<>();
    private LocalDate date;


    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Offer() { }

    public Offer(Customer customer, List<Course> courses, LocalDate date){
        this.customer = customer;
        this.courses = courses;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public String getFormattedDate(){
        Locale locale = LocaleContextHolder.getLocale();

        int day = date.getDayOfMonth();
        String month = date.getMonth().getDisplayName(TextStyle.FULL, locale);
        int year = date.getYear();

        return String.format(locale, "%s de %s de %s", day, month, year);
    }
}
