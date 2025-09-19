//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.naesb.espi;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Specific value measured by a meter or other asset. Each Reading is associated with a specific ReadingType.
 * 
 * <p>IntervalReading complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="IntervalReading"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://naesb.org/espi}Object"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cost" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="ReadingQuality" type="{http://naesb.org/espi}ReadingQuality" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="timePeriod" type="{http://naesb.org/espi}DateTimeInterval" minOccurs="0"/&gt;
 *         &lt;element name="value" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntervalReading", propOrder = {
    "cost",
    "readingQuality",
    "timePeriod",
    "value"
})
public class IntervalReading
    extends Object
{

    protected Long cost;
    @XmlElement(name = "ReadingQuality")
    protected List<ReadingQuality> readingQuality;
    protected DateTimeInterval timePeriod;
    protected Long value;

    /**
     * 获取cost属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCost() {
        return cost;
    }

    /**
     * 设置cost属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCost(Long value) {
        this.cost = value;
    }

    /**
     * Gets the value of the readingQuality property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the readingQuality property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReadingQuality().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReadingQuality }
     * 
     * 
     */
    public List<ReadingQuality> getReadingQuality() {
        if (readingQuality == null) {
            readingQuality = new ArrayList<ReadingQuality>();
        }
        return this.readingQuality;
    }

    /**
     * 获取timePeriod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *     
     */
    public DateTimeInterval getTimePeriod() {
        return timePeriod;
    }

    /**
     * 设置timePeriod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *     
     */
    public void setTimePeriod(DateTimeInterval value) {
        this.timePeriod = value;
    }

    /**
     * 获取value属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getValue() {
        return value;
    }

    /**
     * 设置value属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setValue(Long value) {
        this.value = value;
    }

}
