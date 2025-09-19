//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import com.avob.oadr.PayloadAvobVenServiceRequestType;
import com.avob.oadr.PayloadKeyTokenType;
import ietf.params.xml.ns.icalendar_2_0.stream.StreamPayloadBaseType;
import org.openadr.oadr_2_0b._2012._07.OadrPayloadResourceStatusType;


/**
 * <p>signalPayloadType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="signalPayloadType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0:stream}StreamPayloadBaseType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}payloadBase"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signalPayloadType", propOrder = {
    "payloadBase"
})
public class SignalPayloadType
    extends StreamPayloadBaseType
{

    @XmlElementRef(name = "payloadBase", namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends PayloadBaseType> payloadBase;

    /**
     * 获取payloadBase属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PayloadKeyTokenType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PayloadFloatType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PayloadAvobVenServiceRequestType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OadrPayloadResourceStatusType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PayloadBaseType }{@code >}
     *     
     */
    public JAXBElement<? extends PayloadBaseType> getPayloadBase() {
        return payloadBase;
    }

    /**
     * 设置payloadBase属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PayloadKeyTokenType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PayloadFloatType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PayloadAvobVenServiceRequestType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OadrPayloadResourceStatusType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PayloadBaseType }{@code >}
     *     
     */
    public void setPayloadBase(JAXBElement<? extends PayloadBaseType> value) {
        this.payloadBase = value;
    }

}
