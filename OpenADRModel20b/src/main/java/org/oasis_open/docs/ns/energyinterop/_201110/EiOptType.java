//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ietf.params.xml.ns.icalendar_2.VavailabilityType;
import org.openadr.oadr_2_0b._2012._07.OadrCreateOptType;


/**
 * Opts are used by the VEN to temporarily override the pre-existing agreement. For example, a VEN may opt in to events during the evening, or opt out from events during the world series.
 * 
 * <p>EiOptType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="EiOptType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}optID"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}optType"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}optReason"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/emix/2011/06}marketContext" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}venID"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}vavailability" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}createdDateTime"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://docs.oasis-open.org/ns/energyinterop/201110}schemaVersion"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EiOptType", propOrder = {
    "optID",
    "optType",
    "optReason",
    "marketContext",
    "venID",
    "vavailability",
    "createdDateTime"
})
@XmlSeeAlso({
    OadrCreateOptType.class
})
public class EiOptType {

    @XmlElement(required = true)
    protected String optID;
    @XmlElement(required = true)
    @XmlSchemaType(name = "token")
    protected OptTypeType optType;
    @XmlElement(required = true)
    protected String optReason;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/emix/2011/06")
    @XmlSchemaType(name = "anyURI")
    protected String marketContext;
    @XmlElement(required = true)
    protected String venID;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0")
    protected VavailabilityType vavailability;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDateTime;
    @XmlAttribute(name = "schemaVersion", namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected String schemaVersion;

    /**
     * 获取optID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptID() {
        return optID;
    }

    /**
     * 设置optID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptID(String value) {
        this.optID = value;
    }

    /**
     * 获取optType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OptTypeType }
     *     
     */
    public OptTypeType getOptType() {
        return optType;
    }

    /**
     * 设置optType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OptTypeType }
     *     
     */
    public void setOptType(OptTypeType value) {
        this.optType = value;
    }

    /**
     * 获取optReason属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptReason() {
        return optReason;
    }

    /**
     * 设置optReason属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptReason(String value) {
        this.optReason = value;
    }

    /**
     * 获取marketContext属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketContext() {
        return marketContext;
    }

    /**
     * 设置marketContext属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketContext(String value) {
        this.marketContext = value;
    }

    /**
     * 获取venID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVenID() {
        return venID;
    }

    /**
     * 设置venID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVenID(String value) {
        this.venID = value;
    }

    /**
     * 获取vavailability属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VavailabilityType }
     *     
     */
    public VavailabilityType getVavailability() {
        return vavailability;
    }

    /**
     * 设置vavailability属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VavailabilityType }
     *     
     */
    public void setVavailability(VavailabilityType value) {
        this.vavailability = value;
    }

    /**
     * 获取createdDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * 设置createdDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDateTime(XMLGregorianCalendar value) {
        this.createdDateTime = value;
    }

    /**
     * 获取schemaVersion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * 设置schemaVersion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemaVersion(String value) {
        this.schemaVersion = value;
    }

}
