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
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}ResourceFileFeatureType"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}ResourceFileFeatureValue" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}ResourceFileFeatureDescription" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ns.editeur.org/onix/3.0/reference}generalAttributes"/>
 *       &lt;attribute name="refname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="ResourceFileFeature"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="shortname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="resourcefilefeature"/>
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
    "resourceFileFeatureType",
    "resourceFileFeatureValue",
    "resourceFileFeatureDescription"
})
@XmlRootElement(name = "ResourceFileFeature")
public class ResourceFileFeature {

    @XmlElement(name = "ResourceFileFeatureType", required = true)
    protected ResourceFileFeatureType resourceFileFeatureType;
    @XmlElement(name = "ResourceFileFeatureValue")
    protected ResourceFileFeatureValue resourceFileFeatureValue;
    @XmlElement(name = "ResourceFileFeatureDescription")
    protected List<ResourceFileFeatureDescription> resourceFileFeatureDescription;
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
     * Gets the value of the resourceFileFeatureType property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceFileFeatureType }
     *     
     */
    public ResourceFileFeatureType getResourceFileFeatureType() {
        return resourceFileFeatureType;
    }

    /**
     * Sets the value of the resourceFileFeatureType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceFileFeatureType }
     *     
     */
    public void setResourceFileFeatureType(ResourceFileFeatureType value) {
        this.resourceFileFeatureType = value;
    }

    /**
     * Gets the value of the resourceFileFeatureValue property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceFileFeatureValue }
     *     
     */
    public ResourceFileFeatureValue getResourceFileFeatureValue() {
        return resourceFileFeatureValue;
    }

    /**
     * Sets the value of the resourceFileFeatureValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceFileFeatureValue }
     *     
     */
    public void setResourceFileFeatureValue(ResourceFileFeatureValue value) {
        this.resourceFileFeatureValue = value;
    }

    /**
     * Gets the value of the resourceFileFeatureDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceFileFeatureDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceFileFeatureDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceFileFeatureDescription }
     * 
     * 
     */
    public List<ResourceFileFeatureDescription> getResourceFileFeatureDescription() {
        if (resourceFileFeatureDescription == null) {
            resourceFileFeatureDescription = new ArrayList<ResourceFileFeatureDescription>();
        }
        return this.resourceFileFeatureDescription;
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
