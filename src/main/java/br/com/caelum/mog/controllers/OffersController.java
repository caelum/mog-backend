package br.com.caelum.mog.controllers;

import br.com.caelum.mog.domains.dtos.OfferDTO;
import br.com.caelum.mog.domains.models.Offer;
import br.com.caelum.mog.repositories.OfferRepository;
import br.com.caelum.mog.services.CoursesService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("offers")
public class OffersController {

    private final OfferRepository repository;
    private CoursesService courseService;

    public OffersController(OfferRepository repository, CoursesService courseService) {
        this.repository = repository;
        this.courseService = courseService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> save(@RequestBody OfferDTO dto){
        Offer offer = dto.toOffer(courseService);

        repository.save(offer);

        URI uri = URI.create("/offers/" + offer.getId());

        return ResponseEntity.created(uri).body(offer);
    }

}
