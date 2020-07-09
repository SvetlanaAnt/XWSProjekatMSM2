//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.08 at 03:37:03 PM CEST 
//


package services.app.carrequestservice.model;

import agent.app.converter.DateAPI;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.w3._2001.xmlschema.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="review" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="distanceLimitFlag" type="{http://www.app.services/carrequestservice/model}DistanceLimitEnum"/&gt;
 *         &lt;element name="distanceLimit" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="cdw" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="pricePerDay" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="pricePerKm" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="pricePerKmCDW" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="report" type="{http://www.app.services/carrequestservice/model}Report"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ad", propOrder = {
        "id",
        "adName",
        "mainId",
        "review",
        "startDate",
        "endDate",
        "distanceLimitFlag",
        "distanceLimit",
        "cdw",
        "pricePerDay",
        "pricePerKm",
        "pricePerKmCDW",
        "token",
        "report"
})
public class Ad {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5.class)
    @XmlSchemaType(name = "long")
    protected Long id;
    @XmlElement(required = true)
    protected String adName;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter5.class)
    @XmlSchemaType(name = "long")
    protected Long mainId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter6.class)
    @XmlSchemaType(name = "int")
    protected Integer review;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4.class)
    @XmlSchemaType(name = "dateTime")
    protected DateTime startDate;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4.class)
    @XmlSchemaType(name = "dateTime")
    protected DateTime endDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DistanceLimitEnum distanceLimitFlag;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2.class)
    @XmlSchemaType(name = "float")
    protected Float distanceLimit;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1.class)
    @XmlSchemaType(name = "boolean")
    protected Boolean cdw;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2.class)
    @XmlSchemaType(name = "float")
    protected Float pricePerDay;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2.class)
    @XmlSchemaType(name = "float")
    protected Float pricePerKm;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2.class)
    @XmlSchemaType(name = "float")
    protected Float pricePerKmCDW;
    @XmlElement(required = true)
    protected String token;
    @XmlElement(required = true)
    protected Report report;

    @JsonProperty("startDate")
    public String getTheStartDate() {
        return DateAPI.DateTimeToStringDateTime(startDate);
    }

    @JsonProperty("endDate")
    public String getTheEndDate() {
        return DateAPI.DateTimeToStringDateTime(endDate);
    }

    @JsonProperty("startDate")
    public void setTheStartDate(String startDate) {
        this.startDate = DateAPI.DateTimeStringToDateTime(startDate);
    }

    @JsonProperty("endDate")
    public void setTheEndDate(String endDate) {
        this.endDate = DateAPI.DateTimeStringToDateTime(endDate);
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the adName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAdName() {
        return adName;
    }

    /**
     * Sets the value of the adName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAdName(String value) {
        this.adName = value;
    }

    /**
     * Gets the value of the mainId property.
     *
     * @return possible object is
     * {@link String }
     */
    public Long getMainId() {
        return mainId;
    }

    /**
     * Sets the value of the mainId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMainId(Long value) {
        this.mainId = value;
    }

    /**
     * Gets the value of the review property.
     *
     * @return possible object is
     * {@link String }
     */
    public Integer getReview() {
        return review;
    }

    /**
     * Sets the value of the review property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReview(Integer value) {
        this.review = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public DateTime getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStartDate(DateTime value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public DateTime getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEndDate(DateTime value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the distanceLimitFlag property.
     *
     * @return possible object is
     * {@link DistanceLimitEnum }
     */
    public DistanceLimitEnum getDistanceLimitFlag() {
        return distanceLimitFlag;
    }

    /**
     * Sets the value of the distanceLimitFlag property.
     *
     * @param value allowed object is
     *              {@link DistanceLimitEnum }
     */
    public void setDistanceLimitFlag(DistanceLimitEnum value) {
        this.distanceLimitFlag = value;
    }

    /**
     * Gets the value of the distanceLimit property.
     *
     * @return possible object is
     * {@link String }
     */
    public Float getDistanceLimit() {
        return distanceLimit;
    }

    /**
     * Sets the value of the distanceLimit property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDistanceLimit(Float value) {
        this.distanceLimit = value;
    }

    /**
     * Gets the value of the cdw property.
     *
     * @return possible object is
     * {@link String }
     */
    public Boolean isCdw() {
        return cdw;
    }

    /**
     * Sets the value of the cdw property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCdw(Boolean value) {
        this.cdw = value;
    }

    /**
     * Gets the value of the pricePerDay property.
     *
     * @return possible object is
     * {@link String }
     */
    public Float getPricePerDay() {
        return pricePerDay;
    }

    /**
     * Sets the value of the pricePerDay property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPricePerDay(Float value) {
        this.pricePerDay = value;
    }

    /**
     * Gets the value of the pricePerKm property.
     *
     * @return possible object is
     * {@link String }
     */
    public Float getPricePerKm() {
        return pricePerKm;
    }

    /**
     * Sets the value of the pricePerKm property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPricePerKm(Float value) {
        this.pricePerKm = value;
    }

    /**
     * Gets the value of the pricePerKmCDW property.
     *
     * @return possible object is
     * {@link String }
     */
    public Float getPricePerKmCDW() {
        return pricePerKmCDW;
    }

    /**
     * Sets the value of the pricePerKmCDW property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPricePerKmCDW(Float value) {
        this.pricePerKmCDW = value;
    }

    /**
     * Gets the value of the token property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the report property.
     *
     * @return possible object is
     * {@link Report }
     */
    public Report getReport() {
        return report;
    }

    /**
     * Sets the value of the report property.
     *
     * @param value allowed object is
     *              {@link Report }
     */
    public void setReport(Report value) {
        this.report = value;
    }

}
