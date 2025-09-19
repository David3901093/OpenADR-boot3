//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.emix._2011._06;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.oasis_open.docs.ns.emix._2011._06 package. 
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

    private final static QName _ItemBase_QNAME = new QName("http://docs.oasis-open.org/ns/emix/2011/06", "itemBase");
    private final static QName _MarketContext_QNAME = new QName("http://docs.oasis-open.org/ns/emix/2011/06", "marketContext");
    private final static QName _ServiceArea_QNAME = new QName("http://docs.oasis-open.org/ns/emix/2011/06", "serviceArea");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.oasis_open.docs.ns.emix._2011._06
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceAreaType }
     * 
     */
    public ServiceAreaType createServiceAreaType() {
        return new ServiceAreaType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemBaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemBaseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/emix/2011/06", name = "itemBase")
    public JAXBElement<ItemBaseType> createItemBase(ItemBaseType value) {
        return new JAXBElement<ItemBaseType>(_ItemBase_QNAME, ItemBaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/emix/2011/06", name = "marketContext")
    public JAXBElement<String> createMarketContext(String value) {
        return new JAXBElement<String>(_MarketContext_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceAreaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceAreaType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/emix/2011/06", name = "serviceArea")
    public JAXBElement<ServiceAreaType> createServiceArea(ServiceAreaType value) {
        return new JAXBElement<ServiceAreaType>(_ServiceArea_QNAME, ServiceAreaType.class, null, value);
    }

}
