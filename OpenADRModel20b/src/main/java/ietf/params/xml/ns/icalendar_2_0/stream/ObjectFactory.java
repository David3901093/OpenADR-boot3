//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package ietf.params.xml.ns.icalendar_2_0.stream;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ietf.params.xml.ns.icalendar_2_0.stream package. 
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

    private final static QName _StreamPayloadBase_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0:stream", "streamPayloadBase");
    private final static QName _StreamBase_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0:stream", "streamBase");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ietf.params.xml.ns.icalendar_2_0.stream
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Intervals }
     * 
     */
    public Intervals createIntervals() {
        return new Intervals();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StreamPayloadBaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StreamPayloadBaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0:stream", name = "streamPayloadBase")
    public JAXBElement<StreamPayloadBaseType> createStreamPayloadBase(StreamPayloadBaseType value) {
        return new JAXBElement<StreamPayloadBaseType>(_StreamPayloadBase_QNAME, StreamPayloadBaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StreamBaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StreamBaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0:stream", name = "streamBase")
    public JAXBElement<StreamBaseType> createStreamBase(StreamBaseType value) {
        return new JAXBElement<StreamBaseType>(_StreamBase_QNAME, StreamBaseType.class, null, value);
    }

}
