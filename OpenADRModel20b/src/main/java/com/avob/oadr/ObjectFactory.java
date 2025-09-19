//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package com.avob.oadr;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.avob.oadr package. 
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

    private final static QName _PayloadKeyToken_QNAME = new QName("http://oadr.avob.com", "payloadKeyToken");
    private final static QName _PayloadAvobVenServiceRequest_QNAME = new QName("http://oadr.avob.com", "payloadAvobVenServiceRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.avob.oadr
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PayloadKeyTokenType }
     * 
     */
    public PayloadKeyTokenType createPayloadKeyTokenType() {
        return new PayloadKeyTokenType();
    }

    /**
     * Create an instance of {@link PayloadAvobVenServiceRequestType }
     * 
     */
    public PayloadAvobVenServiceRequestType createPayloadAvobVenServiceRequestType() {
        return new PayloadAvobVenServiceRequestType();
    }

    /**
     * Create an instance of {@link KeyTokenType }
     * 
     */
    public KeyTokenType createKeyTokenType() {
        return new KeyTokenType();
    }

    /**
     * Create an instance of {@link AvobVenServiceRequestType }
     * 
     */
    public AvobVenServiceRequestType createAvobVenServiceRequestType() {
        return new AvobVenServiceRequestType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayloadKeyTokenType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PayloadKeyTokenType }{@code >}
     */
    @XmlElementDecl(namespace = "http://oadr.avob.com", name = "payloadKeyToken", substitutionHeadNamespace = "http://docs.oasis-open.org/ns/energyinterop/201110", substitutionHeadName = "payloadBase")
    public JAXBElement<PayloadKeyTokenType> createPayloadKeyToken(PayloadKeyTokenType value) {
        return new JAXBElement<PayloadKeyTokenType>(_PayloadKeyToken_QNAME, PayloadKeyTokenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayloadAvobVenServiceRequestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PayloadAvobVenServiceRequestType }{@code >}
     */
    @XmlElementDecl(namespace = "http://oadr.avob.com", name = "payloadAvobVenServiceRequest", substitutionHeadNamespace = "http://docs.oasis-open.org/ns/energyinterop/201110", substitutionHeadName = "payloadBase")
    public JAXBElement<PayloadAvobVenServiceRequestType> createPayloadAvobVenServiceRequest(PayloadAvobVenServiceRequestType value) {
        return new JAXBElement<PayloadAvobVenServiceRequestType>(_PayloadAvobVenServiceRequest_QNAME, PayloadAvobVenServiceRequestType.class, null, value);
    }

}
