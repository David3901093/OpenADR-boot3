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
import jakarta.xml.bind.annotation.XmlType;
import ietf.params.xml.ns.icalendar_2.DurationPropType;
import org.oasis_open.docs.ns.energyinterop._201110.EiResponseType;


/**
 * <p>oadrCreatedPartyRegistrationType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="oadrCreatedPartyRegistrationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiResponse"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}registrationID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}venID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}vtnID"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrProfiles"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrRequestedOadrPollFreq" minOccurs="0"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrServiceSpecificInfo" minOccurs="0"/&gt;
 *         &lt;element name="oadrExtensions" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="oadrExtension" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="oadrExtensionName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "oadrCreatedPartyRegistrationType", propOrder = {
    "eiResponse",
    "registrationID",
    "venID",
    "vtnID",
    "oadrProfiles",
    "oadrRequestedOadrPollFreq",
    "oadrServiceSpecificInfo",
    "oadrExtensions"
})
public class OadrCreatedPartyRegistrationType {

    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected EiResponseType eiResponse;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected String registrationID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected String venID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected String vtnID;
    @XmlElement(required = true)
    protected OadrProfiles oadrProfiles;
    protected DurationPropType oadrRequestedOadrPollFreq;
    protected OadrServiceSpecificInfo oadrServiceSpecificInfo;
    protected OadrCreatedPartyRegistrationType.OadrExtensions oadrExtensions;
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
     * 获取registrationID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationID() {
        return registrationID;
    }

    /**
     * 设置registrationID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationID(String value) {
        this.registrationID = value;
    }

    /**
     * venID not included in query unless already registered
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
     * VTN response to query registration returns all supported. This element is not required for a registration  response
     * 
     * @return
     *     possible object is
     *     {@link OadrProfiles }
     *     
     */
    public OadrProfiles getOadrProfiles() {
        return oadrProfiles;
    }

    /**
     * 设置oadrProfiles属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrProfiles }
     *     
     */
    public void setOadrProfiles(OadrProfiles value) {
        this.oadrProfiles = value;
    }

    /**
     * HTTP Pull Only - The VEN shall send an oadrPoll payload to the VTN at most once for each duration specified by this element
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getOadrRequestedOadrPollFreq() {
        return oadrRequestedOadrPollFreq;
    }

    /**
     * 设置oadrRequestedOadrPollFreq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setOadrRequestedOadrPollFreq(DurationPropType value) {
        this.oadrRequestedOadrPollFreq = value;
    }

    /**
     * 获取oadrServiceSpecificInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrServiceSpecificInfo }
     *     
     */
    public OadrServiceSpecificInfo getOadrServiceSpecificInfo() {
        return oadrServiceSpecificInfo;
    }

    /**
     * 设置oadrServiceSpecificInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrServiceSpecificInfo }
     *     
     */
    public void setOadrServiceSpecificInfo(OadrServiceSpecificInfo value) {
        this.oadrServiceSpecificInfo = value;
    }

    /**
     * 获取oadrExtensions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCreatedPartyRegistrationType.OadrExtensions }
     *     
     */
    public OadrCreatedPartyRegistrationType.OadrExtensions getOadrExtensions() {
        return oadrExtensions;
    }

    /**
     * 设置oadrExtensions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCreatedPartyRegistrationType.OadrExtensions }
     *     
     */
    public void setOadrExtensions(OadrCreatedPartyRegistrationType.OadrExtensions value) {
        this.oadrExtensions = value;
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
     *         &lt;element name="oadrExtension" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="oadrExtensionName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "oadrExtension"
    })
    public static class OadrExtensions {

        protected List<OadrCreatedPartyRegistrationType.OadrExtensions.OadrExtension> oadrExtension;

        /**
         * Gets the value of the oadrExtension property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the oadrExtension property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOadrExtension().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OadrCreatedPartyRegistrationType.OadrExtensions.OadrExtension }
         * 
         * 
         */
        public List<OadrCreatedPartyRegistrationType.OadrExtensions.OadrExtension> getOadrExtension() {
            if (oadrExtension == null) {
                oadrExtension = new ArrayList<OadrCreatedPartyRegistrationType.OadrExtensions.OadrExtension>();
            }
            return this.oadrExtension;
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
         *         &lt;element name="oadrExtensionName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
            "oadrExtensionName",
            "oadrInfo"
        })
        public static class OadrExtension {

            @XmlElement(required = true)
            protected String oadrExtensionName;
            protected List<OadrInfo> oadrInfo;

            /**
             * 获取oadrExtensionName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOadrExtensionName() {
                return oadrExtensionName;
            }

            /**
             * 设置oadrExtensionName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOadrExtensionName(String value) {
                this.oadrExtensionName = value;
            }

            /**
             * Gets the value of the oadrInfo property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the oadrInfo property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOadrInfo().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link OadrInfo }
             * 
             * 
             */
            public List<OadrInfo> getOadrInfo() {
                if (oadrInfo == null) {
                    oadrInfo = new ArrayList<OadrInfo>();
                }
                return this.oadrInfo;
            }

        }

    }

}
