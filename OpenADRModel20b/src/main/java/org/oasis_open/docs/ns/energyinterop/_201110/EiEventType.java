//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>eiEventType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="eiEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eventDescriptor"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiActivePeriod"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiEventSignals"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiTarget"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eiEventType", propOrder = {
    "eventDescriptor",
    "eiActivePeriod",
    "eiEventSignals",
    "eiTarget"
})
public class EiEventType {

    @XmlElement(required = true)
    protected EventDescriptorType eventDescriptor;
    @XmlElement(required = true)
    protected EiActivePeriodType eiActivePeriod;
    @XmlElement(required = true)
    protected EiEventSignalsType eiEventSignals;
    @XmlElement(required = true)
    protected EiTargetType eiTarget;

    /**
     * 获取eventDescriptor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EventDescriptorType }
     *     
     */
    public EventDescriptorType getEventDescriptor() {
        return eventDescriptor;
    }

    /**
     * 设置eventDescriptor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EventDescriptorType }
     *     
     */
    public void setEventDescriptor(EventDescriptorType value) {
        this.eventDescriptor = value;
    }

    /**
     * 获取eiActivePeriod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EiActivePeriodType }
     *     
     */
    public EiActivePeriodType getEiActivePeriod() {
        return eiActivePeriod;
    }

    /**
     * 设置eiActivePeriod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EiActivePeriodType }
     *     
     */
    public void setEiActivePeriod(EiActivePeriodType value) {
        this.eiActivePeriod = value;
    }

    /**
     * 获取eiEventSignals属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EiEventSignalsType }
     *     
     */
    public EiEventSignalsType getEiEventSignals() {
        return eiEventSignals;
    }

    /**
     * 设置eiEventSignals属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EiEventSignalsType }
     *     
     */
    public void setEiEventSignals(EiEventSignalsType value) {
        this.eiEventSignals = value;
    }

    /**
     * 获取eiTarget属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EiTargetType }
     *     
     */
    public EiTargetType getEiTarget() {
        return eiTarget;
    }

    /**
     * 设置eiTarget属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EiTargetType }
     *     
     */
    public void setEiTarget(EiTargetType value) {
        this.eiTarget = value;
    }

}
