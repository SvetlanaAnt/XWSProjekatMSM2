//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.10 at 03:48:42 PM CEST 
//


package services.app.pricelistanddiscountservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joda.time.DateTime;
import org.w3._2001.xmlschema.Adapter2;
import org.w3._2001.xmlschema.Adapter4;
import org.w3._2001.xmlschema.Adapter5;


/**
 * <p>Java class for PriceList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="pricePerDay" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="pricePerKm" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="pricePerKmCDW" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="publisherUser" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceList", propOrder = {
    "id",
    "creationDate",
    "pricePerDay",
    "pricePerKm",
    "pricePerKmCDW",
    "publisherUser"
})
public class PriceList {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long id;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "dateTime")
    protected DateTime creationDate;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "float")
    protected Float pricePerDay;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "float")
    protected Float pricePerKm;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "float")
    protected Float pricePerKmCDW;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long publisherUser;

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
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(DateTime value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the pricePerDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Float getPricePerDay() {
        return pricePerDay;
    }

    /**
     * Sets the value of the pricePerDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricePerDay(Float value) {
        this.pricePerDay = value;
    }

    /**
     * Gets the value of the pricePerKm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Float getPricePerKm() {
        return pricePerKm;
    }

    /**
     * Sets the value of the pricePerKm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricePerKm(Float value) {
        this.pricePerKm = value;
    }

    /**
     * Gets the value of the pricePerKmCDW property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Float getPricePerKmCDW() {
        return pricePerKmCDW;
    }

    /**
     * Sets the value of the pricePerKmCDW property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricePerKmCDW(Float value) {
        this.pricePerKmCDW = value;
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

}
