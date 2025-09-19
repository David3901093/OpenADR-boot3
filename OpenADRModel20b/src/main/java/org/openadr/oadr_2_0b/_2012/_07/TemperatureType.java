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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import org.oasis_open.docs.ns.emix._2011._06.ItemBaseType;


/**
 * temperature
 * 
 * <p>temperatureType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="temperatureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://docs.oasis-open.org/ns/emix/2011/06}ItemBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="itemUnits" type="{http://openadr.org/oadr-2.0b/2012/07}temperatureUnitType"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/emix/2011/06/siscale}siScaleCode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "temperatureType", propOrder = {
    "itemDescription",
    "itemUnits",
    "siScaleCode"
})
public class TemperatureType
    extends ItemBaseType
{

    @XmlElement(required = true)
    protected String itemDescription;
    @XmlElement(required = true)
    @XmlSchemaType(name = "token")
    protected TemperatureUnitType itemUnits;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/emix/2011/06/siscale", required = true)
    protected String siScaleCode;

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
     *     {@link TemperatureUnitType }
     *     
     */
    public TemperatureUnitType getItemUnits() {
        return itemUnits;
    }

    /**
     * 设置itemUnits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureUnitType }
     *     
     */
    public void setItemUnits(TemperatureUnitType value) {
        this.itemUnits = value;
    }

    /**
     * 获取siScaleCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiScaleCode() {
        return siScaleCode;
    }

    /**
     * 设置siScaleCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiScaleCode(String value) {
        this.siScaleCode = value;
    }

}
