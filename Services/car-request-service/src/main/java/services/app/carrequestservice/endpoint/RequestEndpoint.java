package services.app.carrequestservice.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import services.app.carrequestservice.model.*;
import services.app.carrequestservice.service.intf.RequestService;

@Endpoint
public class RequestEndpoint {
    private static final String NAMESPACE_URI = "http://www.app.services/carrequestservice/model";

    private final RequestService requestService;

    public RequestEndpoint(RequestService requestService) {
        this.requestService = requestService;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "acceptRequest")
    @ResponsePayload
    public AcceptResponse acceptRequest(@RequestPayload AcceptRequest request) {
        AcceptResponse acceptResponse = new AcceptResponse();
        Long publisherUser = requestService.authAgent(request.getPublisherUserEmail(), request.getIdentifier());
        if (publisherUser == null) {
            acceptResponse.setMsg("Agent nije registrovan u sistemu");
            return acceptResponse;
        }else{
            acceptResponse.setMsg(requestService.acceptRequest(request.getId(), request.getAction()));
            return acceptResponse;
        }
    }
}
