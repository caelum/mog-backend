package br.com.caelum.mog.controllers;


import br.com.caelum.mog.services.DownloadsService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("downloads")
public class DownloadsController {


    private final DownloadsService service;

    public DownloadsController(DownloadsService service) {
        this.service = service;
    }

    @GetMapping("offer/{id}")
    public HttpEntity<?> offerDownload(@PathVariable String id){
        return service.getDowloadableOfferById(id);
    }

}
