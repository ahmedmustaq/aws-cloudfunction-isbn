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
 *         &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}NameType"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}NameIdentifier" maxOccurs="unbounded"/>
 *             &lt;choice minOccurs="0">
 *               &lt;sequence>
 *                 &lt;group ref="{http://ns.editeur.org/onix/3.0/reference}gp.unstructured_name"/>
 *                 &lt;group ref="{http://ns.editeur.org/onix/3.0/reference}gp.structured_name" minOccurs="0"/>
 *                 &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Gender" minOccurs="0"/>
 *               &lt;/sequence>
 *               &lt;sequence>
 *                 &lt;group ref="{http://ns.editeur.org/onix/3.0/reference}gp.structured_name"/>
 *                 &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Gender" minOccurs="0"/>
 *               &lt;/sequence>
 *               &lt;group ref="{http://ns.editeur.org/onix/3.0/reference}gp.corporate_name"/>
 *             &lt;/choice>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;choice>
 *               &lt;sequence>
 *                 &lt;group ref="{http://ns.editeur.org/onix/3.0/reference}gp.unstructured_name"/>
 *                 &lt;group ref="{http://ns.editeur.org/onix/3.0/reference}gp.structured_name" minOccurs="0"/>
 *                 &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Gender" minOccurs="0"/>
 *               &lt;/sequence>
 *               &lt;sequence>
 *                 &lt;group ref="{http://ns.editeur.org/onix/3.0/reference}gp.structured_name"/>
 *                 &lt;element ref="{http://ns.editeur.org/onix/3.0/reference}Gender" minOccurs="0"/>
 *               &lt;/sequence>
 *               &lt;group ref="{http://ns.editeur.org/onix/3.0/reference}gp.corporate_name"/>
 *             &lt;/choice>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ns.editeur.org/onix/3.0/reference}generalAttributes"/>
 *       &lt;attribute name="refname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="AlternativeName"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="shortname">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="alternativename"/>
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
@XmlRootElement(name = "AlternativeName")
public class AlternativeName {

    @XmlElementRefs({
        @XmlElementRef(name = "NamesBeforeKey", namespace = "http://ns.editeur.org/onix/3.0/reference", type = NamesBeforeKey.class, required = false),
        @XmlElementRef(name = "Gender", namespace = "http://ns.editeur.org/onix/3.0/reference", type = Gender.class, required = false),
        @XmlElementRef(name = "PersonNameInverted", namespace = "http://ns.editeur.org/onix/3.0/reference", type = PersonNameInverted.class, required = false),
        @XmlElementRef(name = "CorporateName", namespace = "http://ns.editeur.org/onix/3.0/reference", type = CorporateName.class, required = false),
        @XmlElementRef(name = "NamesAfterKey", namespace = "http://ns.editeur.org/onix/3.0/reference", type = NamesAfterKey.class, required = false),
        @XmlElementRef(name = "TitlesAfterNames", namespace = "http://ns.editeur.org/onix/3.0/reference", type = TitlesAfterNames.class, required = false),
        @XmlElementRef(name = "NameType", namespace = "http://ns.editeur.org/onix/3.0/reference", type = NameType.class, required = false),
        @XmlElementRef(name = "SuffixToKey", namespace = "http://ns.editeur.org/onix/3.0/reference", type = SuffixToKey.class, required = false),
        @XmlElementRef(name = "LettersAfterNames", namespace = "http://ns.editeur.org/onix/3.0/reference", type = LettersAfterNames.class, required = false),
        @XmlElementRef(name = "PrefixToKey", namespace = "http://ns.editeur.org/onix/3.0/reference", type = PrefixToKey.class, required = false),
        @XmlElementRef(name = "KeyNames", namespace = "http://ns.editeur.org/onix/3.0/reference", type = KeyNames.class, required = false),
        @XmlElementRef(name = "PersonName", namespace = "http://ns.editeur.org/onix/3.0/reference", type = PersonName.class, required = false),
        @XmlElementRef(name = "TitlesBeforeNames", namespace = "http://ns.editeur.org/onix/3.0/reference", type = TitlesBeforeNames.class, required = false),
        @XmlElementRef(name = "CorporateNameInverted", namespace = "http://ns.editeur.org/onix/3.0/reference", type = CorporateNameInverted.class, required = false),
        @XmlElementRef(name = "NameIdentifier", namespace = "http://ns.editeur.org/onix/3.0/reference", type = NameIdentifier.class, required = false)
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
     * The field name "PersonNameInverted" is used by two different parts of a schema. See: 
     * line 14119 of file:/C:/Lumine/workspace-spring/book-service/schema/ONIX_BookProduct_3.0_reference.xsd
     * line 14117 of file:/C:/Lumine/workspace-spring/book-service/schema/ONIX_BookProduct_3.0_reference.xsd
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
     * {@link NamesBeforeKey }
     * {@link Gender }
     * {@link PersonNameInverted }
     * {@link CorporateName }
     * {@link NamesAfterKey }
     * {@link TitlesAfterNames }
     * {@link NameType }
     * {@link SuffixToKey }
     * {@link LettersAfterNames }
     * {@link PrefixToKey }
     * {@link KeyNames }
     * {@link PersonName }
     * {@link TitlesBeforeNames }
     * {@link CorporateNameInverted }
     * {@link NameIdentifier }
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
