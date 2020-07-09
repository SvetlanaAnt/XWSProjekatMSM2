package services.app.carrequestservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import services.app.carrequestservice.dto.carreq.ReqAcceptDTO;
import services.app.carrequestservice.dto.carreq.SubmitRequestDTO;
import services.app.carrequestservice.model.CustomPrincipal;
import services.app.carrequestservice.service.intf.RequestService;

import java.util.HashMap;

@RestController
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_AGENT')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRequest(@PathVariable("id") Long id) {
        return new ResponseEntity<>(requestService.findById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/end-user", method = RequestMethod.GET)
    public ResponseEntity<?> getEndUserRequests(@RequestHeader(value = "status", required = false) String status) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomPrincipal cp = (CustomPrincipal) auth.getPrincipal();
        if (status == null) {
            return new ResponseEntity<>(requestService.findAllByEndUserId(Long.valueOf(cp.getUserId())), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(requestService.findAllByEndUserIdAndByStatus(Long.valueOf(cp.getUserId()), status), HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/end-user", method = RequestMethod.PUT)
    public ResponseEntity<?> quitRequest(@RequestBody ReqAcceptDTO reqAcceptDTO) {
        if (reqAcceptDTO.getAction().equals("quit")) {
            Integer flag = requestService.quitRequest(reqAcceptDTO.getId());
            if (flag == 1) {
                return new ResponseEntity<>("Uspjesno odustajanje od zahtjeva", HttpStatus.OK);
            } else if (flag == 2) {
                return new ResponseEntity<>("Zahtjev je vec obradjen", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("Desila se nepoznata greska", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Nepoznata akcija", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAuthority('ROLE_AGENT') or hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/publisher-user", method = RequestMethod.GET)
    public ResponseEntity<?> getPublisherUserRequests(@RequestHeader(value = "status", required = false) String status) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomPrincipal cp = (CustomPrincipal) auth.getPrincipal();
        if (status == null) {
            return new ResponseEntity<>(requestService.findAllByPublisherUserId(Long.valueOf(cp.getUserId())), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(requestService.findAllByPublisherUserIdAndByStatus(Long.valueOf(cp.getUserId()), status), HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> submitRequest(@RequestBody HashMap<Long, SubmitRequestDTO> submitRequestDTOS) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomPrincipal cp = (CustomPrincipal) auth.getPrincipal();
        Integer flag = requestService.submitRequest(submitRequestDTOS, Long.valueOf(cp.getUserId()));
        if (flag == 1) {
            return new ResponseEntity<>("Zahtjev uspjesno kreiran.", HttpStatus.OK);
        } else if (flag == 2) {
            return new ResponseEntity<>("Vas nalog je blokiran, imate zabranu rentiranja vozila.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Desila se nepoznata greska", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAuthority('ROLE_AGENT') or hasAuthority('ROLE_USER')")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> acceptRequest(@RequestBody ReqAcceptDTO reqAcceptDTO) {
        if (reqAcceptDTO.getAction() != null && (reqAcceptDTO.getAction().equals("accept") || reqAcceptDTO.getAction().equals("reject"))) {
            String response = requestService.acceptRequest(reqAcceptDTO.getId(), reqAcceptDTO.getAction());
            if (response.equals("Uspjesno odbijen zahtjev") || response.equals("Uspjesno prihvacen zahtjev")) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Nepoznata akcija", HttpStatus.BAD_REQUEST);

        }
    }
}
