package br.com.caelum.mog.domains.models;

import org.springframework.util.Assert;

public class Customer {
    private String commercialName;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Customer() { }

    public Customer(String commercialName) {
        Assert.hasText(commercialName, "Commercial name required");

        this.commercialName = commercialName;
    }

    public String getCommercialName() {
        return commercialName;
    }

}
