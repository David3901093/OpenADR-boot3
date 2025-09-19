//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.naesb.espi;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.HexBinaryAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Logical point on a network at which consumption or production is either physically measured (e.g., metered) or estimated (e.g., unmetered street lights).
 * 
 * <p>UsagePoint complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UsagePoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="roleFlags" type="{http://naesb.org/espi}HexBinary16" minOccurs="0"/&gt;
 *         &lt;element name="ServiceCategory" type="{http://naesb.org/espi}ServiceCategory" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://naesb.org/espi}UInt8" minOccurs="0"/&gt;
 *         &lt;element name="ServiceDeliveryPoint" type="{http://naesb.org/espi}ServiceDeliveryPoint" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsagePoint", propOrder = {
    "roleFlags",
    "serviceCategory",
    "status",
    "serviceDeliveryPoint"
})
public class UsagePoint
    extends IdentifiedObject
{

    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] roleFlags;
    @XmlElement(name = "ServiceCategory")
    protected ServiceCategory serviceCategory;
    @XmlSchemaType(name = "unsignedByte")
    protected Short status;
    @XmlElement(name = "ServiceDeliveryPoint")
    protected ServiceDeliveryPoint serviceDeliveryPoint;

    /**
     * 获取roleFlags属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getRoleFlags() {
        return roleFlags;
    }

    /**
     * 设置roleFlags属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleFlags(byte[] value) {
        this.roleFlags = value;
    }

    /**
     * 获取serviceCategory属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ServiceCategory }
     *     
     */
    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    /**
     * 设置serviceCategory属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCategory }
     *     
     */
    public void setServiceCategory(ServiceCategory value) {
        this.serviceCategory = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setStatus(Short value) {
        this.status = value;
    }

    /**
     * 获取serviceDeliveryPoint属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ServiceDeliveryPoint }
     *     
     */
    public ServiceDeliveryPoint getServiceDeliveryPoint() {
        return serviceDeliveryPoint;
    }

    /**
     * 设置serviceDeliveryPoint属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDeliveryPoint }
     *     
     */
    public void setServiceDeliveryPoint(ServiceDeliveryPoint value) {
        this.serviceDeliveryPoint = value;
    }

}
