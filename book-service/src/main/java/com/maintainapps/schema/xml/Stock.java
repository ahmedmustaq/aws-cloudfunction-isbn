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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}LocationIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}LocationName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}StockQuantityCoded" maxOccurs="unbounded"/>
 *           &lt;sequence>
 *             &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}OnHand"/>
 *             &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Proximity" minOccurs="0"/>
 *             &lt;sequence minOccurs="0">
 *               &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Reserved"/>
 *               &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Proximity" minOccurs="0"/>
 *             &lt;/sequence>
 *             &lt;sequence minOccurs="0">
 *               &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}OnOrder"/>
 *               &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Proximity" minOccurs="0"/>
 *             &lt;/sequence>
 *             &lt;sequence minOccurs="0">
 *               &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}CBO"/>
 *               &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Proximity" minOccurs="0"/>
 *             &lt;/sequence>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}OnOrderDetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Velocity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ns.editeur.org/onix/3.0/reference}generalAttributes"/>
 *       &lt;attribute name="refname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="Stock"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="shortname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="stock"/>
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
    "content"
})
@XmlRootElement(name = "Stock")
public class Stock {

    @XmlElementRefs({
        @XmlElementRef(name = "CBO", namespace = "http://ns.editeur.org/onix/3.0/reference", type = CBO.class, required = false),
        @XmlElementRef(name = "StockQuantityCoded", namespace = "http://ns.editeur.org/onix/3.0/reference", type = StockQuantityCoded.class, required = false),
        @XmlElementRef(name = "Proximity", namespace = "http://ns.editeur.org/onix/3.0/reference", type = Proximity.class, required = false),
        @XmlElementRef(name = "Reserved", namespace = "http://ns.editeur.org/onix/3.0/reference", type = Reserved.class, required = false),
        @XmlElementRef(name = "LocationName", namespace = "http://ns.editeur.org/onix/3.0/reference", type = LocationName.class, required = false),
        @XmlElementRef(name = "Velocity", namespace = "http://ns.editeur.org/onix/3.0/reference", type = Velocity.class, required = false),
        @XmlElementRef(name = "OnOrder", namespace = "http://ns.editeur.org/onix/3.0/reference", type = OnOrder.class, required = false),
        @XmlElementRef(name = "OnOrderDetail", namespace = "http://ns.editeur.org/onix/3.0/reference", type = OnOrderDetail.class, required = false),
        @XmlElementRef(name = "LocationIdentifier", namespace = "http://ns.editeur.org/onix/3.0/reference", type = LocationIdentifier.class, required = false),
        @XmlElementRef(name = "OnHand", namespace = "http://ns.editeur.org/onix/3.0/reference", type = OnHand.class, required = false)
    })
    protected List<Object> content;
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
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Proximity" is used by two different parts of a schema. See: 
     * line 11782 of file:/C:/Lumine/workspace-spring/book-service/schema/ONIX_BookProduct_3.0_reference.xsd
     * line 11779 of file:/C:/Lumine/workspace-spring/book-service/schema/ONIX_BookProduct_3.0_reference.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CBO }
     * {@link StockQuantityCoded }
     * {@link Proximity }
     * {@link Reserved }
     * {@link LocationName }
     * {@link Velocity }
     * {@link OnOrder }
     * {@link OnOrderDetail }
     * {@link LocationIdentifier }
     * {@link OnHand }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
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
