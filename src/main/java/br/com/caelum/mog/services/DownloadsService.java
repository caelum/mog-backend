package br.com.caelum.mog.services;

import br.com.caelum.mog.adapters.Downloadable;
import br.com.caelum.mog.exceptions.OfferODTException;
import br.com.caelum.mog.repositories.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class DownloadsService {

    private final OfferRepository repository;
    private final OffersService service;

    public DownloadsService(OfferRepository repository, OffersService service) {
        this.repository = repository;
        this.service = service;
    }

    public Downloadable getDowloadableOfferById(String id) {

        return repository
                            .findById(id)
                                .map(service::toODT)
                                    .orElseThrow(OfferODTException::new);
    }
}
