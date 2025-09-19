//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.emix._2011._06;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.oasis_open.docs.ns.emix._2011._06.power.EnergyItemType;
import org.oasis_open.docs.ns.emix._2011._06.power.PowerItemType;
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
 * Abstract base type for units for EMIX Product delivery, measurement, and warrants.
 * 
 * <p>ItemBaseType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ItemBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemBaseType")
@XmlSeeAlso({
    BaseUnitType.class,
    CurrentType.class,
    CurrencyType.class,
    FrequencyType.class,
    ThermType.class,
    TemperatureType.class,
    PulseCountType.class,
    OadrGBItemBase.class,
    VoltageType.class,
    EnergyItemType.class,
    PowerItemType.class
})
public abstract class ItemBaseType {


}
