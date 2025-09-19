//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.w3._2009.xmldsig11_;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>ECParametersType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ECParametersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FieldID" type="{http://www.w3.org/2009/xmldsig11#}FieldIDType"/&gt;
 *         &lt;element name="Curve" type="{http://www.w3.org/2009/xmldsig11#}CurveType"/&gt;
 *         &lt;element name="Base" type="{http://www.w3.org/2009/xmldsig11#}ECPointType"/&gt;
 *         &lt;element name="Order" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/&gt;
 *         &lt;element name="CoFactor" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="ValidationData" type="{http://www.w3.org/2009/xmldsig11#}ECValidationDataType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ECParametersType", propOrder = {
    "fieldID",
    "curve",
    "base",
    "order",
    "coFactor",
    "validationData"
})
public class ECParametersType {

    @XmlElement(name = "FieldID", required = true)
    protected FieldIDType fieldID;
    @XmlElement(name = "Curve", required = true)
    protected CurveType curve;
    @XmlElement(name = "Base", required = true)
    protected byte[] base;
    @XmlElement(name = "Order", required = true)
    protected byte[] order;
    @XmlElement(name = "CoFactor")
    protected BigInteger coFactor;
    @XmlElement(name = "ValidationData")
    protected ECValidationDataType validationData;

    /**
     * 获取fieldID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FieldIDType }
     *     
     */
    public FieldIDType getFieldID() {
        return fieldID;
    }

    /**
     * 设置fieldID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FieldIDType }
     *     
     */
    public void setFieldID(FieldIDType value) {
        this.fieldID = value;
    }

    /**
     * 获取curve属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CurveType }
     *     
     */
    public CurveType getCurve() {
        return curve;
    }

    /**
     * 设置curve属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CurveType }
     *     
     */
    public void setCurve(CurveType value) {
        this.curve = value;
    }

    /**
     * 获取base属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBase() {
        return base;
    }

    /**
     * 设置base属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBase(byte[] value) {
        this.base = value;
    }

    /**
     * 获取order属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getOrder() {
        return order;
    }

    /**
     * 设置order属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setOrder(byte[] value) {
        this.order = value;
    }

    /**
     * 获取coFactor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCoFactor() {
        return coFactor;
    }

    /**
     * 设置coFactor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCoFactor(BigInteger value) {
        this.coFactor = value;
    }

    /**
     * 获取validationData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ECValidationDataType }
     *     
     */
    public ECValidationDataType getValidationData() {
        return validationData;
    }

    /**
     * 设置validationData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ECValidationDataType }
     *     
     */
    public void setValidationData(ECValidationDataType value) {
        this.validationData = value;
    }

}
