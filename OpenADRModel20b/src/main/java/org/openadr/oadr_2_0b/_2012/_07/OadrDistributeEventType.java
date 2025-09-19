//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.openadr.oadr_2_0b._2012._07;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import org.oasis_open.docs.ns.energyinterop._201110.EiEventType;
import org.oasis_open.docs.ns.energyinterop._201110.EiResponseType;


/**
 * <p>oadrDistributeEventType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="oadrDistributeEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiResponse" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110/payloads}requestID"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}vtnID"/&gt;
 *         &lt;element name="oadrEvent" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiEvent"/&gt;
 *                   &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrResponseRequired"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "oadrDistributeEventType", propOrder = {
    "eiResponse",
    "requestID",
    "vtnID",
    "oadrEvent"
})
public class OadrDistributeEventType {

    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected EiResponseType eiResponse;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110/payloads", required = true)
    protected String requestID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected String vtnID;
    protected List<OadrDistributeEventType.OadrEvent> oadrEvent;
    @XmlAttribute(name = "schemaVersion", namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected String schemaVersion;

    /**
     * 获取eiResponse属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EiResponseType }
     *     
     */
    public EiResponseType getEiResponse() {
        return eiResponse;
    }

    /**
     * 设置eiResponse属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EiResponseType }
     *     
     */
    public void setEiResponse(EiResponseType value) {
        this.eiResponse = value;
    }

    /**
     * 获取requestID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * 设置requestID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestID(String value) {
        this.requestID = value;
    }

    /**
     * 获取vtnID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVtnID() {
        return vtnID;
    }

    /**
     * 设置vtnID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVtnID(String value) {
        this.vtnID = value;
    }

    /**
     * Gets the value of the oadrEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oadrEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOadrEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OadrDistributeEventType.OadrEvent }
     * 
     * 
     */
    public List<OadrDistributeEventType.OadrEvent> getOadrEvent() {
        if (oadrEvent == null) {
            oadrEvent = new ArrayList<OadrDistributeEventType.OadrEvent>();
        }
        return this.oadrEvent;
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
     *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiEvent"/&gt;
     *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrResponseRequired"/&gt;
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
        "eiEvent",
        "oadrResponseRequired"
    })
    public static class OadrEvent {

        @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
        protected EiEventType eiEvent;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected ResponseRequiredType oadrResponseRequired;

        /**
         * 获取eiEvent属性的值。
         * 
         * @return
         *     possible object is
         *     {@link EiEventType }
         *     
         */
        public EiEventType getEiEvent() {
            return eiEvent;
        }

        /**
         * 设置eiEvent属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link EiEventType }
         *     
         */
        public void setEiEvent(EiEventType value) {
            this.eiEvent = value;
        }

        /**
         * 获取oadrResponseRequired属性的值。
         * 
         * @return
         *     possible object is
         *     {@link ResponseRequiredType }
         *     
         */
        public ResponseRequiredType getOadrResponseRequired() {
            return oadrResponseRequired;
        }

        /**
         * 设置oadrResponseRequired属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link ResponseRequiredType }
         *     
         */
        public void setOadrResponseRequired(ResponseRequiredType value) {
            this.oadrResponseRequired = value;
        }

    }

}
