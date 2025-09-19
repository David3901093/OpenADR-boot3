//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>eiEventSignalsType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="eiEventSignalsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiEventSignal" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiEventBaseline" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eiEventSignalsType", propOrder = {
    "eiEventSignal",
    "eiEventBaseline"
})
public class EiEventSignalsType {

    @XmlElement(required = true)
    protected List<EiEventSignalType> eiEventSignal;
    protected EiEventBaselineType eiEventBaseline;

    /**
     * Interval data for an event Gets the value of the eiEventSignal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eiEventSignal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEiEventSignal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EiEventSignalType }
     * 
     * 
     */
    public List<EiEventSignalType> getEiEventSignal() {
        if (eiEventSignal == null) {
            eiEventSignal = new ArrayList<EiEventSignalType>();
        }
        return this.eiEventSignal;
    }

    /**
     * Interval data for a baseline
     * 
     * @return
     *     possible object is
     *     {@link EiEventBaselineType }
     *     
     */
    public EiEventBaselineType getEiEventBaseline() {
        return eiEventBaseline;
    }

    /**
     * 设置eiEventBaseline属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EiEventBaselineType }
     *     
     */
    public void setEiEventBaseline(EiEventBaselineType value) {
        this.eiEventBaseline = value;
    }

}
