//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.openadr.oadr_2_0b._2012._07;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.oasis_open.docs.ns.energyinterop._201110.ReportSpecifierType;


/**
 * This type is used to request an EiReport
 * 
 * <p>oadrReportRequestType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="oadrReportRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}reportRequestID"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}reportSpecifier"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oadrReportRequestType", propOrder = {
    "reportRequestID",
    "reportSpecifier"
})
public class OadrReportRequestType {

    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected String reportRequestID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected ReportSpecifierType reportSpecifier;

    /**
     * 获取reportRequestID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportRequestID() {
        return reportRequestID;
    }

    /**
     * 设置reportRequestID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportRequestID(String value) {
        this.reportRequestID = value;
    }

    /**
     * 获取reportSpecifier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReportSpecifierType }
     *     
     */
    public ReportSpecifierType getReportSpecifier() {
        return reportSpecifier;
    }

    /**
     * 设置reportSpecifier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReportSpecifierType }
     *     
     */
    public void setReportSpecifier(ReportSpecifierType value) {
        this.reportSpecifier = value;
    }

}
