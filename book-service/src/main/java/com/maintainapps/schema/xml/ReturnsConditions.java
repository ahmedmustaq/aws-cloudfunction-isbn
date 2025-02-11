//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.07.26 at 02:03:50 PM GST 
//


package com.maintainapps.schema.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}ReturnsCodeType"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}ReturnsCodeTypeName" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}ReturnsCode"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}ReturnsNote" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ns.editeur.org/onix/3.0/reference}generalAttributes"/>
 *       &lt;attribute name="refname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="ReturnsConditions"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="shortname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="returnsconditions"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "returnsCodeType",
    "returnsCodeTypeName",
    "returnsCode",
    "returnsNote"
})
@XmlRootElement(name = "ReturnsConditions")
public class ReturnsConditions {

    @XmlElement(name = "ReturnsCodeType", required = true)
    protected ReturnsCodeType returnsCodeType;
    @XmlElement(name = "ReturnsCodeTypeName")
    protected ReturnsCodeTypeName returnsCodeTypeName;
    @XmlElement(name = "ReturnsCode", required = true)
    protected ReturnsCode returnsCode;
    @XmlElement(name = "ReturnsNote")
    protected List<ReturnsNote> returnsNote;
    @XmlAttribute(name = "refname")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String refname;
    @XmlAttribute(name = "shortname")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String shortname;
    @XmlAttribute(name = "datestamp")
    protected String datestamp;
    @XmlAttribute(name = "sourcetype")
    protected String sourcetype;
    @XmlAttribute(name = "sourcename")
    protected String sourcename;

    /**
     * Gets the value of the returnsCodeType property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnsCodeType }
     *     
     */
    public ReturnsCodeType getReturnsCodeType() {
        return returnsCodeType;
    }

    /**
     * Sets the value of the returnsCodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnsCodeType }
     *     
     */
    public void setReturnsCodeType(ReturnsCodeType value) {
        this.returnsCodeType = value;
    }

    /**
     * Gets the value of the returnsCodeTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnsCodeTypeName }
     *     
     */
    public ReturnsCodeTypeName getReturnsCodeTypeName() {
        return returnsCodeTypeName;
    }

    /**
     * Sets the value of the returnsCodeTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnsCodeTypeName }
     *     
     */
    public void setReturnsCodeTypeName(ReturnsCodeTypeName value) {
        this.returnsCodeTypeName = value;
    }

    /**
     * Gets the value of the returnsCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnsCode }
     *     
     */
    public ReturnsCode getReturnsCode() {
        return returnsCode;
    }

    /**
     * Sets the value of the returnsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnsCode }
     *     
     */
    public void setReturnsCode(ReturnsCode value) {
        this.returnsCode = value;
    }

    /**
     * Gets the value of the returnsNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the returnsNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturnsNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReturnsNote }
     * 
     * 
     */
    public List<ReturnsNote> getReturnsNote() {
        if (returnsNote == null) {
            returnsNote = new ArrayList<ReturnsNote>();
        }
        return this.returnsNote;
    }

    /**
     * Gets the value of the refname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefname() {
        return refname;
    }

    /**
     * Sets the value of the refname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefname(String value) {
        this.refname = value;
    }

    /**
     * Gets the value of the shortname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * Sets the value of the shortname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortname(String value) {
        this.shortname = value;
    }

    /**
     * Gets the value of the datestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatestamp() {
        return datestamp;
    }

    /**
     * Sets the value of the datestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatestamp(String value) {
        this.datestamp = value;
    }

    /**
     * Gets the value of the sourcetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourcetype() {
        return sourcetype;
    }

    /**
     * Sets the value of the sourcetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourcetype(String value) {
        this.sourcetype = value;
    }

    /**
     * Gets the value of the sourcename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourcename() {
        return sourcename;
    }

    /**
     * Sets the value of the sourcename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourcename(String value) {
        this.sourcename = value;
    }

}
