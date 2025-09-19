//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package un.unece.uncefact.codelist.standard._5.iso42173a._2010_04_07;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the un.unece.uncefact.codelist.standard._5.iso42173a._2010_04_07 package. 
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

    private final static QName _ISO3AlphaCurrencyCode_QNAME = new QName("urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2010-04-07", "ISO3AlphaCurrencyCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: un.unece.uncefact.codelist.standard._5.iso42173a._2010_04_07
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ISO3AlphaCurrencyCodeContentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ISO3AlphaCurrencyCodeContentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2010-04-07", name = "ISO3AlphaCurrencyCode")
    public JAXBElement<ISO3AlphaCurrencyCodeContentType> createISO3AlphaCurrencyCode(ISO3AlphaCurrencyCodeContentType value) {
        return new JAXBElement<ISO3AlphaCurrencyCodeContentType>(_ISO3AlphaCurrencyCode_QNAME, ISO3AlphaCurrencyCodeContentType.class, null, value);
    }

}
