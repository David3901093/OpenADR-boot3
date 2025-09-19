//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.w3._2009.xmldsig11_;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>FieldIDType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="FieldIDType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://www.w3.org/2009/xmldsig11#}Prime"/&gt;
 *         &lt;element ref="{http://www.w3.org/2009/xmldsig11#}TnB"/&gt;
 *         &lt;element ref="{http://www.w3.org/2009/xmldsig11#}PnB"/&gt;
 *         &lt;element ref="{http://www.w3.org/2009/xmldsig11#}GnB"/&gt;
 *         &lt;any processContents='lax' namespace='##other'/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FieldIDType", propOrder = {
    "prime",
    "tnB",
    "pnB",
    "gnB",
    "any"
})
public class FieldIDType {

    @XmlElement(name = "Prime")
    protected PrimeFieldParamsType prime;
    @XmlElement(name = "TnB")
    protected TnBFieldParamsType tnB;
    @XmlElement(name = "PnB")
    protected PnBFieldParamsType pnB;
    @XmlElement(name = "GnB")
    protected CharTwoFieldParamsType gnB;
    @XmlAnyElement(lax = true)
    protected Object any;

    /**
     * 获取prime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PrimeFieldParamsType }
     *     
     */
    public PrimeFieldParamsType getPrime() {
        return prime;
    }

    /**
     * 设置prime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PrimeFieldParamsType }
     *     
     */
    public void setPrime(PrimeFieldParamsType value) {
        this.prime = value;
    }

    /**
     * 获取tnB属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TnBFieldParamsType }
     *     
     */
    public TnBFieldParamsType getTnB() {
        return tnB;
    }

    /**
     * 设置tnB属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TnBFieldParamsType }
     *     
     */
    public void setTnB(TnBFieldParamsType value) {
        this.tnB = value;
    }

    /**
     * 获取pnB属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PnBFieldParamsType }
     *     
     */
    public PnBFieldParamsType getPnB() {
        return pnB;
    }

    /**
     * 设置pnB属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PnBFieldParamsType }
     *     
     */
    public void setPnB(PnBFieldParamsType value) {
        this.pnB = value;
    }

    /**
     * 获取gnB属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CharTwoFieldParamsType }
     *     
     */
    public CharTwoFieldParamsType getGnB() {
        return gnB;
    }

    /**
     * 设置gnB属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CharTwoFieldParamsType }
     *     
     */
    public void setGnB(CharTwoFieldParamsType value) {
        this.gnB = value;
    }

    /**
     * 获取any属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     {@link Object }
     *     
     */
    public Object getAny() {
        return any;
    }

    /**
     * 设置any属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     {@link Object }
     *     
     */
    public void setAny(Object value) {
        this.any = value;
    }

}
