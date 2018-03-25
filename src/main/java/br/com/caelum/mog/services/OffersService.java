package br.com.caelum.mog.services;

import br.com.caelum.mog.adapters.Downloadable;
import br.com.caelum.mog.domains.models.Offer;
import br.com.caelum.mog.factories.ODTFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class OffersService {


    private final ODTFactory factory;

    public OffersService(ODTFactory factory) {
        this.factory = factory;
    }

    public Downloadable toODT(Offer offer) {
        Assert.notNull(offer, "Offer required");

        return factory.create(offer);
    }
}
