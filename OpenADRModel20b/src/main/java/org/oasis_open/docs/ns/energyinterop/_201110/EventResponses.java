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
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


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
 *         &lt;element name="eventResponse" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}responseCode"/&gt;
 *                   &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}responseDescription" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110/payloads}requestID"/&gt;
 *                   &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}qualifiedEventID"/&gt;
 *                   &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}optType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "eventResponse"
})
@XmlRootElement(name = "eventResponses")
public class EventResponses {

    protected List<EventResponses.EventResponse> eventResponse;

    /**
     * Gets the value of the eventResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventResponses.EventResponse }
     * 
     * 
     */
    public List<EventResponses.EventResponse> getEventResponse() {
        if (eventResponse == null) {
            eventResponse = new ArrayList<EventResponses.EventResponse>();
        }
        return this.eventResponse;
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
     *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}responseCode"/&gt;
     *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}responseDescription" minOccurs="0"/&gt;
     *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110/payloads}requestID"/&gt;
     *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}qualifiedEventID"/&gt;
     *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}optType"/&gt;
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
        "responseCode",
        "responseDescription",
        "requestID",
        "qualifiedEventID",
        "optType"
    })
    public static class EventResponse {

        @XmlElement(required = true)
        protected String responseCode;
        protected String responseDescription;
        @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110/payloads", required = true)
        protected String requestID;
        @XmlElement(required = true)
        protected QualifiedEventIDType qualifiedEventID;
        @XmlElement(required = true)
        @XmlSchemaType(name = "token")
        protected OptTypeType optType;

        /**
         * 获取responseCode属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResponseCode() {
            return responseCode;
        }

        /**
         * 设置responseCode属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResponseCode(String value) {
            this.responseCode = value;
        }

        /**
         * 获取responseDescription属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResponseDescription() {
            return responseDescription;
        }

        /**
         * 设置responseDescription属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResponseDescription(String value) {
            this.responseDescription = value;
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
         * 获取qualifiedEventID属性的值。
         * 
         * @return
         *     possible object is
         *     {@link QualifiedEventIDType }
         *     
         */
        public QualifiedEventIDType getQualifiedEventID() {
            return qualifiedEventID;
        }

        /**
         * 设置qualifiedEventID属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link QualifiedEventIDType }
         *     
         */
        public void setQualifiedEventID(QualifiedEventIDType value) {
            this.qualifiedEventID = value;
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

    }

}
