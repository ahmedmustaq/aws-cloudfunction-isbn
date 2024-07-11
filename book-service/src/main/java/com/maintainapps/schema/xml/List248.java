//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.07.26 at 02:03:50 PM GST 
//


package com.maintainapps.schema.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for List248.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="List248">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A411"/>
 *     &lt;enumeration value="A412"/>
 *     &lt;enumeration value="A413"/>
 *     &lt;enumeration value="A414"/>
 *     &lt;enumeration value="A415"/>
 *     &lt;enumeration value="A416"/>
 *     &lt;enumeration value="A417"/>
 *     &lt;enumeration value="A418"/>
 *     &lt;enumeration value="A419"/>
 *     &lt;enumeration value="A424"/>
 *     &lt;enumeration value="A425"/>
 *     &lt;enumeration value="B001"/>
 *     &lt;enumeration value="B002"/>
 *     &lt;enumeration value="B003"/>
 *     &lt;enumeration value="B004"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "List248")
@XmlEnum
public enum List248 {

    @XmlEnumValue("A411")
    A_411("A411"),

    /**
     *  44,100 samples per channel per second (CD quality)
     * 
     */
    @XmlEnumValue("A412")
    A_412("A412"),
    @XmlEnumValue("A413")
    A_413("A413"),
    @XmlEnumValue("A414")
    A_414("A414"),
    @XmlEnumValue("A415")
    A_415("A415"),

    /**
     * Bit depth, 16 bits per sample (CD-quality)
     * 
     */
    @XmlEnumValue("A416")
    A_416("A416"),
    @XmlEnumValue("A417")
    A_417("A417"),
    @XmlEnumValue("A418")
    A_418("A418"),
    @XmlEnumValue("A419")
    A_419("A419"),

    /**
     * Includes v1.1
     * 
     */
    @XmlEnumValue("A424")
    A_424("A424"),
    @XmlEnumValue("A425")
    A_425("A425"),

    /**
     * Grain of paper parallel to spine
     * 
     */
    @XmlEnumValue("B001")
    B_001("B001"),

    /**
     * Grain of paper perpendicular to spine
     * 
     */
    @XmlEnumValue("B002")
    B_002("B002"),

    /**
     * Usually B/W
     * 
     */
    @XmlEnumValue("B003")
    B_003("B003"),
    @XmlEnumValue("B004")
    B_004("B004");
    private final String value;

    List248(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static List248 fromValue(String v) {
        for (List248 c: List248 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
