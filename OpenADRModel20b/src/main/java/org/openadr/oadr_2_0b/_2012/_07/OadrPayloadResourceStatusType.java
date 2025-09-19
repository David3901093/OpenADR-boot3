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
import org.oasis_open.docs.ns.energyinterop._201110.PayloadBaseType;


/**
 * This is the payload for reports that require a status.
 * 
 * <p>oadrPayloadResourceStatusType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="oadrPayloadResourceStatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://docs.oasis-open.org/ns/energyinterop/201110}PayloadBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="oadrOnline" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="oadrManualOverride" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrLoadControlState" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oadrPayloadResourceStatusType", propOrder = {
    "oadrOnline",
    "oadrManualOverride",
    "oadrLoadControlState"
})
public class OadrPayloadResourceStatusType
    extends PayloadBaseType
{

    protected boolean oadrOnline;
    protected boolean oadrManualOverride;
    protected OadrLoadControlStateType oadrLoadControlState;

    /**
     * 获取oadrOnline属性的值。
     * 
     */
    public boolean isOadrOnline() {
        return oadrOnline;
    }

    /**
     * 设置oadrOnline属性的值。
     * 
     */
    public void setOadrOnline(boolean value) {
        this.oadrOnline = value;
    }

    /**
     * 获取oadrManualOverride属性的值。
     * 
     */
    public boolean isOadrManualOverride() {
        return oadrManualOverride;
    }

    /**
     * 设置oadrManualOverride属性的值。
     * 
     */
    public void setOadrManualOverride(boolean value) {
        this.oadrManualOverride = value;
    }

    /**
     * 获取oadrLoadControlState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrLoadControlStateType }
     *     
     */
    public OadrLoadControlStateType getOadrLoadControlState() {
        return oadrLoadControlState;
    }

    /**
     * 设置oadrLoadControlState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrLoadControlStateType }
     *     
     */
    public void setOadrLoadControlState(OadrLoadControlStateType value) {
        this.oadrLoadControlState = value;
    }

}
