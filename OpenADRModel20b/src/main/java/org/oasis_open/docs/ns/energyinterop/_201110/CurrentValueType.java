//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>currentValueType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="currentValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}payloadFloat"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "currentValueType", propOrder = {
    "payloadFloat"
})
public class CurrentValueType {

    protected PayloadFloatType payloadFloat;

    /**
     * 获取payloadFloat属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PayloadFloatType }
     *     
     */
    public PayloadFloatType getPayloadFloat() {
        return payloadFloat;
    }

    /**
     * 设置payloadFloat属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PayloadFloatType }
     *     
     */
    public void setPayloadFloat(PayloadFloatType value) {
        this.payloadFloat = value;
    }

}
