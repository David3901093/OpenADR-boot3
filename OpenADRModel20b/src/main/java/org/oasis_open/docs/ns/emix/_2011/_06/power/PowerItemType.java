//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.emix._2011._06.power;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.oasis_open.docs.ns.emix._2011._06.ItemBaseType;


/**
 * Base for the measurement of Power
 * 
 * <p>PowerItemType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PowerItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://docs.oasis-open.org/ns/emix/2011/06}ItemBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="itemUnits" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/emix/2011/06/siscale}siScaleCode"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/emix/2011/06/power}powerAttributes"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerItemType", propOrder = {
    "itemDescription",
    "itemUnits",
    "siScaleCode",
    "powerAttributes"
})
@XmlSeeAlso({
    PowerApparentType.class,
    PowerReactiveType.class,
    PowerRealType.class
})
public abstract class PowerItemType
    extends ItemBaseType
{

    @XmlElement(required = true)
    protected String itemDescription;
    @XmlElement(required = true)
    protected String itemUnits;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/emix/2011/06/siscale", required = true)
    protected String siScaleCode;
    @XmlElement(required = true)
    protected PowerAttributesType powerAttributes;

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

    /**
     * 获取powerAttributes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PowerAttributesType }
     *     
     */
    public PowerAttributesType getPowerAttributes() {
        return powerAttributes;
    }

    /**
     * 设置powerAttributes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PowerAttributesType }
     *     
     */
    public void setPowerAttributes(PowerAttributesType value) {
        this.powerAttributes = value;
    }

}
