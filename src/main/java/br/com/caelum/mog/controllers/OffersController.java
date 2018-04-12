package br.com.caelum.mog.controllers;

import br.com.caelum.mog.adapters.Downloadable;
import br.com.caelum.mog.domains.dtos.OfferDTO;
import br.com.caelum.mog.domains.models.Offer;
import br.com.caelum.mog.services.CoursesService;
import br.com.caelum.mog.services.DownloadsService;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("offers")
public class OffersController {

    private CoursesService courseService;
    private final DownloadsService downloadsService;

    public OffersController(CoursesService courseService, DownloadsService downloadsService) {
        this.courseService = courseService;
        this.downloadsService = downloadsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Callable<Downloadable> save(@RequestBody OfferDTO dto){
        return () -> {
            Offer offer = dto.toOffer(courseService);
            return downloadsService.getDowloadableOffer(offer);
        };
    }

}
