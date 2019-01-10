package br.com.caelum.mog.domains.models;

import org.springframework.util.Assert;

public class Responsible {
    private String responsibleName;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private Responsible() { }

    public Responsible(String responsibleName) {
        Assert.hasText(responsibleName, "Name required");

        this.responsibleName = responsibleName;
    }

    public String getResponsibleName() {
        return responsibleName;
    }
}
