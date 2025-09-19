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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.HexBinaryAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * [extension] Contains attributes related to the configuration of the time service.
 * 
 * <p>TimeConfiguration complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TimeConfiguration"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dstEndRule" type="{http://naesb.org/espi}DstRuleType"/&gt;
 *         &lt;element name="dstOffset" type="{http://naesb.org/espi}TimeType"/&gt;
 *         &lt;element name="dstStartRule" type="{http://naesb.org/espi}DstRuleType"/&gt;
 *         &lt;element name="tzOffset" type="{http://naesb.org/espi}TimeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeConfiguration", propOrder = {
    "dstEndRule",
    "dstOffset",
    "dstStartRule",
    "tzOffset"
})
public class TimeConfiguration
    extends IdentifiedObject
{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] dstEndRule;
    protected long dstOffset;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] dstStartRule;
    protected long tzOffset;

    /**
     * 获取dstEndRule属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getDstEndRule() {
        return dstEndRule;
    }

    /**
     * 设置dstEndRule属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDstEndRule(byte[] value) {
        this.dstEndRule = value;
    }

    /**
     * 获取dstOffset属性的值。
     * 
     */
    public long getDstOffset() {
        return dstOffset;
    }

    /**
     * 设置dstOffset属性的值。
     * 
     */
    public void setDstOffset(long value) {
        this.dstOffset = value;
    }

    /**
     * 获取dstStartRule属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getDstStartRule() {
        return dstStartRule;
    }

    /**
     * 设置dstStartRule属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDstStartRule(byte[] value) {
        this.dstStartRule = value;
    }

    /**
     * 获取tzOffset属性的值。
     * 
     */
    public long getTzOffset() {
        return tzOffset;
    }

    /**
     * 设置tzOffset属性的值。
     * 
     */
    public void setTzOffset(long value) {
        this.tzOffset = value;
    }

}
