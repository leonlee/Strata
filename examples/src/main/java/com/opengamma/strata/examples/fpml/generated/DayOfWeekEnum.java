//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.20 at 01:28:29 PM CDT 
//


package com.opengamma.strata.examples.fpml.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DayOfWeekEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DayOfWeekEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="MON"/>
 *     &lt;enumeration value="TUE"/>
 *     &lt;enumeration value="WED"/>
 *     &lt;enumeration value="THU"/>
 *     &lt;enumeration value="FRI"/>
 *     &lt;enumeration value="SAT"/>
 *     &lt;enumeration value="SUN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DayOfWeekEnum")
@XmlEnum
public enum DayOfWeekEnum {


    /**
     * Monday
     * 
     */
    MON,

    /**
     * Tuesday
     * 
     */
    TUE,

    /**
     * Wednesday
     * 
     */
    WED,

    /**
     * Thursday
     * 
     */
    THU,

    /**
     * Friday
     * 
     */
    FRI,

    /**
     * Saturday
     * 
     */
    SAT,

    /**
     * Sunday
     * 
     */
    SUN;

    public String value() {
        return name();
    }

    public static DayOfWeekEnum fromValue(String v) {
        return valueOf(v);
    }

}