//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.11 at 12:19:20 AM CEST 
//


package services.app.adservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Builder;
import org.w3._2001.xmlschema.Adapter2;
import org.w3._2001.xmlschema.Adapter5;


/**
 * <p>Java class for AdSync complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdSync"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="coverPhoto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ratingNum" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="ratingCnt" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="rentCnt" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="pricePerDay" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="publishedDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="priceList" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="discountList" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="carCalendarTermSyncDTOList" type="{http://www.app.services/adservice/model}CarCalendarTermSync" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="images" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="carSyncDTO" type="{http://www.app.services/adservice/model}CarSync"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdSync", propOrder = {
    "email",
    "name",
    "location",
    "coverPhoto",
    "ratingNum",
    "ratingCnt",
    "rentCnt",
    "pricePerDay",
    "publishedDate",
    "priceList",
    "discountList",
    "carCalendarTermSyncDTOList",
    "images",
    "carSyncDTO"
})
public class AdSync {

    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String location;
    @XmlElement(required = true)
    protected String coverPhoto;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long ratingNum;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long ratingCnt;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long rentCnt;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "float")
    protected Float pricePerDay;
    @XmlElement(required = true)
    protected String publishedDate;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long priceList;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected List<Long> discountList;
    protected List<CarCalendarTermSync> carCalendarTermSyncDTOList;
    protected List<String> images;
    @XmlElement(required = true)
    protected CarSync carSyncDTO;

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the coverPhoto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverPhoto() {
        return coverPhoto;
    }

    /**
     * Sets the value of the coverPhoto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverPhoto(String value) {
        this.coverPhoto = value;
    }

    /**
     * Gets the value of the ratingNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getRatingNum() {
        return ratingNum;
    }

    /**
     * Sets the value of the ratingNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatingNum(Long value) {
        this.ratingNum = value;
    }

    /**
     * Gets the value of the ratingCnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getRatingCnt() {
        return ratingCnt;
    }

    /**
     * Sets the value of the ratingCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatingCnt(Long value) {
        this.ratingCnt = value;
    }

    /**
     * Gets the value of the rentCnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getRentCnt() {
        return rentCnt;
    }

    /**
     * Sets the value of the rentCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRentCnt(Long value) {
        this.rentCnt = value;
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
     * Gets the value of the publishedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * Sets the value of the publishedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishedDate(String value) {
        this.publishedDate = value;
    }

    /**
     * Gets the value of the priceList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getPriceList() {
        return priceList;
    }

    /**
     * Sets the value of the priceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceList(Long value) {
        this.priceList = value;
    }

    /**
     * Gets the value of the discountList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the discountList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiscountList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<Long> getDiscountList() {
        if (discountList == null) {
            discountList = new ArrayList<Long>();
        }
        return this.discountList;
    }

    /**
     * Gets the value of the carCalendarTermSyncDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the carCalendarTermSyncDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCarCalendarTermSyncDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CarCalendarTermSync }
     * 
     * 
     */
    public List<CarCalendarTermSync> getCarCalendarTermSyncDTOList() {
        if (carCalendarTermSyncDTOList == null) {
            carCalendarTermSyncDTOList = new ArrayList<CarCalendarTermSync>();
        }
        return this.carCalendarTermSyncDTOList;
    }

    /**
     * Gets the value of the images property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the images property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getImages() {
        if (images == null) {
            images = new ArrayList<String>();
        }
        return this.images;
    }

    /**
     * Gets the value of the carSyncDTO property.
     * 
     * @return
     *     possible object is
     *     {@link CarSync }
     *     
     */
    public CarSync getCarSyncDTO() {
        return carSyncDTO;
    }

    /**
     * Sets the value of the carSyncDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarSync }
     *     
     */
    public void setCarSyncDTO(CarSync value) {
        this.carSyncDTO = value;
    }

}