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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="oadrProfile" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrProfileName"/&gt;
 *                   &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrTransports"/&gt;
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
    "oadrProfile"
})
@XmlRootElement(name = "oadrProfiles")
public class OadrProfiles {

    @XmlElement(required = true)
    protected List<OadrProfiles.OadrProfile> oadrProfile;

    /**
     * Gets the value of the oadrProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oadrProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOadrProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OadrProfiles.OadrProfile }
     * 
     * 
     */
    public List<OadrProfiles.OadrProfile> getOadrProfile() {
        if (oadrProfile == null) {
            oadrProfile = new ArrayList<OadrProfiles.OadrProfile>();
        }
        return this.oadrProfile;
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
     *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrProfileName"/&gt;
     *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrTransports"/&gt;
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
        "oadrProfileName",
        "oadrTransports"
    })
    public static class OadrProfile {

        @XmlElement(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String oadrProfileName;
        @XmlElement(required = true)
        protected OadrTransports oadrTransports;

        /**
         * 获取oadrProfileName属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOadrProfileName() {
            return oadrProfileName;
        }

        /**
         * 设置oadrProfileName属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOadrProfileName(String value) {
            this.oadrProfileName = value;
        }

        /**
         * 获取oadrTransports属性的值。
         * 
         * @return
         *     possible object is
         *     {@link OadrTransports }
         *     
         */
        public OadrTransports getOadrTransports() {
            return oadrTransports;
        }

        /**
         * 设置oadrTransports属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link OadrTransports }
         *     
         */
        public void setOadrTransports(OadrTransports value) {
            this.oadrTransports = value;
        }

    }

}
