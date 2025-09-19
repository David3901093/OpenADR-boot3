//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.openadr.oadr_2_0b._2012._07;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>oadrLoadControlStateTypeType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="oadrLoadControlStateTypeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="oadrMin" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
 *         &lt;element name="oadrMax" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
 *         &lt;element name="oadrCurrent" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="oadrNormal" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oadrLoadControlStateTypeType", propOrder = {
    "oadrMin",
    "oadrMax",
    "oadrCurrent",
    "oadrNormal"
})
public class OadrLoadControlStateTypeType {

    protected Float oadrMin;
    protected Float oadrMax;
    protected float oadrCurrent;
    protected Float oadrNormal;

    /**
     * 获取oadrMin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getOadrMin() {
        return oadrMin;
    }

    /**
     * 设置oadrMin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setOadrMin(Float value) {
        this.oadrMin = value;
    }

    /**
     * 获取oadrMax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getOadrMax() {
        return oadrMax;
    }

    /**
     * 设置oadrMax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setOadrMax(Float value) {
        this.oadrMax = value;
    }

    /**
     * 获取oadrCurrent属性的值。
     * 
     */
    public float getOadrCurrent() {
        return oadrCurrent;
    }

    /**
     * 设置oadrCurrent属性的值。
     * 
     */
    public void setOadrCurrent(float value) {
        this.oadrCurrent = value;
    }

    /**
     * 获取oadrNormal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getOadrNormal() {
        return oadrNormal;
    }

    /**
     * 设置oadrNormal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setOadrNormal(Float value) {
        this.oadrNormal = value;
    }

}
