//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.06 at 11:25:37 PM CEST 
//


package services.app.carrequestservice.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.w3._2001.xmlschema.Adapter1;
import org.w3._2001.xmlschema.Adapter2;
import org.w3._2001.xmlschema.Adapter4;
import org.w3._2001.xmlschema.Adapter5;
import services.app.carrequestservice.common.db.DbColumnConstants;
import services.app.carrequestservice.common.db.DbTableConstants;
import services.app.carrequestservice.converter.DateAPI;


/**
 * <p>Java class for Ad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ad"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="adName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mainId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="rated" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="distanceLimitFlag" type="{http://www.app.services/carrequestservice/model}DistanceLimitEnum"/&gt;
 *         &lt;element name="distanceLimit" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="cdw" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="pricePerDay" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="pricePerKm" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="pricePerKmCDW" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = DbTableConstants.AD)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ad", propOrder = {
    "id",
    "adName",
    "mainId",
    "rated",
    "startDate",
    "endDate",
    "distanceLimitFlag",
    "distanceLimit",
    "cdw",
    "pricePerDay",
    "pricePerKm",
    "pricePerKmCDW",
    "token"
})
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long id;

    @Column(name = DbColumnConstants.ADNAME, nullable = false)
    @XmlElement(required = true)
    protected String adName;

    @Column(name = DbColumnConstants.MAINID, nullable = false)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5 .class)
    @XmlSchemaType(name = "long")
    protected Long mainId;

    @Column(name = DbColumnConstants.RATED, nullable = false)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "boolean")
    protected Boolean rated;

    @Temporal(TemporalType.DATE)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
            @org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
            @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")
    })
    @Column(name = DbColumnConstants.STARTDATE, nullable = false)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "dateTime")
    protected DateTime startDate;

    @Temporal(TemporalType.DATE)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
            @org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
            @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")
    })
    @Column(name = DbColumnConstants.ENDDATE, nullable = false)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "dateTime")
    protected DateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = DbColumnConstants.DISTANCELIMITFLAG, nullable = false)
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DistanceLimitEnum distanceLimitFlag;

    @Column(name = DbColumnConstants.DISTANCELIMIT)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "float")
    protected Float distanceLimit;

    @Column(name = DbColumnConstants.CDW, nullable = false)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "boolean")
    protected Boolean cdw;

    @Column(name = DbColumnConstants.PRICEPERDAY, nullable = false)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "float")
    protected Float pricePerDay;

    @Column(name = DbColumnConstants.PRICEPERKM)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "float")
    protected Float pricePerKm;

    @Column(name = DbColumnConstants.PRICEPERCWD)
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "float")
    protected Float pricePerKmCDW;

    @Column(name = DbColumnConstants.TOKEN)
    @XmlElement(required = true)
    protected String token;

    @JsonProperty("startDate")
    public String getTheStartDate() {
        return DateAPI.DateTimeToStringDateTime(startDate);
    }

    @JsonProperty("endDate")
    public String getTheEndDate() {
        return DateAPI.DateTimeToStringDateTime(endDate);
    }

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
     * Gets the value of the adName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdName() {
        return adName;
    }

    /**
     * Sets the value of the adName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdName(String value) {
        this.adName = value;
    }

    /**
     * Gets the value of the mainId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getMainId() {
        return mainId;
    }

    /**
     * Sets the value of the mainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainId(Long value) {
        this.mainId = value;
    }

    /**
     * Gets the value of the rated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean isRated() {
        return rated;
    }

    /**
     * Sets the value of the rated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRated(Boolean value) {
        this.rated = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DateTime getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(DateTime value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DateTime getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(DateTime value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the distanceLimitFlag property.
     * 
     * @return
     *     possible object is
     *     {@link DistanceLimitEnum }
     *     
     */
    public DistanceLimitEnum getDistanceLimitFlag() {
        return distanceLimitFlag;
    }

    /**
     * Sets the value of the distanceLimitFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistanceLimitEnum }
     *     
     */
    public void setDistanceLimitFlag(DistanceLimitEnum value) {
        this.distanceLimitFlag = value;
    }

    /**
     * Gets the value of the distanceLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Float getDistanceLimit() {
        return distanceLimit;
    }

    /**
     * Sets the value of the distanceLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistanceLimit(Float value) {
        this.distanceLimit = value;
    }

    /**
     * Gets the value of the cdw property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean isCdw() {
        return cdw;
    }

    /**
     * Sets the value of the cdw property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdw(Boolean value) {
        this.cdw = value;
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
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

}
