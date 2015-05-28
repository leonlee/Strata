//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.20 at 01:28:29 PM CDT 
//


package com.opengamma.strata.examples.fpml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A type describing a role played by a person in one or more transactions. Examples include roles such as Trader, Broker, MiddleOffice, Legal, etc. This can be extended to provide custom roles.
 * 
 * <p>Java class for PersonRole complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonRole">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.fpml.org/FpML-5/pretrade>Scheme">
 *       &lt;attribute name="personRoleScheme" type="{http://www.w3.org/2001/XMLSchema}anyURI" default="http://www.fpml.org/coding-scheme/person-role" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonRole", propOrder = {
    "value"
})
public class PersonRole {

    @XmlValue
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "personRoleScheme")
    @XmlSchemaType(name = "anyURI")
    protected String personRoleScheme;

    /**
     * The base class for all types which define coding schemes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the personRoleScheme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonRoleScheme() {
        if (personRoleScheme == null) {
            return "http://www.fpml.org/coding-scheme/person-role";
        } else {
            return personRoleScheme;
        }
    }

    /**
     * Sets the value of the personRoleScheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonRoleScheme(String value) {
        this.personRoleScheme = value;
    }

}