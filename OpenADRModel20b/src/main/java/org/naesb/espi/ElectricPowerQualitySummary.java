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


/**
 * A summary of power quality events. This information represents a summary of power quality information typically required by customer facility energy management systems. It is not intended to satisfy the detailed requirements of power quality monitoring. All values are as defined by measurementProtocol during the period. The standards typically also give ranges of allowed values; the information attributes are the raw measurements, not the "yes/no" determination by the various standards. See referenced standards for definition, measurement protocol and period.
 * 
 * <p>ElectricPowerQualitySummary complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ElectricPowerQualitySummary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="flickerPlt" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="flickerPst" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="harmonicVoltage" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="longInterruptions" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="mainsVoltage" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="measurementProtocol" type="{http://naesb.org/espi}UInt8" minOccurs="0"/&gt;
 *         &lt;element name="powerFrequency" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="rapidVoltageChanges" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="shortInterruptions" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="summaryInterval" type="{http://naesb.org/espi}DateTimeInterval"/&gt;
 *         &lt;element name="supplyVoltageDips" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="supplyVoltageImbalance" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="supplyVoltageVariations" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="tempOvervoltage" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectricPowerQualitySummary", propOrder = {
    "flickerPlt",
    "flickerPst",
    "harmonicVoltage",
    "longInterruptions",
    "mainsVoltage",
    "measurementProtocol",
    "powerFrequency",
    "rapidVoltageChanges",
    "shortInterruptions",
    "summaryInterval",
    "supplyVoltageDips",
    "supplyVoltageImbalance",
    "supplyVoltageVariations",
    "tempOvervoltage"
})
public class ElectricPowerQualitySummary
    extends IdentifiedObject
{

    protected Long flickerPlt;
    protected Long flickerPst;
    protected Long harmonicVoltage;
    protected Long longInterruptions;
    protected Long mainsVoltage;
    @XmlSchemaType(name = "unsignedByte")
    protected Short measurementProtocol;
    protected Long powerFrequency;
    protected Long rapidVoltageChanges;
    protected Long shortInterruptions;
    @XmlElement(required = true)
    protected DateTimeInterval summaryInterval;
    protected Long supplyVoltageDips;
    protected Long supplyVoltageImbalance;
    protected Long supplyVoltageVariations;
    protected Long tempOvervoltage;

    /**
     * 获取flickerPlt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFlickerPlt() {
        return flickerPlt;
    }

    /**
     * 设置flickerPlt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFlickerPlt(Long value) {
        this.flickerPlt = value;
    }

    /**
     * 获取flickerPst属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFlickerPst() {
        return flickerPst;
    }

    /**
     * 设置flickerPst属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFlickerPst(Long value) {
        this.flickerPst = value;
    }

    /**
     * 获取harmonicVoltage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHarmonicVoltage() {
        return harmonicVoltage;
    }

    /**
     * 设置harmonicVoltage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHarmonicVoltage(Long value) {
        this.harmonicVoltage = value;
    }

    /**
     * 获取longInterruptions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLongInterruptions() {
        return longInterruptions;
    }

    /**
     * 设置longInterruptions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLongInterruptions(Long value) {
        this.longInterruptions = value;
    }

    /**
     * 获取mainsVoltage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMainsVoltage() {
        return mainsVoltage;
    }

    /**
     * 设置mainsVoltage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMainsVoltage(Long value) {
        this.mainsVoltage = value;
    }

    /**
     * 获取measurementProtocol属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getMeasurementProtocol() {
        return measurementProtocol;
    }

    /**
     * 设置measurementProtocol属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setMeasurementProtocol(Short value) {
        this.measurementProtocol = value;
    }

    /**
     * 获取powerFrequency属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPowerFrequency() {
        return powerFrequency;
    }

    /**
     * 设置powerFrequency属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPowerFrequency(Long value) {
        this.powerFrequency = value;
    }

    /**
     * 获取rapidVoltageChanges属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRapidVoltageChanges() {
        return rapidVoltageChanges;
    }

    /**
     * 设置rapidVoltageChanges属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRapidVoltageChanges(Long value) {
        this.rapidVoltageChanges = value;
    }

    /**
     * 获取shortInterruptions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getShortInterruptions() {
        return shortInterruptions;
    }

    /**
     * 设置shortInterruptions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setShortInterruptions(Long value) {
        this.shortInterruptions = value;
    }

    /**
     * 获取summaryInterval属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *     
     */
    public DateTimeInterval getSummaryInterval() {
        return summaryInterval;
    }

    /**
     * 设置summaryInterval属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *     
     */
    public void setSummaryInterval(DateTimeInterval value) {
        this.summaryInterval = value;
    }

    /**
     * 获取supplyVoltageDips属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSupplyVoltageDips() {
        return supplyVoltageDips;
    }

    /**
     * 设置supplyVoltageDips属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSupplyVoltageDips(Long value) {
        this.supplyVoltageDips = value;
    }

    /**
     * 获取supplyVoltageImbalance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSupplyVoltageImbalance() {
        return supplyVoltageImbalance;
    }

    /**
     * 设置supplyVoltageImbalance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSupplyVoltageImbalance(Long value) {
        this.supplyVoltageImbalance = value;
    }

    /**
     * 获取supplyVoltageVariations属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSupplyVoltageVariations() {
        return supplyVoltageVariations;
    }

    /**
     * 设置supplyVoltageVariations属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSupplyVoltageVariations(Long value) {
        this.supplyVoltageVariations = value;
    }

    /**
     * 获取tempOvervoltage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTempOvervoltage() {
        return tempOvervoltage;
    }

    /**
     * 设置tempOvervoltage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTempOvervoltage(Long value) {
        this.tempOvervoltage = value;
    }

}
