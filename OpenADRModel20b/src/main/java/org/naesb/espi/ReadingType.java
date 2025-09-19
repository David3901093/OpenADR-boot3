//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.naesb.espi;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Characteristics associated with all Readings included in a MeterReading.
 * 
 * <p>ReadingType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReadingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accumulationBehaviour" type="{http://naesb.org/espi}AccumulationKind" minOccurs="0"/&gt;
 *         &lt;element name="commodity" type="{http://naesb.org/espi}CommodityKind" minOccurs="0"/&gt;
 *         &lt;element name="consumptionTier" type="{http://naesb.org/espi}Int16" minOccurs="0"/&gt;
 *         &lt;element name="currency" type="{http://naesb.org/espi}Currency" minOccurs="0"/&gt;
 *         &lt;element name="dataQualifier" type="{http://naesb.org/espi}DataQualifierKind" minOccurs="0"/&gt;
 *         &lt;element name="defaultQuality" type="{http://naesb.org/espi}QualityOfReading" minOccurs="0"/&gt;
 *         &lt;element name="flowDirection" type="{http://naesb.org/espi}FlowDirectionKind" minOccurs="0"/&gt;
 *         &lt;element name="intervalLength" type="{http://naesb.org/espi}UInt32" minOccurs="0"/&gt;
 *         &lt;element name="kind" type="{http://naesb.org/espi}MeasurementKind" minOccurs="0"/&gt;
 *         &lt;element name="phase" type="{http://naesb.org/espi}PhaseCodeKind" minOccurs="0"/&gt;
 *         &lt;element name="powerOfTenMultiplier" type="{http://naesb.org/espi}UnitMultiplierKind" minOccurs="0"/&gt;
 *         &lt;element name="timeAttribute" type="{http://naesb.org/espi}TimePeriodOfInterest" minOccurs="0"/&gt;
 *         &lt;element name="tou" type="{http://naesb.org/espi}Int16" minOccurs="0"/&gt;
 *         &lt;element name="uom" type="{http://naesb.org/espi}UnitSymbolKind" minOccurs="0"/&gt;
 *         &lt;element name="cpp" type="{http://naesb.org/espi}Int16" minOccurs="0"/&gt;
 *         &lt;element name="interharmonic" type="{http://naesb.org/espi}ReadingInterharmonic" minOccurs="0"/&gt;
 *         &lt;element name="measuringPeriod" type="{http://naesb.org/espi}TimeAttributeKind" minOccurs="0"/&gt;
 *         &lt;element name="argument" type="{http://naesb.org/espi}RationalNumber" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadingType", propOrder = {
    "accumulationBehaviour",
    "commodity",
    "consumptionTier",
    "currency",
    "dataQualifier",
    "defaultQuality",
    "flowDirection",
    "intervalLength",
    "kind",
    "phase",
    "powerOfTenMultiplier",
    "timeAttribute",
    "tou",
    "uom",
    "cpp",
    "interharmonic",
    "measuringPeriod",
    "argument"
})
public class ReadingType
    extends IdentifiedObject
{

    protected String accumulationBehaviour;
    protected String commodity;
    protected Short consumptionTier;
    protected String currency;
    protected String dataQualifier;
    protected String defaultQuality;
    protected String flowDirection;
    @XmlSchemaType(name = "unsignedInt")
    protected Long intervalLength;
    protected String kind;
    protected String phase;
    protected String powerOfTenMultiplier;
    protected String timeAttribute;
    protected Short tou;
    protected String uom;
    protected Short cpp;
    protected ReadingInterharmonic interharmonic;
    protected String measuringPeriod;
    protected RationalNumber argument;

    /**
     * 获取accumulationBehaviour属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccumulationBehaviour() {
        return accumulationBehaviour;
    }

    /**
     * 设置accumulationBehaviour属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccumulationBehaviour(String value) {
        this.accumulationBehaviour = value;
    }

    /**
     * 获取commodity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommodity() {
        return commodity;
    }

    /**
     * 设置commodity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommodity(String value) {
        this.commodity = value;
    }

    /**
     * 获取consumptionTier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getConsumptionTier() {
        return consumptionTier;
    }

    /**
     * 设置consumptionTier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setConsumptionTier(Short value) {
        this.consumptionTier = value;
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
     * 获取dataQualifier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataQualifier() {
        return dataQualifier;
    }

    /**
     * 设置dataQualifier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataQualifier(String value) {
        this.dataQualifier = value;
    }

    /**
     * 获取defaultQuality属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultQuality() {
        return defaultQuality;
    }

    /**
     * 设置defaultQuality属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultQuality(String value) {
        this.defaultQuality = value;
    }

    /**
     * 获取flowDirection属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlowDirection() {
        return flowDirection;
    }

    /**
     * 设置flowDirection属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlowDirection(String value) {
        this.flowDirection = value;
    }

    /**
     * 获取intervalLength属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIntervalLength() {
        return intervalLength;
    }

    /**
     * 设置intervalLength属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIntervalLength(Long value) {
        this.intervalLength = value;
    }

    /**
     * 获取kind属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKind() {
        return kind;
    }

    /**
     * 设置kind属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKind(String value) {
        this.kind = value;
    }

    /**
     * 获取phase属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhase() {
        return phase;
    }

    /**
     * 设置phase属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhase(String value) {
        this.phase = value;
    }

    /**
     * 获取powerOfTenMultiplier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPowerOfTenMultiplier() {
        return powerOfTenMultiplier;
    }

    /**
     * 设置powerOfTenMultiplier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPowerOfTenMultiplier(String value) {
        this.powerOfTenMultiplier = value;
    }

    /**
     * 获取timeAttribute属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeAttribute() {
        return timeAttribute;
    }

    /**
     * 设置timeAttribute属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeAttribute(String value) {
        this.timeAttribute = value;
    }

    /**
     * 获取tou属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getTou() {
        return tou;
    }

    /**
     * 设置tou属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setTou(Short value) {
        this.tou = value;
    }

    /**
     * 获取uom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUom() {
        return uom;
    }

    /**
     * 设置uom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUom(String value) {
        this.uom = value;
    }

    /**
     * 获取cpp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCpp() {
        return cpp;
    }

    /**
     * 设置cpp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCpp(Short value) {
        this.cpp = value;
    }

    /**
     * 获取interharmonic属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReadingInterharmonic }
     *     
     */
    public ReadingInterharmonic getInterharmonic() {
        return interharmonic;
    }

    /**
     * 设置interharmonic属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingInterharmonic }
     *     
     */
    public void setInterharmonic(ReadingInterharmonic value) {
        this.interharmonic = value;
    }

    /**
     * 获取measuringPeriod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasuringPeriod() {
        return measuringPeriod;
    }

    /**
     * 设置measuringPeriod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasuringPeriod(String value) {
        this.measuringPeriod = value;
    }

    /**
     * 获取argument属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RationalNumber }
     *     
     */
    public RationalNumber getArgument() {
        return argument;
    }

    /**
     * 设置argument属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RationalNumber }
     *     
     */
    public void setArgument(RationalNumber value) {
        this.argument = value;
    }

}
