//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import ietf.params.xml.ns.icalendar_2_0.stream.Intervals;
import org.oasis_open.docs.ns.emix._2011._06.ItemBaseType;
import org.oasis_open.docs.ns.emix._2011._06.power.EnergyApparentType;
import org.oasis_open.docs.ns.emix._2011._06.power.EnergyItemType;
import org.oasis_open.docs.ns.emix._2011._06.power.EnergyReactiveType;
import org.oasis_open.docs.ns.emix._2011._06.power.EnergyRealType;
import org.oasis_open.docs.ns.emix._2011._06.power.PowerApparentType;
import org.oasis_open.docs.ns.emix._2011._06.power.PowerItemType;
import org.oasis_open.docs.ns.emix._2011._06.power.PowerReactiveType;
import org.oasis_open.docs.ns.emix._2011._06.power.PowerRealType;
import org.oasis_open.docs.ns.emix._2011._06.power.VoltageType;
import org.openadr.oadr_2_0b._2012._07.BaseUnitType;
import org.openadr.oadr_2_0b._2012._07.CurrencyType;
import org.openadr.oadr_2_0b._2012._07.CurrentType;
import org.openadr.oadr_2_0b._2012._07.FrequencyType;
import org.openadr.oadr_2_0b._2012._07.OadrGBItemBase;
import org.openadr.oadr_2_0b._2012._07.PulseCountType;
import org.openadr.oadr_2_0b._2012._07.TemperatureType;
import org.openadr.oadr_2_0b._2012._07.ThermType;


/**
 * <p>eiEventSignalType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="eiEventSignalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0:stream}intervals"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiTarget" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}signalName"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}signalType"/&gt;
 *         &lt;element name="signalID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/emix/2011/06}itemBase" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}currentValue" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eiEventSignalType", propOrder = {
    "intervals",
    "eiTarget",
    "signalName",
    "signalType",
    "signalID",
    "itemBase",
    "currentValue"
})
public class EiEventSignalType {

    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0:stream", required = true)
    protected Intervals intervals;
    protected EiTargetType eiTarget;
    @XmlElement(required = true)
    protected String signalName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "token")
    protected SignalTypeEnumeratedType signalType;
    @XmlElement(required = true)
    protected String signalID;
    @XmlElementRef(name = "itemBase", namespace = "http://docs.oasis-open.org/ns/emix/2011/06", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends ItemBaseType> itemBase;
    protected CurrentValueType currentValue;

    /**
     * 获取intervals属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Intervals }
     *     
     */
    public Intervals getIntervals() {
        return intervals;
    }

    /**
     * 设置intervals属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Intervals }
     *     
     */
    public void setIntervals(Intervals value) {
        this.intervals = value;
    }

    /**
     * Optionally identifies the device class associated with the signal. Only the endDeviceAsset subelement is used
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

    /**
     * Descriptive name for signal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignalName() {
        return signalName;
    }

    /**
     * 设置signalName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignalName(String value) {
        this.signalName = value;
    }

    /**
     * 获取signalType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SignalTypeEnumeratedType }
     *     
     */
    public SignalTypeEnumeratedType getSignalType() {
        return signalType;
    }

    /**
     * 设置signalType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SignalTypeEnumeratedType }
     *     
     */
    public void setSignalType(SignalTypeEnumeratedType value) {
        this.signalType = value;
    }

    /**
     * 获取signalID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignalID() {
        return signalID;
    }

    /**
     * 设置signalID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignalID(String value) {
        this.signalID = value;
    }

    /**
     * This is the unit of the signal.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ThermType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BaseUnitType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PowerApparentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PowerRealType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PowerReactiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PowerItemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EnergyReactiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EnergyApparentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EnergyRealType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EnergyItemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TemperatureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OadrGBItemBase }{@code >}
     *     {@link JAXBElement }{@code <}{@link VoltageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FrequencyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PulseCountType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ItemBaseType }{@code >}
     *     
     */
    public JAXBElement<? extends ItemBaseType> getItemBase() {
        return itemBase;
    }

    /**
     * 设置itemBase属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ThermType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BaseUnitType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PowerApparentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PowerRealType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PowerReactiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PowerItemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EnergyReactiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EnergyApparentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EnergyRealType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EnergyItemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TemperatureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OadrGBItemBase }{@code >}
     *     {@link JAXBElement }{@code <}{@link VoltageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FrequencyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PulseCountType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurrencyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ItemBaseType }{@code >}
     *     
     */
    public void setItemBase(JAXBElement<? extends ItemBaseType> value) {
        this.itemBase = value;
    }

    /**
     * 获取currentValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CurrentValueType }
     *     
     */
    public CurrentValueType getCurrentValue() {
        return currentValue;
    }

    /**
     * 设置currentValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentValueType }
     *     
     */
    public void setCurrentValue(CurrentValueType value) {
        this.currentValue = value;
    }

}
