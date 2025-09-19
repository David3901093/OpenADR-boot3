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
 * <p>oadrLoadControlStateType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="oadrLoadControlStateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="oadrCapacity" type="{http://openadr.org/oadr-2.0b/2012/07}oadrLoadControlStateTypeType" minOccurs="0"/&gt;
 *         &lt;element name="oadrLevelOffset" type="{http://openadr.org/oadr-2.0b/2012/07}oadrLoadControlStateTypeType" minOccurs="0"/&gt;
 *         &lt;element name="oadrPercentOffset" type="{http://openadr.org/oadr-2.0b/2012/07}oadrLoadControlStateTypeType" minOccurs="0"/&gt;
 *         &lt;element name="oadrSetPoint" type="{http://openadr.org/oadr-2.0b/2012/07}oadrLoadControlStateTypeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oadrLoadControlStateType", propOrder = {
    "oadrCapacity",
    "oadrLevelOffset",
    "oadrPercentOffset",
    "oadrSetPoint"
})
public class OadrLoadControlStateType {

    protected OadrLoadControlStateTypeType oadrCapacity;
    protected OadrLoadControlStateTypeType oadrLevelOffset;
    protected OadrLoadControlStateTypeType oadrPercentOffset;
    protected OadrLoadControlStateTypeType oadrSetPoint;

    /**
     * 获取oadrCapacity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrLoadControlStateTypeType }
     *     
     */
    public OadrLoadControlStateTypeType getOadrCapacity() {
        return oadrCapacity;
    }

    /**
     * 设置oadrCapacity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrLoadControlStateTypeType }
     *     
     */
    public void setOadrCapacity(OadrLoadControlStateTypeType value) {
        this.oadrCapacity = value;
    }

    /**
     * 获取oadrLevelOffset属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrLoadControlStateTypeType }
     *     
     */
    public OadrLoadControlStateTypeType getOadrLevelOffset() {
        return oadrLevelOffset;
    }

    /**
     * 设置oadrLevelOffset属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrLoadControlStateTypeType }
     *     
     */
    public void setOadrLevelOffset(OadrLoadControlStateTypeType value) {
        this.oadrLevelOffset = value;
    }

    /**
     * 获取oadrPercentOffset属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrLoadControlStateTypeType }
     *     
     */
    public OadrLoadControlStateTypeType getOadrPercentOffset() {
        return oadrPercentOffset;
    }

    /**
     * 设置oadrPercentOffset属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrLoadControlStateTypeType }
     *     
     */
    public void setOadrPercentOffset(OadrLoadControlStateTypeType value) {
        this.oadrPercentOffset = value;
    }

    /**
     * 获取oadrSetPoint属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrLoadControlStateTypeType }
     *     
     */
    public OadrLoadControlStateTypeType getOadrSetPoint() {
        return oadrSetPoint;
    }

    /**
     * 设置oadrSetPoint属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrLoadControlStateTypeType }
     *     
     */
    public void setOadrSetPoint(OadrLoadControlStateTypeType value) {
        this.oadrSetPoint = value;
    }

}
