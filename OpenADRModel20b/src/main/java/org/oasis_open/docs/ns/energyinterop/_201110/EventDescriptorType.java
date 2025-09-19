//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>eventDescriptorType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="eventDescriptorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eventID"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}modificationNumber"/&gt;
 *         &lt;element name="modificationDateTime" type="{urn:ietf:params:xml:ns:icalendar-2.0}DateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="modificationReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/&gt;
 *         &lt;element name="eiMarketContext"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://docs.oasis-open.org/ns/emix/2011/06}marketContext"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}createdDateTime"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eventStatus"/&gt;
 *         &lt;element name="testEvent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="vtnComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventDescriptorType", propOrder = {
    "eventID",
    "modificationNumber",
    "modificationDateTime",
    "modificationReason",
    "priority",
    "eiMarketContext",
    "createdDateTime",
    "eventStatus",
    "testEvent",
    "vtnComment"
})
public class EventDescriptorType {

    @XmlElement(required = true)
    protected String eventID;
    @XmlSchemaType(name = "unsignedInt")
    protected long modificationNumber;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modificationDateTime;
    protected String modificationReason;
    @XmlSchemaType(name = "unsignedInt")
    protected Long priority;
    @XmlElement(required = true)
    protected EventDescriptorType.EiMarketContext eiMarketContext;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDateTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "token")
    protected EventStatusEnumeratedType eventStatus;
    protected String testEvent;
    protected String vtnComment;

    /**
     * 获取eventID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventID() {
        return eventID;
    }

    /**
     * 设置eventID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventID(String value) {
        this.eventID = value;
    }

    /**
     * 获取modificationNumber属性的值。
     * 
     */
    public long getModificationNumber() {
        return modificationNumber;
    }

    /**
     * 设置modificationNumber属性的值。
     * 
     */
    public void setModificationNumber(long value) {
        this.modificationNumber = value;
    }

    /**
     * 获取modificationDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModificationDateTime() {
        return modificationDateTime;
    }

    /**
     * 设置modificationDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModificationDateTime(XMLGregorianCalendar value) {
        this.modificationDateTime = value;
    }

    /**
     * 获取modificationReason属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModificationReason() {
        return modificationReason;
    }

    /**
     * 设置modificationReason属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModificationReason(String value) {
        this.modificationReason = value;
    }

    /**
     * 获取priority属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriority() {
        return priority;
    }

    /**
     * 设置priority属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriority(Long value) {
        this.priority = value;
    }

    /**
     * 获取eiMarketContext属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EventDescriptorType.EiMarketContext }
     *     
     */
    public EventDescriptorType.EiMarketContext getEiMarketContext() {
        return eiMarketContext;
    }

    /**
     * 设置eiMarketContext属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EventDescriptorType.EiMarketContext }
     *     
     */
    public void setEiMarketContext(EventDescriptorType.EiMarketContext value) {
        this.eiMarketContext = value;
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
     * An indication of the event state: far, near, active, canceled, completed
     * 
     * @return
     *     possible object is
     *     {@link EventStatusEnumeratedType }
     *     
     */
    public EventStatusEnumeratedType getEventStatus() {
        return eventStatus;
    }

    /**
     * 设置eventStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EventStatusEnumeratedType }
     *     
     */
    public void setEventStatus(EventStatusEnumeratedType value) {
        this.eventStatus = value;
    }

    /**
     * 获取testEvent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestEvent() {
        return testEvent;
    }

    /**
     * 设置testEvent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestEvent(String value) {
        this.testEvent = value;
    }

    /**
     * 获取vtnComment属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVtnComment() {
        return vtnComment;
    }

    /**
     * 设置vtnComment属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVtnComment(String value) {
        this.vtnComment = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://docs.oasis-open.org/ns/emix/2011/06}marketContext"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "marketContext"
    })
    public static class EiMarketContext {

        @XmlElement(namespace = "http://docs.oasis-open.org/ns/emix/2011/06", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String marketContext;

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

    }

}
