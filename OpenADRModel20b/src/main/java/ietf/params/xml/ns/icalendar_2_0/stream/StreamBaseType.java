//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package ietf.params.xml.ns.icalendar_2_0.stream;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import ietf.params.xml.ns.icalendar_2.Dtstart;
import ietf.params.xml.ns.icalendar_2.DurationPropType;
import org.openadr.oadr_2_0b._2012._07.OadrReportType;


/**
 * abstract base for communication of schedules for signals and observations
 * 
 * <p>StreamBaseType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="StreamBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}dtstart" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}duration" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0:stream}intervals" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StreamBaseType", propOrder = {
    "dtstart",
    "duration",
    "intervals"
})
@XmlSeeAlso({
    OadrReportType.class
})
public abstract class StreamBaseType {

    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0")
    protected Dtstart dtstart;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0")
    protected DurationPropType duration;
    protected Intervals intervals;

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
     * 获取intervals属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Intervals }
     *     
     */
    public Intervals getIntervals() {
        return intervals;
    }

    /**
     * 设置intervals属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Intervals }
     *     
     */
    public void setIntervals(Intervals value) {
        this.intervals = value;
    }

}
