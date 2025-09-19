//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}dtstart"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}duration"/&gt;
 *         &lt;element name="tolerance" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tolerate"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="startafter" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}x-eiNotification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}x-eiRampUp" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}x-eiRecovery" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dtstart",
    "duration",
    "tolerance",
    "xEiNotification",
    "xEiRampUp",
    "xEiRecovery"
})
@XmlRootElement(name = "properties")
public class Properties {

    @XmlElement(required = true)
    protected Dtstart dtstart;
    @XmlElement(required = true)
    protected DurationPropType duration;
    protected Properties.Tolerance tolerance;
    @XmlElement(name = "x-eiNotification", namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected DurationPropType xEiNotification;
    @XmlElement(name = "x-eiRampUp", namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected DurationPropType xEiRampUp;
    @XmlElement(name = "x-eiRecovery", namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected DurationPropType xEiRecovery;

    /**
     * 获取dtstart属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Dtstart }
     *     
     */
    public Dtstart getDtstart() {
        return dtstart;
    }

    /**
     * 设置dtstart属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Dtstart }
     *     
     */
    public void setDtstart(Dtstart value) {
        this.dtstart = value;
    }

    /**
     * 获取duration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getDuration() {
        return duration;
    }

    /**
     * 设置duration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setDuration(DurationPropType value) {
        this.duration = value;
    }

    /**
     * 获取tolerance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Properties.Tolerance }
     *     
     */
    public Properties.Tolerance getTolerance() {
        return tolerance;
    }

    /**
     * 设置tolerance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Properties.Tolerance }
     *     
     */
    public void setTolerance(Properties.Tolerance value) {
        this.tolerance = value;
    }

    /**
     * 获取xEiNotification属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getXEiNotification() {
        return xEiNotification;
    }

    /**
     * 设置xEiNotification属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setXEiNotification(DurationPropType value) {
        this.xEiNotification = value;
    }

    /**
     * 获取xEiRampUp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getXEiRampUp() {
        return xEiRampUp;
    }

    /**
     * 设置xEiRampUp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setXEiRampUp(DurationPropType value) {
        this.xEiRampUp = value;
    }

    /**
     * 获取xEiRecovery属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getXEiRecovery() {
        return xEiRecovery;
    }

    /**
     * 设置xEiRecovery属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setXEiRecovery(DurationPropType value) {
        this.xEiRecovery = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="tolerate"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="startafter" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "tolerate"
    })
    public static class Tolerance {

        @XmlElement(required = true)
        protected Properties.Tolerance.Tolerate tolerate;

        /**
         * 获取tolerate属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Properties.Tolerance.Tolerate }
         *     
         */
        public Properties.Tolerance.Tolerate getTolerate() {
            return tolerate;
        }

        /**
         * 设置tolerate属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Properties.Tolerance.Tolerate }
         *     
         */
        public void setTolerate(Properties.Tolerance.Tolerate value) {
            this.tolerate = value;
        }


        /**
         * <p>anonymous complex type的 Java 类。
         * 
         * <p>以下模式片段指定包含在此类中的预期内容。
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="startafter" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "startafter"
        })
        public static class Tolerate {

            protected String startafter;

            /**
             * 获取startafter属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStartafter() {
                return startafter;
            }

            /**
             * 设置startafter属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStartafter(String value) {
                this.startafter = value;
            }

        }

    }

}
