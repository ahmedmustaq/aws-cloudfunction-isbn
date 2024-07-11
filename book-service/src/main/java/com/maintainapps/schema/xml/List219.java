//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.07.26 at 02:03:50 PM GST 
//


package com.maintainapps.schema.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for List219.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="List219">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="D"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "List219")
@XmlEnum
public enum List219 {


    /**
     * Text or image copyright (normally indicated by the � symbol). The default if no <CopyrightType> is specified
     * 
     */
    C,

    /**
     * Phonogram copyright or neighbouring right (normally indicated by the \u2117 symbol)
     * 
     */
    P,

    /**
     * Sui generis database right
     * 
     */
    D;

    public String value() {
        return name();
    }

    public static List219 fromValue(String v) {
        return valueOf(v);
    }

}
