//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package ietf.params.xml.ns.icalendar_2_0.stream;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.oasis_open.docs.ns.energyinterop._201110.ReportPayloadType;
import org.oasis_open.docs.ns.energyinterop._201110.SignalPayloadType;
import org.openadr.oadr_2_0b._2012._07.OadrGBStreamPayloadBase;


/**
 * Abstract class to convey a payload for a stream. When a Stream is transformed to or from a WS-Calendar Interval, the contents of the Stream Payload defined element are transformed into the contents of a WS-Calendar artifactBase.
 * 
 * <p>StreamPayloadBaseType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="StreamPayloadBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StreamPayloadBaseType")
@XmlSeeAlso({
    OadrGBStreamPayloadBase.class,
    SignalPayloadType.class,
    ReportPayloadType.class
})
public abstract class StreamPayloadBaseType {


}
