//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.06 at 09:39:55 PM CEST 
//


package services.app.carrequestservice.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services.app.carrequestservice.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AcceptResponse_QNAME = new QName("http://www.app.services/carrequestservice/model", "acceptResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services.app.carrequestservice.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPublisherRequestsRequest }
     * 
     */
    public GetPublisherRequestsRequest createGetPublisherRequestsRequest() {
        return new GetPublisherRequestsRequest();
    }

    /**
     * Create an instance of {@link GetPublisherRequestsByStatusRequest }
     * 
     */
    public GetPublisherRequestsByStatusRequest createGetPublisherRequestsByStatusRequest() {
        return new GetPublisherRequestsByStatusRequest();
    }

    /**
     * Create an instance of {@link AcceptRequest }
     * 
     */
    public AcceptRequest createAcceptRequest() {
        return new AcceptRequest();
    }

    /**
     * Create an instance of {@link GetPublisherReportsRequest }
     * 
     */
    public GetPublisherReportsRequest createGetPublisherReportsRequest() {
        return new GetPublisherReportsRequest();
    }

    /**
     * Create an instance of {@link GetAdReportsRequest }
     * 
     */
    public GetAdReportsRequest createGetAdReportsRequest() {
        return new GetAdReportsRequest();
    }

    /**
     * Create an instance of {@link GetPublisherRequestsResponse }
     * 
     */
    public GetPublisherRequestsResponse createGetPublisherRequestsResponse() {
        return new GetPublisherRequestsResponse();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link GetPublisherReportsResponse }
     * 
     */
    public GetPublisherReportsResponse createGetPublisherReportsResponse() {
        return new GetPublisherReportsResponse();
    }

    /**
     * Create an instance of {@link Report }
     * 
     */
    public Report createReport() {
        return new Report();
    }

    /**
     * Create an instance of {@link GetAdReportsResponse }
     * 
     */
    public GetAdReportsResponse createGetAdReportsResponse() {
        return new GetAdReportsResponse();
    }

    /**
     * Create an instance of {@link Ad }
     * 
     */
    public Ad createAd() {
        return new Ad();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.app.services/carrequestservice/model", name = "acceptResponse")
    public JAXBElement<String> createAcceptResponse(String value) {
        return new JAXBElement<String>(_AcceptResponse_QNAME, String.class, null, value);
    }

}
