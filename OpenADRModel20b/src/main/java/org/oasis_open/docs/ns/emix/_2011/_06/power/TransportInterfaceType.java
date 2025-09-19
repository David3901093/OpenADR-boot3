//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.emix._2011._06.power;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The Transport Interface delineates the edges at either end of a transport segment.
 * 
 * <p>TransportInterfaceType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TransportInterfaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pointOfReceipt" type="{http://docs.oasis-open.org/ns/emix/2011/06/power}NodeType"/&gt;
 *         &lt;element name="pointOfDelivery" type="{http://docs.oasis-open.org/ns/emix/2011/06/power}NodeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportInterfaceType", propOrder = {
    "pointOfReceipt",
    "pointOfDelivery"
})
public class TransportInterfaceType {

    @XmlElement(required = true)
    protected String pointOfReceipt;
    @XmlElement(required = true)
    protected String pointOfDelivery;

    /**
     * 获取pointOfReceipt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPointOfReceipt() {
        return pointOfReceipt;
    }

    /**
     * 设置pointOfReceipt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPointOfReceipt(String value) {
        this.pointOfReceipt = value;
    }

    /**
     * 获取pointOfDelivery属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPointOfDelivery() {
        return pointOfDelivery;
    }

    /**
     * 设置pointOfDelivery属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPointOfDelivery(String value) {
        this.pointOfDelivery = value;
    }

}
