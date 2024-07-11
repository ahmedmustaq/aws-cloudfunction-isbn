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
 *         &lt;group ref="{http://ns.editeur.org/onix/3.0/reference}gp.product_specification"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}InsertPoint"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}InsertResource" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ns.editeur.org/onix/3.0/reference}generalAttributes"/>
 *       &lt;attribute name="refname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="InsertManifest"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="shortname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="insertmanifest"/>
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
    "specificationBundleName",
    "specificationDetail",
    "specificationFeature",
    "specificationDescription",
    "insertPoint",
    "insertResource"
})
@XmlRootElement(name = "InsertManifest")
public class InsertManifest {

    @XmlElement(name = "SpecificationBundleName")
    protected List<SpecificationBundleName> specificationBundleName;
    @XmlElement(name = "SpecificationDetail")
    protected List<SpecificationDetail> specificationDetail;
    @XmlElement(name = "SpecificationFeature")
    protected List<SpecificationFeature> specificationFeature;
    @XmlElement(name = "SpecificationDescription")
    protected List<SpecificationDescription> specificationDescription;
    @XmlElement(name = "InsertPoint", required = true)
    protected InsertPoint insertPoint;
    @XmlElement(name = "InsertResource", required = true)
    protected List<InsertResource> insertResource;
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
     * Gets the value of the specificationBundleName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specificationBundleName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecificationBundleName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecificationBundleName }
     * 
     * 
     */
    public List<SpecificationBundleName> getSpecificationBundleName() {
        if (specificationBundleName == null) {
            specificationBundleName = new ArrayList<SpecificationBundleName>();
        }
        return this.specificationBundleName;
    }

    /**
     * Gets the value of the specificationDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specificationDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecificationDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecificationDetail }
     * 
     * 
     */
    public List<SpecificationDetail> getSpecificationDetail() {
        if (specificationDetail == null) {
            specificationDetail = new ArrayList<SpecificationDetail>();
        }
        return this.specificationDetail;
    }

    /**
     * Gets the value of the specificationFeature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specificationFeature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecificationFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecificationFeature }
     * 
     * 
     */
    public List<SpecificationFeature> getSpecificationFeature() {
        if (specificationFeature == null) {
            specificationFeature = new ArrayList<SpecificationFeature>();
        }
        return this.specificationFeature;
    }

    /**
     * Gets the value of the specificationDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specificationDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecificationDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecificationDescription }
     * 
     * 
     */
    public List<SpecificationDescription> getSpecificationDescription() {
        if (specificationDescription == null) {
            specificationDescription = new ArrayList<SpecificationDescription>();
        }
        return this.specificationDescription;
    }

    /**
     * Gets the value of the insertPoint property.
     * 
     * @return
     *     possible object is
     *     {@link InsertPoint }
     *     
     */
    public InsertPoint getInsertPoint() {
        return insertPoint;
    }

    /**
     * Sets the value of the insertPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link InsertPoint }
     *     
     */
    public void setInsertPoint(InsertPoint value) {
        this.insertPoint = value;
    }

    /**
     * Gets the value of the insertResource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the insertResource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInsertResource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InsertResource }
     * 
     * 
     */
    public List<InsertResource> getInsertResource() {
        if (insertResource == null) {
            insertResource = new ArrayList<InsertResource>();
        }
        return this.insertResource;
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
