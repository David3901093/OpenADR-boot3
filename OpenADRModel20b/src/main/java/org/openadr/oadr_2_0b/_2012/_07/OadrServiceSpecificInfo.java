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
 *         &lt;element name="oadrService" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrServiceName"/&gt;
 *                   &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrInfo" maxOccurs="unbounded"/&gt;
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
    "oadrService"
})
@XmlRootElement(name = "oadrServiceSpecificInfo")
public class OadrServiceSpecificInfo {

    protected List<OadrServiceSpecificInfo.OadrService> oadrService;

    /**
     * Gets the value of the oadrService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oadrService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOadrService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OadrServiceSpecificInfo.OadrService }
     * 
     * 
     */
    public List<OadrServiceSpecificInfo.OadrService> getOadrService() {
        if (oadrService == null) {
            oadrService = new ArrayList<OadrServiceSpecificInfo.OadrService>();
        }
        return this.oadrService;
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
     *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrServiceName"/&gt;
     *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrInfo" maxOccurs="unbounded"/&gt;
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
        "oadrServiceName",
        "oadrInfo"
    })
    public static class OadrService {

        @XmlElement(required = true)
        @XmlSchemaType(name = "token")
        protected OadrServiceNameType oadrServiceName;
        @XmlElement(required = true)
        protected List<OadrInfo> oadrInfo;

        /**
         * 获取oadrServiceName属性的值。
         * 
         * @return
         *     possible object is
         *     {@link OadrServiceNameType }
         *     
         */
        public OadrServiceNameType getOadrServiceName() {
            return oadrServiceName;
        }

        /**
         * 设置oadrServiceName属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link OadrServiceNameType }
         *     
         */
        public void setOadrServiceName(OadrServiceNameType value) {
            this.oadrServiceName = value;
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
