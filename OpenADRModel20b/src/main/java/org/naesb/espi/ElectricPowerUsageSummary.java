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
import jakarta.xml.bind.annotation.XmlType;


/**
 * Summary of usage for a billing period
 * 
 * <p>ElectricPowerUsageSummary complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ElectricPowerUsageSummary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="billingPeriod" type="{http://naesb.org/espi}DateTimeInterval" minOccurs="0"/&gt;
 *         &lt;element name="billLastPeriod" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="billToDate" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="costAdditionalLastPeriod" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="costAdditionalDetailLastPeriod" type="{http://naesb.org/espi}LineItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="currency" type="{http://naesb.org/espi}Currency" minOccurs="0"/&gt;
 *         &lt;element name="overallConsumptionLastPeriod" type="{http://naesb.org/espi}SummaryMeasurement" minOccurs="0"/&gt;
 *         &lt;element name="currentBillingPeriodOverAllConsumption" type="{http://naesb.org/espi}SummaryMeasurement" minOccurs="0"/&gt;
 *         &lt;element name="currentDayLastYearNetConsumption" type="{http://naesb.org/espi}SummaryMeasurement" minOccurs="0"/&gt;
 *         &lt;element name="currentDayNetConsumption" type="{http://naesb.org/espi}SummaryMeasurement" minOccurs="0"/&gt;
 *         &lt;element name="currentDayOverallConsumption" type="{http://naesb.org/espi}SummaryMeasurement" minOccurs="0"/&gt;
 *         &lt;element name="peakDemand" type="{http://naesb.org/espi}SummaryMeasurement" minOccurs="0"/&gt;
 *         &lt;element name="previousDayLastYearOverallConsumption" type="{http://naesb.org/espi}SummaryMeasurement" minOccurs="0"/&gt;
 *         &lt;element name="previousDayNetConsumption" type="{http://naesb.org/espi}SummaryMeasurement" minOccurs="0"/&gt;
 *         &lt;element name="previousDayOverallConsumption" type="{http://naesb.org/espi}SummaryMeasurement" minOccurs="0"/&gt;
 *         &lt;element name="qualityOfReading" type="{http://naesb.org/espi}QualityOfReading" minOccurs="0"/&gt;
 *         &lt;element name="ratchetDemand" type="{http://naesb.org/espi}SummaryMeasurement" minOccurs="0"/&gt;
 *         &lt;element name="ratchetDemandPeriod" type="{http://naesb.org/espi}DateTimeInterval" minOccurs="0"/&gt;
 *         &lt;element name="statusTimeStamp" type="{http://naesb.org/espi}TimeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectricPowerUsageSummary", propOrder = {
    "billingPeriod",
    "billLastPeriod",
    "billToDate",
    "costAdditionalLastPeriod",
    "costAdditionalDetailLastPeriod",
    "currency",
    "overallConsumptionLastPeriod",
    "currentBillingPeriodOverAllConsumption",
    "currentDayLastYearNetConsumption",
    "currentDayNetConsumption",
    "currentDayOverallConsumption",
    "peakDemand",
    "previousDayLastYearOverallConsumption",
    "previousDayNetConsumption",
    "previousDayOverallConsumption",
    "qualityOfReading",
    "ratchetDemand",
    "ratchetDemandPeriod",
    "statusTimeStamp"
})
public class ElectricPowerUsageSummary
    extends IdentifiedObject
{

    protected DateTimeInterval billingPeriod;
    protected Long billLastPeriod;
    protected Long billToDate;
    protected Long costAdditionalLastPeriod;
    protected List<LineItem> costAdditionalDetailLastPeriod;
    protected String currency;
    protected SummaryMeasurement overallConsumptionLastPeriod;
    protected SummaryMeasurement currentBillingPeriodOverAllConsumption;
    protected SummaryMeasurement currentDayLastYearNetConsumption;
    protected SummaryMeasurement currentDayNetConsumption;
    protected SummaryMeasurement currentDayOverallConsumption;
    protected SummaryMeasurement peakDemand;
    protected SummaryMeasurement previousDayLastYearOverallConsumption;
    protected SummaryMeasurement previousDayNetConsumption;
    protected SummaryMeasurement previousDayOverallConsumption;
    protected String qualityOfReading;
    protected SummaryMeasurement ratchetDemand;
    protected DateTimeInterval ratchetDemandPeriod;
    protected long statusTimeStamp;

    /**
     * 获取billingPeriod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *     
     */
    public DateTimeInterval getBillingPeriod() {
        return billingPeriod;
    }

    /**
     * 设置billingPeriod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *     
     */
    public void setBillingPeriod(DateTimeInterval value) {
        this.billingPeriod = value;
    }

    /**
     * 获取billLastPeriod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBillLastPeriod() {
        return billLastPeriod;
    }

    /**
     * 设置billLastPeriod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBillLastPeriod(Long value) {
        this.billLastPeriod = value;
    }

    /**
     * 获取billToDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBillToDate() {
        return billToDate;
    }

    /**
     * 设置billToDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBillToDate(Long value) {
        this.billToDate = value;
    }

    /**
     * 获取costAdditionalLastPeriod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCostAdditionalLastPeriod() {
        return costAdditionalLastPeriod;
    }

    /**
     * 设置costAdditionalLastPeriod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCostAdditionalLastPeriod(Long value) {
        this.costAdditionalLastPeriod = value;
    }

    /**
     * Gets the value of the costAdditionalDetailLastPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the costAdditionalDetailLastPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCostAdditionalDetailLastPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineItem }
     * 
     * 
     */
    public List<LineItem> getCostAdditionalDetailLastPeriod() {
        if (costAdditionalDetailLastPeriod == null) {
            costAdditionalDetailLastPeriod = new ArrayList<LineItem>();
        }
        return this.costAdditionalDetailLastPeriod;
    }

    /**
     * 获取currency属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 设置currency属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * 获取overallConsumptionLastPeriod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SummaryMeasurement }
     *     
     */
    public SummaryMeasurement getOverallConsumptionLastPeriod() {
        return overallConsumptionLastPeriod;
    }

    /**
     * 设置overallConsumptionLastPeriod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryMeasurement }
     *     
     */
    public void setOverallConsumptionLastPeriod(SummaryMeasurement value) {
        this.overallConsumptionLastPeriod = value;
    }

    /**
     * 获取currentBillingPeriodOverAllConsumption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SummaryMeasurement }
     *     
     */
    public SummaryMeasurement getCurrentBillingPeriodOverAllConsumption() {
        return currentBillingPeriodOverAllConsumption;
    }

    /**
     * 设置currentBillingPeriodOverAllConsumption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryMeasurement }
     *     
     */
    public void setCurrentBillingPeriodOverAllConsumption(SummaryMeasurement value) {
        this.currentBillingPeriodOverAllConsumption = value;
    }

    /**
     * 获取currentDayLastYearNetConsumption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SummaryMeasurement }
     *     
     */
    public SummaryMeasurement getCurrentDayLastYearNetConsumption() {
        return currentDayLastYearNetConsumption;
    }

    /**
     * 设置currentDayLastYearNetConsumption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryMeasurement }
     *     
     */
    public void setCurrentDayLastYearNetConsumption(SummaryMeasurement value) {
        this.currentDayLastYearNetConsumption = value;
    }

    /**
     * 获取currentDayNetConsumption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SummaryMeasurement }
     *     
     */
    public SummaryMeasurement getCurrentDayNetConsumption() {
        return currentDayNetConsumption;
    }

    /**
     * 设置currentDayNetConsumption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryMeasurement }
     *     
     */
    public void setCurrentDayNetConsumption(SummaryMeasurement value) {
        this.currentDayNetConsumption = value;
    }

    /**
     * 获取currentDayOverallConsumption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SummaryMeasurement }
     *     
     */
    public SummaryMeasurement getCurrentDayOverallConsumption() {
        return currentDayOverallConsumption;
    }

    /**
     * 设置currentDayOverallConsumption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryMeasurement }
     *     
     */
    public void setCurrentDayOverallConsumption(SummaryMeasurement value) {
        this.currentDayOverallConsumption = value;
    }

    /**
     * 获取peakDemand属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SummaryMeasurement }
     *     
     */
    public SummaryMeasurement getPeakDemand() {
        return peakDemand;
    }

    /**
     * 设置peakDemand属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryMeasurement }
     *     
     */
    public void setPeakDemand(SummaryMeasurement value) {
        this.peakDemand = value;
    }

    /**
     * 获取previousDayLastYearOverallConsumption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SummaryMeasurement }
     *     
     */
    public SummaryMeasurement getPreviousDayLastYearOverallConsumption() {
        return previousDayLastYearOverallConsumption;
    }

    /**
     * 设置previousDayLastYearOverallConsumption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryMeasurement }
     *     
     */
    public void setPreviousDayLastYearOverallConsumption(SummaryMeasurement value) {
        this.previousDayLastYearOverallConsumption = value;
    }

    /**
     * 获取previousDayNetConsumption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SummaryMeasurement }
     *     
     */
    public SummaryMeasurement getPreviousDayNetConsumption() {
        return previousDayNetConsumption;
    }

    /**
     * 设置previousDayNetConsumption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryMeasurement }
     *     
     */
    public void setPreviousDayNetConsumption(SummaryMeasurement value) {
        this.previousDayNetConsumption = value;
    }

    /**
     * 获取previousDayOverallConsumption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SummaryMeasurement }
     *     
     */
    public SummaryMeasurement getPreviousDayOverallConsumption() {
        return previousDayOverallConsumption;
    }

    /**
     * 设置previousDayOverallConsumption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryMeasurement }
     *     
     */
    public void setPreviousDayOverallConsumption(SummaryMeasurement value) {
        this.previousDayOverallConsumption = value;
    }

    /**
     * 获取qualityOfReading属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualityOfReading() {
        return qualityOfReading;
    }

    /**
     * 设置qualityOfReading属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualityOfReading(String value) {
        this.qualityOfReading = value;
    }

    /**
     * 获取ratchetDemand属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SummaryMeasurement }
     *     
     */
    public SummaryMeasurement getRatchetDemand() {
        return ratchetDemand;
    }

    /**
     * 设置ratchetDemand属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryMeasurement }
     *     
     */
    public void setRatchetDemand(SummaryMeasurement value) {
        this.ratchetDemand = value;
    }

    /**
     * 获取ratchetDemandPeriod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *     
     */
    public DateTimeInterval getRatchetDemandPeriod() {
        return ratchetDemandPeriod;
    }

    /**
     * 设置ratchetDemandPeriod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *     
     */
    public void setRatchetDemandPeriod(DateTimeInterval value) {
        this.ratchetDemandPeriod = value;
    }

    /**
     * 获取statusTimeStamp属性的值。
     * 
     */
    public long getStatusTimeStamp() {
        return statusTimeStamp;
    }

    /**
     * 设置statusTimeStamp属性的值。
     * 
     */
    public void setStatusTimeStamp(long value) {
        this.statusTimeStamp = value;
    }

}
