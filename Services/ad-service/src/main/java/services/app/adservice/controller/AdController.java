package services.app.adservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import services.app.adservice.dto.ad.AdCreateDTO;
import services.app.adservice.dto.ad.AdRatingDTO;
import services.app.adservice.model.CustomPrincipal;
import services.app.adservice.service.intf.AdService;


@RestController
@RequestMapping(value = "/ad", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdController {

    private final AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAd(@PathVariable("id") Long id) {
        return new ResponseEntity<>(adService.getAdDetailView(id), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_AGENT')")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAd(@RequestBody AdCreateDTO adCreateDTO) {
        System.out.println(adCreateDTO);
        Integer flag = adService.createAd(adCreateDTO);
        if (flag == 1) {
            return new ResponseEntity<>("Oglas uspesno kreiran.", HttpStatus.CREATED);
        } else if (flag == 2) {
            return new ResponseEntity<>("Dozvoljeno je dodati samo 3 oglasa.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Desila se greska.", HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAllPageAd(@RequestParam(value = "nextPage", required = false) Integer nextPage,
                                           @RequestParam(value = "size", required = false) Integer size) {

        if (nextPage != null) {
            return new ResponseEntity<>(adService.findAll(nextPage, size), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(adService.findAll(), HttpStatus.OK);
        }

    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_AGENT')")
    @RequestMapping(value = "/publisher", method = RequestMethod.GET)
    public ResponseEntity<?> findAllPageAdFromPublisher(@RequestParam(value = "nextPage", required = false) Integer nextPage,
                                                        @RequestParam(value = "size", required = false) Integer size) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomPrincipal principal = (CustomPrincipal) auth.getPrincipal();
        return new ResponseEntity<>(adService.findAll(nextPage, size, principal.getUserId()), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/rating", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addRatingToAd(@RequestBody AdRatingDTO adRatingDTO) {

        Integer rez = adService.addRatingToAd(adRatingDTO);
        if (rez == 1) {
            return new ResponseEntity<>("Uspjesno ste ocijenili oglas.", HttpStatus.OK);
        } else if (rez == 2) {
            return new ResponseEntity<>("Vec ste ocijenili oglas.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Desila se nepoznata greska.", HttpStatus.BAD_REQUEST);
        }
    }

}
