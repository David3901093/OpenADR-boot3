//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ietf.params.xml.ns.icalendar_2.DurationPropType;
import ietf.params.xml.ns.icalendar_2.WsCalendarIntervalType;


/**
 * Parameters that define the content of a Report Stream
 * 
 * <p>ReportSpecifierType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReportSpecifierType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}reportSpecifierID"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}granularity"/&gt;
 *         &lt;element name="reportBackDuration" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationPropType"/&gt;
 *         &lt;element name="reportInterval" type="{urn:ietf:params:xml:ns:icalendar-2.0}WsCalendarIntervalType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}specifierPayload" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportSpecifierType", propOrder = {
    "reportSpecifierID",
    "granularity",
    "reportBackDuration",
    "reportInterval",
    "specifierPayload"
})
public class ReportSpecifierType {

    @XmlElement(required = true)
    protected String reportSpecifierID;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", required = true)
    protected DurationPropType granularity;
    @XmlElement(required = true)
    protected DurationPropType reportBackDuration;
    protected WsCalendarIntervalType reportInterval;
    @XmlElement(required = true)
    protected List<SpecifierPayloadType> specifierPayload;

    /**
     * 获取reportSpecifierID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportSpecifierID() {
        return reportSpecifierID;
    }

    /**
     * 设置reportSpecifierID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportSpecifierID(String value) {
        this.reportSpecifierID = value;
    }

    /**
     * How frequently the [measurement] is to be recorded.
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getGranularity() {
        return granularity;
    }

    /**
     * 设置granularity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setGranularity(DurationPropType value) {
        this.granularity = value;
    }

    /**
     * 获取reportBackDuration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getReportBackDuration() {
        return reportBackDuration;
    }

    /**
     * 设置reportBackDuration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setReportBackDuration(DurationPropType value) {
        this.reportBackDuration = value;
    }

    /**
     * 获取reportInterval属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WsCalendarIntervalType }
     *     
     */
    public WsCalendarIntervalType getReportInterval() {
        return reportInterval;
    }

    /**
     * 设置reportInterval属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WsCalendarIntervalType }
     *     
     */
    public void setReportInterval(WsCalendarIntervalType value) {
        this.reportInterval = value;
    }

    /**
     * Gets the value of the specifierPayload property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specifierPayload property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecifierPayload().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecifierPayloadType }
     * 
     * 
     */
    public List<SpecifierPayloadType> getSpecifierPayload() {
        if (specifierPayload == null) {
            specifierPayload = new ArrayList<SpecifierPayloadType>();
        }
        return this.specifierPayload;
    }

}
