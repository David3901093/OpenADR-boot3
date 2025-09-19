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
import jakarta.xml.bind.annotation.XmlType;


/**
 * [extension] Line item of detail for additional cost
 * 
 * <p>LineItem complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LineItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="amount" type="{http://naesb.org/espi}Int48"/&gt;
 *         &lt;element name="rounding" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="dateTime" type="{http://naesb.org/espi}TimeType"/&gt;
 *         &lt;element name="note" type="{http://naesb.org/espi}String256"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineItem", propOrder = {
    "amount",
    "rounding",
    "dateTime",
    "note"
})
public class LineItem {

    protected long amount;
    protected Long rounding;
    protected long dateTime;
    @XmlElement(required = true)
    protected String note;

    /**
     * 获取amount属性的值。
     * 
     */
    public long getAmount() {
        return amount;
    }

    /**
     * 设置amount属性的值。
     * 
     */
    public void setAmount(long value) {
        this.amount = value;
    }

    /**
     * 获取rounding属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRounding() {
        return rounding;
    }

    /**
     * 设置rounding属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRounding(Long value) {
        this.rounding = value;
    }

    /**
     * 获取dateTime属性的值。
     * 
     */
    public long getDateTime() {
        return dateTime;
    }

    /**
     * 设置dateTime属性的值。
     * 
     */
    public void setDateTime(long value) {
        this.dateTime = value;
    }

    /**
     * 获取note属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置note属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

}
