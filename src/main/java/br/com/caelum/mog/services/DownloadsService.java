package br.com.caelum.mog.services;

import org.springframework.stereotype.Service;

import br.com.caelum.mog.adapters.Downloadable;
import br.com.caelum.mog.domains.models.Offer;

@Service
public class DownloadsService {

    private final OffersService service;

    public DownloadsService(OffersService service) {
        this.service = service;
    }

    public Downloadable getDowloadableOffer(Offer offer) {
        return service.toODT(offer);
    }
}
