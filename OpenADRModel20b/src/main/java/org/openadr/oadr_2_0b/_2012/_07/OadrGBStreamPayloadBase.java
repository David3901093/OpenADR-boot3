//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.openadr.oadr_2_0b._2012._07;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ietf.params.xml.ns.icalendar_2_0.stream.StreamPayloadBaseType;
import org.w3._2005.atom.FeedType;


/**
 * <p>oadrGBStreamPayloadBase complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="oadrGBStreamPayloadBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0:stream}StreamPayloadBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2005/Atom}feed"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oadrGBStreamPayloadBase", propOrder = {
    "feed"
})
public class OadrGBStreamPayloadBase
    extends StreamPayloadBaseType
{

    @XmlElement(namespace = "http://www.w3.org/2005/Atom", required = true)
    protected FeedType feed;

    /**
     * 获取feed属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FeedType }
     *     
     */
    public FeedType getFeed() {
        return feed;
    }

    /**
     * 设置feed属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FeedType }
     *     
     */
    public void setFeed(FeedType value) {
        this.feed = value;
    }

}
