//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.w3._2009.xmldsig11_;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>CurveType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CurveType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="A" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/&gt;
 *         &lt;element name="B" type="{http://www.w3.org/2000/09/xmldsig#}CryptoBinary"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurveType", propOrder = {
    "a",
    "b"
})
public class CurveType {

    @XmlElement(name = "A", required = true)
    protected byte[] a;
    @XmlElement(name = "B", required = true)
    protected byte[] b;

    /**
     * 获取a属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getA() {
        return a;
    }

    /**
     * 设置a属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setA(byte[] value) {
        this.a = value;
    }

    /**
     * 获取b属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getB() {
        return b;
    }

    /**
     * 设置b属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setB(byte[] value) {
        this.b = value;
    }

}
