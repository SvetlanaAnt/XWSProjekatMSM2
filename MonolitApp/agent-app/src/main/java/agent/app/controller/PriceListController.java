package agent.app.controller;

import agent.app.converter.PriceListConverter;
import agent.app.dto.ad.ReversePricelistDTO;
import agent.app.dto.pricelist.PriceListCreateDTO;
import agent.app.model.CarManufacturer;
import agent.app.model.PriceList;
import agent.app.service.intf.PriceListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/pricelist", produces = MediaType.APPLICATION_JSON_VALUE)
public class PriceListController {

    private final PriceListService priceListService;

    public PriceListController(PriceListService priceListService){
        this.priceListService = priceListService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_AGENT')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAllPriceList() {
        return new ResponseEntity<>(priceListService.findAllListDTO(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_AGENT')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPriceList(@PathVariable("id") Long id) {
        return new ResponseEntity<>(PriceListConverter.toCreatePriceListCreateDTOFromPriceList(priceListService.findById(id)),
                HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_AGENT')")
    @RequestMapping(value = "/publisher", method = RequestMethod.GET)
    public ResponseEntity<?> getPriceListsFromPublishUser(Principal principal) {
        System.out.println("---------------" + principal.getName());
        return new ResponseEntity<>(priceListService.findAllListDTOFromPublisher(principal.getName()), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_AGENT')")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPriceList(@RequestBody PriceListCreateDTO priceListCreateDTO, Principal principal) {
        priceListCreateDTO.setPublisherUsername(principal.getName());
        PriceList priceList = priceListService.createPriceList(priceListCreateDTO);
        return new ResponseEntity<>("Cenovnik uspesno kreiran.", HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_AGENT')")
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editPriceList(@RequestBody PriceListCreateDTO priceListCreateDTO) {
        Integer flag = priceListService.editPriceList(PriceListConverter.toEditPriceListFromRequest(priceListCreateDTO));
        if (flag == 1) {
            return new ResponseEntity<>("Cenovnik uspesno izmenjen.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Desila se nepoznata greska.", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_AGENT')")
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePriceList(@RequestParam(value = "id") Long id, Principal p) {

        Integer flag = priceListService.deleteById(id, p.getName());
        if (flag == 1) {
            return new ResponseEntity<>("Cenovnik uspesno obrisan.", HttpStatus.CREATED);
        }else if(flag == 2){
            return new ResponseEntity<>("Cenovnik se koristi. Ne moze se obrisati.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Desila se nepoznata greska.", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_AGENT')")
    @RequestMapping(value = "/reverse-pricelist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> reversePricelist(@RequestBody ReversePricelistDTO reversePricelistDTO) {

        Integer rez = priceListService.reversePricelist(reversePricelistDTO);
        if (rez == 1) {
            return new ResponseEntity<>("Izmenili ste cenovnik oglasa.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Greska.", HttpStatus.BAD_REQUEST);
    }



}
