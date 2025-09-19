//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.openadr.oadr_2_0b._2012._07;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrDistributeEvent"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCreatedEvent"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrRequestEvent"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrResponse"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCancelOpt"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCanceledOpt"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCreateOpt"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCreatedOpt"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCancelReport"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCanceledReport"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCreateReport"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCreatedReport"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrRegisterReport"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrRegisteredReport"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrUpdateReport"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrUpdatedReport"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCancelPartyRegistration"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCanceledPartyRegistration"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCreatePartyRegistration"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrCreatedPartyRegistration"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrRequestReregistration"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrQueryRegistration"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrPoll"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "oadrDistributeEvent",
    "oadrCreatedEvent",
    "oadrRequestEvent",
    "oadrResponse",
    "oadrCancelOpt",
    "oadrCanceledOpt",
    "oadrCreateOpt",
    "oadrCreatedOpt",
    "oadrCancelReport",
    "oadrCanceledReport",
    "oadrCreateReport",
    "oadrCreatedReport",
    "oadrRegisterReport",
    "oadrRegisteredReport",
    "oadrUpdateReport",
    "oadrUpdatedReport",
    "oadrCancelPartyRegistration",
    "oadrCanceledPartyRegistration",
    "oadrCreatePartyRegistration",
    "oadrCreatedPartyRegistration",
    "oadrRequestReregistration",
    "oadrQueryRegistration",
    "oadrPoll"
})
@XmlRootElement(name = "oadrSignedObject")
public class OadrSignedObject {

