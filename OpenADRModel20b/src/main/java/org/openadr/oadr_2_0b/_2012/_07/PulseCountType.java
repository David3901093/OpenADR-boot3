//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.openadr.oadr_2_0b._2012._07;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.oasis_open.docs.ns.emix._2011._06.ItemBaseType;


/**
 * Pulse Count
 * 
 * <p>pulseCountType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="pulseCountType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://docs.oasis-open.org/ns/emix/2011/06}ItemBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="itemUnits" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}pulseFactor"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pulseCountType", propOrder = {
    "itemDescription",
    "itemUnits",
    "pulseFactor"
})
public class PulseCountType
    extends ItemBaseType
{

    @XmlElement(required = true)
    protected String itemDescription;
    @XmlElement(required = true)
    protected String itemUnits;
    protected float pulseFactor;

    /**
     * 获取itemDescription属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * 设置itemDescription属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemDescription(String value) {
        this.itemDescription = value;
    }

    /**
     * 获取itemUnits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemUnits() {
        return itemUnits;
    }

    /**
     * 设置itemUnits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemUnits(String value) {
        this.itemUnits = value;
    }

    /**
     * 获取pulseFactor属性的值。
     * 
     */
    public float getPulseFactor() {
        return pulseFactor;
    }

    /**
     * 设置pulseFactor属性的值。
     * 
     */
    public void setPulseFactor(float value) {
        this.pulseFactor = value;
    }

}
