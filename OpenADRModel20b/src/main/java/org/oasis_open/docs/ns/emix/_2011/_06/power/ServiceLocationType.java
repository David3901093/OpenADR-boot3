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
import jakarta.xml.bind.annotation.XmlType;
import net.opengis.gml._3.FeatureCollection;


/**
 * A customer ServiceLocation has one or more ServiceDeliveryPoint(s), which in turn relate to Meters. The location may be a point or a polygon, depending on the specific circumstances. For distribution, the ServiceLocation is typically the location of the utility customer's premise. 
 * 
 * <p>ServiceLocationType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ServiceLocationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}FeatureCollection"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceLocationType", propOrder = {
    "featureCollection"
})
public class ServiceLocationType {

    @XmlElement(name = "FeatureCollection", namespace = "http://www.opengis.net/gml/3.2", required = true)
    protected FeatureCollection featureCollection;

    /**
     * 获取featureCollection属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FeatureCollection }
     *     
     */
    public FeatureCollection getFeatureCollection() {
        return featureCollection;
    }

    /**
     * 设置featureCollection属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FeatureCollection }
     *     
     */
    public void setFeatureCollection(FeatureCollection value) {
        this.featureCollection = value;
    }

}
