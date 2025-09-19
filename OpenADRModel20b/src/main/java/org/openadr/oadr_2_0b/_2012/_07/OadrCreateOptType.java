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
import org.oasis_open.docs.ns.energyinterop._201110.EiOptType;
import org.oasis_open.docs.ns.energyinterop._201110.EiTargetType;
import org.oasis_open.docs.ns.energyinterop._201110.QualifiedEventIDType;


/**
 * <p>oadrCreateOptType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="oadrCreateOptType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://docs.oasis-open.org/ns/energyinterop/201110}EiOptType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110/payloads}requestID"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}qualifiedEventID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiTarget"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrDeviceClass" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oadrCreateOptType", propOrder = {
    "requestID",
    "qualifiedEventID",
    "eiTarget",
    "oadrDeviceClass"
})
public class OadrCreateOptType
    extends EiOptType
{

    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110/payloads", required = true)
    protected String requestID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected QualifiedEventIDType qualifiedEventID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected EiTargetType eiTarget;
    protected EiTargetType oadrDeviceClass;

    /**
     * 获取requestID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * 设置requestID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestID(String value) {
        this.requestID = value;
    }

    /**
     * 获取qualifiedEventID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link QualifiedEventIDType }
     *     
     */
    public QualifiedEventIDType getQualifiedEventID() {
        return qualifiedEventID;
    }

    /**
     * 设置qualifiedEventID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link QualifiedEventIDType }
     *     
     */
    public void setQualifiedEventID(QualifiedEventIDType value) {
        this.qualifiedEventID = value;
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

    /**
     * 获取oadrDeviceClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EiTargetType }
     *     
     */
    public EiTargetType getOadrDeviceClass() {
        return oadrDeviceClass;
    }

    /**
     * 设置oadrDeviceClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EiTargetType }
     *     
     */
    public void setOadrDeviceClass(EiTargetType value) {
        this.oadrDeviceClass = value;
    }

}
