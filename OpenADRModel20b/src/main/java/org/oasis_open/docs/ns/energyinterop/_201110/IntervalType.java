//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import ietf.params.xml.ns.icalendar_2.Dtstart;
import ietf.params.xml.ns.icalendar_2.DurationPropType;
import ietf.params.xml.ns.icalendar_2.Uid;
import ietf.params.xml.ns.icalendar_2_0.stream.StreamPayloadBaseType;
import org.openadr.oadr_2_0b._2012._07.OadrGBStreamPayloadBase;
import org.openadr.oadr_2_0b._2012._07.OadrReportPayloadType;


/**
 * <p>IntervalType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="IntervalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}dtstart" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}duration" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}uid" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0:stream}streamPayloadBase" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntervalType", propOrder = {
    "dtstart",
    "duration",
    "uid",
    "streamPayloadBase"
})
public class IntervalType {

    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0")
    protected Dtstart dtstart;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0")
    protected DurationPropType duration;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0")
    protected Uid uid;
    @XmlElementRef(name = "streamPayloadBase", namespace = "urn:ietf:params:xml:ns:icalendar-2.0:stream", type = JAXBElement.class)
    protected List<JAXBElement<? extends StreamPayloadBaseType>> streamPayloadBase;

    /**
     * 获取dtstart属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Dtstart }
     *     
     */
    public Dtstart getDtstart() {
        return dtstart;
    }

    /**
     * 设置dtstart属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Dtstart }
     *     
     */
    public void setDtstart(Dtstart value) {
        this.dtstart = value;
    }

    /**
     * 获取duration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getDuration() {
        return duration;
    }

    /**
     * 设置duration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setDuration(DurationPropType value) {
        this.duration = value;
    }

    /**
     * 获取uid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Uid }
     *     
     */
    public Uid getUid() {
        return uid;
    }

    /**
     * 设置uid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Uid }
     *     
     */
    public void setUid(Uid value) {
        this.uid = value;
    }

    /**
     * Gets the value of the streamPayloadBase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the streamPayloadBase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStreamPayloadBase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link OadrReportPayloadType }{@code >}
     * {@link JAXBElement }{@code <}{@link OadrGBStreamPayloadBase }{@code >}
     * {@link JAXBElement }{@code <}{@link SignalPayloadType }{@code >}
     * {@link JAXBElement }{@code <}{@link StreamPayloadBaseType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends StreamPayloadBaseType>> getStreamPayloadBase() {
        if (streamPayloadBase == null) {
            streamPayloadBase = new ArrayList<JAXBElement<? extends StreamPayloadBaseType>>();
        }
        return this.streamPayloadBase;
    }

}
