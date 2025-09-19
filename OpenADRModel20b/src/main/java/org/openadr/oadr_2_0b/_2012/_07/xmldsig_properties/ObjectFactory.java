//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.openadr.oadr_2_0b._2012._07.xmldsig_properties;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.openadr.oadr_2_0b._2012._07.xmldsig_properties package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReplayProtect_QNAME = new QName("http://openadr.org/oadr-2.0b/2012/07/xmldsig-properties", "ReplayProtect");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.openadr.oadr_2_0b._2012._07.xmldsig_properties
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReplayProtectType }
     * 
     */
    public ReplayProtectType createReplayProtectType() {
        return new ReplayProtectType();
    }

    /**
     * Create an instance of {@link NonceValueType }
     * 
     */
    public NonceValueType createNonceValueType() {
        return new NonceValueType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReplayProtectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReplayProtectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://openadr.org/oadr-2.0b/2012/07/xmldsig-properties", name = "ReplayProtect")
    public JAXBElement<ReplayProtectType> createReplayProtect(ReplayProtectType value) {
        return new JAXBElement<ReplayProtectType>(_ReplayProtect_QNAME, ReplayProtectType.class, null, value);
    }

}
