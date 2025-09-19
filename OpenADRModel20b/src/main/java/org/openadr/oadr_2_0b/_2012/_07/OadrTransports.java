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
 *         &lt;element name="oadrTransport" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrTransportName"/&gt;
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
    "oadrTransport"
})
@XmlRootElement(name = "oadrTransports")
public class OadrTransports {

    @XmlElement(required = true)
    protected List<OadrTransports.OadrTransport> oadrTransport;

    /**
     * Gets the value of the oadrTransport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oadrTransport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOadrTransport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OadrTransports.OadrTransport }
     * 
     * 
     */
    public List<OadrTransports.OadrTransport> getOadrTransport() {
        if (oadrTransport == null) {
            oadrTransport = new ArrayList<OadrTransports.OadrTransport>();
        }
        return this.oadrTransport;
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
     *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrTransportName"/&gt;
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
        "oadrTransportName"
    })
    public static class OadrTransport {

        @XmlElement(required = true)
        @XmlSchemaType(name = "token")
        protected OadrTransportType oadrTransportName;

        /**
         * 获取oadrTransportName属性的值。
         * 
         * @return
         *     possible object is
         *     {@link OadrTransportType }
         *     
         */
        public OadrTransportType getOadrTransportName() {
            return oadrTransportName;
        }

        /**
         * 设置oadrTransportName属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link OadrTransportType }
         *     
         */
        public void setOadrTransportName(OadrTransportType value) {
            this.oadrTransportName = value;
        }

    }

}
