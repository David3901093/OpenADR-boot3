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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>PnBFieldParamsType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PnBFieldParamsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.w3.org/2009/xmldsig11#}CharTwoFieldParamsType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="K1" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="K2" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="K3" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PnBFieldParamsType", propOrder = {
    "k1",
    "k2",
    "k3"
})
public class PnBFieldParamsType
    extends CharTwoFieldParamsType
{

    @XmlElement(name = "K1", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger k1;
    @XmlElement(name = "K2", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger k2;
    @XmlElement(name = "K3", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger k3;

    /**
     * 获取k1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getK1() {
        return k1;
    }

    /**
     * 设置k1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setK1(BigInteger value) {
        this.k1 = value;
    }

    /**
     * 获取k2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getK2() {
        return k2;
    }

    /**
     * 设置k2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setK2(BigInteger value) {
        this.k2 = value;
    }

    /**
     * 获取k3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getK3() {
        return k3;
    }

    /**
     * 设置k3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setK3(BigInteger value) {
        this.k3 = value;
    }

}
