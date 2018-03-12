package br.com.caelum.mog.domains.models;

public class Customer {
    private String commercialName;
    private String businessName;
    private String cnpj;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Customer() { }

    public Customer(String commercialName, String businessName, String cnpj) {
        this.commercialName = commercialName;
        this.businessName = businessName;
        this.cnpj = cnpj;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getCnpj() {
        return cnpj;
    }
}