    protected OadrDistributeEventType oadrDistributeEvent;
    protected OadrCreatedEventType oadrCreatedEvent;
    protected OadrRequestEventType oadrRequestEvent;
    protected OadrResponseType oadrResponse;
    protected OadrCancelOptType oadrCancelOpt;
    protected OadrCanceledOptType oadrCanceledOpt;
    protected OadrCreateOptType oadrCreateOpt;
    protected OadrCreatedOptType oadrCreatedOpt;
    protected OadrCancelReportType oadrCancelReport;
    protected OadrCanceledReportType oadrCanceledReport;
    protected OadrCreateReportType oadrCreateReport;
    protected OadrCreatedReportType oadrCreatedReport;
    protected OadrRegisterReportType oadrRegisterReport;
    protected OadrRegisteredReportType oadrRegisteredReport;
    protected OadrUpdateReportType oadrUpdateReport;
    protected OadrUpdatedReportType oadrUpdatedReport;
    protected OadrCancelPartyRegistrationType oadrCancelPartyRegistration;
    protected OadrCanceledPartyRegistrationType oadrCanceledPartyRegistration;
    protected OadrCreatePartyRegistrationType oadrCreatePartyRegistration;
    protected OadrCreatedPartyRegistrationType oadrCreatedPartyRegistration;
    protected OadrRequestReregistrationType oadrRequestReregistration;
    protected OadrQueryRegistrationType oadrQueryRegistration;
    protected OadrPollType oadrPoll;
    @XmlAttribute(name = "Id", namespace = "http://openadr.org/oadr-2.0b/2012/07")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * 获取oadrDistributeEvent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrDistributeEventType }
     *     
     */
    public OadrDistributeEventType getOadrDistributeEvent() {
        return oadrDistributeEvent;
    }

    /**
     * 设置oadrDistributeEvent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrDistributeEventType }
     *     
     */
    public void setOadrDistributeEvent(OadrDistributeEventType value) {
        this.oadrDistributeEvent = value;
    }

    /**
     * 获取oadrCreatedEvent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCreatedEventType }
     *     
     */
    public OadrCreatedEventType getOadrCreatedEvent() {
        return oadrCreatedEvent;
    }

    /**
     * 设置oadrCreatedEvent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCreatedEventType }
     *     
     */
    public void setOadrCreatedEvent(OadrCreatedEventType value) {
        this.oadrCreatedEvent = value;
    }

    /**
     * 获取oadrRequestEvent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrRequestEventType }
     *     
     */
    public OadrRequestEventType getOadrRequestEvent() {
        return oadrRequestEvent;
    }

    /**
     * 设置oadrRequestEvent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrRequestEventType }
     *     
     */
    public void setOadrRequestEvent(OadrRequestEventType value) {
        this.oadrRequestEvent = value;
    }

    /**
     * 获取oadrResponse属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrResponseType }
     *     
     */
    public OadrResponseType getOadrResponse() {
        return oadrResponse;
    }

    /**
     * 设置oadrResponse属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrResponseType }
     *     
     */
    public void setOadrResponse(OadrResponseType value) {
        this.oadrResponse = value;
    }

    /**
     * 获取oadrCancelOpt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCancelOptType }
     *     
     */
    public OadrCancelOptType getOadrCancelOpt() {
        return oadrCancelOpt;
    }

    /**
     * 设置oadrCancelOpt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCancelOptType }
     *     
     */
    public void setOadrCancelOpt(OadrCancelOptType value) {
        this.oadrCancelOpt = value;
    }

    /**
     * 获取oadrCanceledOpt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCanceledOptType }
     *     
     */
    public OadrCanceledOptType getOadrCanceledOpt() {
        return oadrCanceledOpt;
    }

    /**
     * 设置oadrCanceledOpt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCanceledOptType }
     *     
     */
    public void setOadrCanceledOpt(OadrCanceledOptType value) {
        this.oadrCanceledOpt = value;
    }

    /**
     * 获取oadrCreateOpt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCreateOptType }
     *     
     */
    public OadrCreateOptType getOadrCreateOpt() {
        return oadrCreateOpt;
    }

    /**
     * 设置oadrCreateOpt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCreateOptType }
     *     
     */
    public void setOadrCreateOpt(OadrCreateOptType value) {
        this.oadrCreateOpt = value;
    }

    /**
     * 获取oadrCreatedOpt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCreatedOptType }
     *     
     */
    public OadrCreatedOptType getOadrCreatedOpt() {
        return oadrCreatedOpt;
    }

    /**
     * 设置oadrCreatedOpt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCreatedOptType }
     *     
     */
    public void setOadrCreatedOpt(OadrCreatedOptType value) {
        this.oadrCreatedOpt = value;
    }

    /**
     * 获取oadrCancelReport属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCancelReportType }
     *     
     */
    public OadrCancelReportType getOadrCancelReport() {
        return oadrCancelReport;
    }

    /**
     * 设置oadrCancelReport属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCancelReportType }
     *     
     */
    public void setOadrCancelReport(OadrCancelReportType value) {
        this.oadrCancelReport = value;
    }

    /**
     * 获取oadrCanceledReport属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCanceledReportType }
     *     
     */
    public OadrCanceledReportType getOadrCanceledReport() {
        return oadrCanceledReport;
    }

    /**
     * 设置oadrCanceledReport属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCanceledReportType }
     *     
     */
    public void setOadrCanceledReport(OadrCanceledReportType value) {
        this.oadrCanceledReport = value;
    }

    /**
     * 获取oadrCreateReport属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCreateReportType }
     *     
     */
    public OadrCreateReportType getOadrCreateReport() {
        return oadrCreateReport;
    }

    /**
     * 设置oadrCreateReport属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCreateReportType }
     *     
     */
    public void setOadrCreateReport(OadrCreateReportType value) {
        this.oadrCreateReport = value;
    }

    /**
     * 获取oadrCreatedReport属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCreatedReportType }
     *     
     */
    public OadrCreatedReportType getOadrCreatedReport() {
        return oadrCreatedReport;
    }

    /**
     * 设置oadrCreatedReport属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCreatedReportType }
     *     
     */
    public void setOadrCreatedReport(OadrCreatedReportType value) {
        this.oadrCreatedReport = value;
    }

    /**
     * 获取oadrRegisterReport属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrRegisterReportType }
     *     
     */
    public OadrRegisterReportType getOadrRegisterReport() {
        return oadrRegisterReport;
    }

    /**
     * 设置oadrRegisterReport属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrRegisterReportType }
     *     
     */
    public void setOadrRegisterReport(OadrRegisterReportType value) {
        this.oadrRegisterReport = value;
    }

    /**
     * 获取oadrRegisteredReport属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrRegisteredReportType }
     *     
     */
    public OadrRegisteredReportType getOadrRegisteredReport() {
        return oadrRegisteredReport;
    }

    /**
     * 设置oadrRegisteredReport属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrRegisteredReportType }
     *     
     */
    public void setOadrRegisteredReport(OadrRegisteredReportType value) {
        this.oadrRegisteredReport = value;
    }

    /**
     * 获取oadrUpdateReport属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrUpdateReportType }
     *     
     */
    public OadrUpdateReportType getOadrUpdateReport() {
        return oadrUpdateReport;
    }

    /**
     * 设置oadrUpdateReport属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrUpdateReportType }
     *     
     */
    public void setOadrUpdateReport(OadrUpdateReportType value) {
        this.oadrUpdateReport = value;
    }

    /**
     * 获取oadrUpdatedReport属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrUpdatedReportType }
     *     
     */
    public OadrUpdatedReportType getOadrUpdatedReport() {
        return oadrUpdatedReport;
    }

    /**
     * 设置oadrUpdatedReport属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrUpdatedReportType }
     *     
     */
    public void setOadrUpdatedReport(OadrUpdatedReportType value) {
        this.oadrUpdatedReport = value;
    }

    /**
     * 获取oadrCancelPartyRegistration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCancelPartyRegistrationType }
     *     
     */
    public OadrCancelPartyRegistrationType getOadrCancelPartyRegistration() {
        return oadrCancelPartyRegistration;
    }

    /**
     * 设置oadrCancelPartyRegistration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCancelPartyRegistrationType }
     *     
     */
    public void setOadrCancelPartyRegistration(OadrCancelPartyRegistrationType value) {
        this.oadrCancelPartyRegistration = value;
    }

    /**
     * 获取oadrCanceledPartyRegistration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCanceledPartyRegistrationType }
     *     
     */
    public OadrCanceledPartyRegistrationType getOadrCanceledPartyRegistration() {
        return oadrCanceledPartyRegistration;
    }

    /**
     * 设置oadrCanceledPartyRegistration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCanceledPartyRegistrationType }
     *     
     */
    public void setOadrCanceledPartyRegistration(OadrCanceledPartyRegistrationType value) {
        this.oadrCanceledPartyRegistration = value;
    }

    /**
     * 获取oadrCreatePartyRegistration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCreatePartyRegistrationType }
     *     
     */
    public OadrCreatePartyRegistrationType getOadrCreatePartyRegistration() {
        return oadrCreatePartyRegistration;
    }

    /**
     * 设置oadrCreatePartyRegistration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCreatePartyRegistrationType }
     *     
     */
    public void setOadrCreatePartyRegistration(OadrCreatePartyRegistrationType value) {
        this.oadrCreatePartyRegistration = value;
    }

    /**
     * 获取oadrCreatedPartyRegistration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrCreatedPartyRegistrationType }
     *     
     */
    public OadrCreatedPartyRegistrationType getOadrCreatedPartyRegistration() {
        return oadrCreatedPartyRegistration;
    }

    /**
     * 设置oadrCreatedPartyRegistration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCreatedPartyRegistrationType }
     *     
     */
    public void setOadrCreatedPartyRegistration(OadrCreatedPartyRegistrationType value) {
        this.oadrCreatedPartyRegistration = value;
    }

    /**
     * 获取oadrRequestReregistration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrRequestReregistrationType }
     *     
     */
    public OadrRequestReregistrationType getOadrRequestReregistration() {
        return oadrRequestReregistration;
    }

    /**
     * 设置oadrRequestReregistration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrRequestReregistrationType }
     *     
     */
    public void setOadrRequestReregistration(OadrRequestReregistrationType value) {
        this.oadrRequestReregistration = value;
    }

    /**
     * 获取oadrQueryRegistration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrQueryRegistrationType }
     *     
     */
    public OadrQueryRegistrationType getOadrQueryRegistration() {
        return oadrQueryRegistration;
    }

    /**
     * 设置oadrQueryRegistration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrQueryRegistrationType }
     *     
     */
    public void setOadrQueryRegistration(OadrQueryRegistrationType value) {
        this.oadrQueryRegistration = value;
    }

    /**
     * 获取oadrPoll属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OadrPollType }
     *     
     */
    public OadrPollType getOadrPoll() {
        return oadrPoll;
    }

    /**
     * 设置oadrPoll属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OadrPollType }
     *     
     */
    public void setOadrPoll(OadrPollType value) {
        this.oadrPoll = value;
    }

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
