package br.com.caelum.mog.domains.models;

public class Customer {
    private String commercialName;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Customer() { }

    public Customer(String commercialName) {
        this.commercialName = commercialName;
    }

    public String getCommercialName() {
        return commercialName;
    }

}
