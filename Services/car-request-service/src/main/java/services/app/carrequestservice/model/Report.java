//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.04 at 11:25:11 PM CEST 
//


package services.app.carrequestservice.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.*;
import org.w3._2001.xmlschema.Adapter2;
import org.w3._2001.xmlschema.Adapter5;
import services.app.carrequestservice.common.db.DbColumnConstants;
import services.app.carrequestservice.common.db.DbTableConstants;


/**
 * <p>Java class for Report complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Report"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="distanceTraveled" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="publisherUser" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="adId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = DbTableConstants.REPORT)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Report", propOrder = {
    "id",
    "description",
    "distanceTraveled",
    "publisherUser",
    "adId"
})
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long id;

    @Column(name = DbColumnConstants.DESCRIPTION)
    protected String description;

    @Column(name = DbColumnConstants.DISTANCETRAVELED, nullable = false)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "float")
    protected Float distanceTraveled;

    @Column(name = DbColumnConstants.PUBLISHERUSER, nullable = false)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long publisherUser;

    @Column(name = DbColumnConstants.ADID, nullable = false)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long adId;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the distanceTraveled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Float getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * Sets the value of the distanceTraveled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistanceTraveled(Float value) {
        this.distanceTraveled = value;
    }

    /**
     * Gets the value of the publisherUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getPublisherUser() {
        return publisherUser;
    }

    /**
     * Sets the value of the publisherUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisherUser(Long value) {
        this.publisherUser = value;
    }

    /**
     * Gets the value of the adId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getAdId() {
        return adId;
    }

    /**
     * Sets the value of the adId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdId(Long value) {
        this.adId = value;
    }

}
