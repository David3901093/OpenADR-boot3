//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.naesb.espi;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * [extension] Service Delivery Point is representation of revenue UsagePoint attributes
 * 
 * <p>ServiceDeliveryPoint complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ServiceDeliveryPoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://naesb.org/espi}Object"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://naesb.org/espi}String256" minOccurs="0"/&gt;
 *         &lt;element name="tariffProfile" type="{http://naesb.org/espi}String256" minOccurs="0"/&gt;
 *         &lt;element name="customerAgreement" type="{http://naesb.org/espi}String256" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceDeliveryPoint", propOrder = {
    "name",
    "tariffProfile",
    "customerAgreement"
})
public class ServiceDeliveryPoint
    extends Object
{

    protected String name;
    protected String tariffProfile;
    protected String customerAgreement;

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 获取tariffProfile属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffProfile() {
        return tariffProfile;
    }

    /**
     * 设置tariffProfile属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffProfile(String value) {
        this.tariffProfile = value;
    }

    /**
     * 获取customerAgreement属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerAgreement() {
        return customerAgreement;
    }

    /**
     * 设置customerAgreement属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerAgreement(String value) {
        this.customerAgreement = value;
    }

}
