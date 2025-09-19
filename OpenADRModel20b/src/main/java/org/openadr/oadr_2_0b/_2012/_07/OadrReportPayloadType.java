//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.openadr.oadr_2_0b._2012._07;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.oasis_open.docs.ns.energyinterop._201110.ReportPayloadType;


/**
 * Report payload for use in reports.
 * 
 * <p>oadrReportPayloadType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="oadrReportPayloadType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://docs.oasis-open.org/ns/energyinterop/201110}ReportPayloadType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrDataQuality" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oadrReportPayloadType", propOrder = {
    "oadrDataQuality"
})
public class OadrReportPayloadType
    extends ReportPayloadType
{

    protected String oadrDataQuality;

    /**
     * Enumerated value for the quality of this data item
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOadrDataQuality() {
        return oadrDataQuality;
    }

    /**
     * 设置oadrDataQuality属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOadrDataQuality(String value) {
        this.oadrDataQuality = value;
    }

}
