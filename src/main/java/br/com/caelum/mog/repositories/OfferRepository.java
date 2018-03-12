package br.com.caelum.mog.repositories;

import br.com.caelum.mog.domains.models.Offer;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface OfferRepository extends Repository<Offer, String> {
    Optional<Offer> findById(String id);

    void save(Offer offer);
}
