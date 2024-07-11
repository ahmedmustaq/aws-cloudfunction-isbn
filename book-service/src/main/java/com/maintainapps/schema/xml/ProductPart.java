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
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}PrimaryPart" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}ProductIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://ns.editeur.org/onix/3.0/reference}gp.product_form_core"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}ProductContentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Measure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}NumberOfItemsOfThisForm"/>
 *             &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}NumberOfCopies" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}NumberOfCopies"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}CountryOfManufacture" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ns.editeur.org/onix/3.0/reference}generalAttributes"/>
 *       &lt;attribute name="refname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="ProductPart"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="shortname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="productpart"/>
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
@XmlRootElement(name = "ProductPart")
public class ProductPart {

    @XmlElementRefs({
        @XmlElementRef(name = "ProductFormDescription", namespace = "http://ns.editeur.org/onix/3.0/reference", type = ProductFormDescription.class, required = false),
        @XmlElementRef(name = "ProductForm", namespace = "http://ns.editeur.org/onix/3.0/reference", type = ProductForm.class, required = false),
        @XmlElementRef(name = "ProductIdentifier", namespace = "http://ns.editeur.org/onix/3.0/reference", type = ProductIdentifier.class, required = false),
        @XmlElementRef(name = "ProductPackaging", namespace = "http://ns.editeur.org/onix/3.0/reference", type = ProductPackaging.class, required = false),
        @XmlElementRef(name = "NumberOfItemsOfThisForm", namespace = "http://ns.editeur.org/onix/3.0/reference", type = NumberOfItemsOfThisForm.class, required = false),
        @XmlElementRef(name = "NumberOfCopies", namespace = "http://ns.editeur.org/onix/3.0/reference", type = NumberOfCopies.class, required = false),
        @XmlElementRef(name = "CountryOfManufacture", namespace = "http://ns.editeur.org/onix/3.0/reference", type = CountryOfManufacture.class, required = false),
        @XmlElementRef(name = "ProductFormDetail", namespace = "http://ns.editeur.org/onix/3.0/reference", type = ProductFormDetail.class, required = false),
        @XmlElementRef(name = "ProductContentType", namespace = "http://ns.editeur.org/onix/3.0/reference", type = ProductContentType.class, required = false),
        @XmlElementRef(name = "ProductFormFeature", namespace = "http://ns.editeur.org/onix/3.0/reference", type = ProductFormFeature.class, required = false),
        @XmlElementRef(name = "PrimaryPart", namespace = "http://ns.editeur.org/onix/3.0/reference", type = PrimaryPart.class, required = false),
        @XmlElementRef(name = "Measure", namespace = "http://ns.editeur.org/onix/3.0/reference", type = Measure.class, required = false)
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
     * The field name "NumberOfCopies" is used by two different parts of a schema. See: 
     * line 9507 of file:/C:/Lumine/workspace-spring/book-service/schema/ONIX_BookProduct_3.0_reference.xsd
     * line 9505 of file:/C:/Lumine/workspace-spring/book-service/schema/ONIX_BookProduct_3.0_reference.xsd
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
     * {@link ProductFormDescription }
     * {@link ProductForm }
     * {@link ProductIdentifier }
     * {@link ProductPackaging }
     * {@link NumberOfItemsOfThisForm }
     * {@link NumberOfCopies }
     * {@link CountryOfManufacture }
     * {@link ProductFormDetail }
     * {@link ProductContentType }
     * {@link ProductFormFeature }
     * {@link PrimaryPart }
     * {@link Measure }
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
