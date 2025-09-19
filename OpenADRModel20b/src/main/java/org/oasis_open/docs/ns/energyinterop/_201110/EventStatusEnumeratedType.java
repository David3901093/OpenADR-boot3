//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>EventStatusEnumeratedType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="EventStatusEnumeratedType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="none"/&gt;
 *     &lt;enumeration value="far"/&gt;
 *     &lt;enumeration value="near"/&gt;
 *     &lt;enumeration value="active"/&gt;
 *     &lt;enumeration value="completed"/&gt;
 *     &lt;enumeration value="cancelled"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EventStatusEnumeratedType")
@XmlEnum
public enum EventStatusEnumeratedType {


    /**
     * No event pending
     * 
     */
    @XmlEnumValue("none")
    NONE("none"),

    /**
     * Event pending in the far future. The exact definition of how far in the future this refers is dependent upon the market context, but typically means the next day.
     * 
     */
    @XmlEnumValue("far")
    FAR("far"),

    /**
     * Event pending in the near future. The exact definition of how near in the future the pending event is active is dependent on the market context.
     * 
     */
    @XmlEnumValue("near")
    NEAR("near"),

    /**
     * The event has been initiated and is currently active.
     * 
     */
    @XmlEnumValue("active")
    ACTIVE("active"),

    /**
     * The event has completed.
     * 
     */
    @XmlEnumValue("completed")
    COMPLETED("completed"),

    /**
     * The event has been canceled.
     * 
     */
    @XmlEnumValue("cancelled")
    CANCELLED("cancelled");
    private final String value;

    EventStatusEnumeratedType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EventStatusEnumeratedType fromValue(String v) {
        for (EventStatusEnumeratedType c: EventStatusEnumeratedType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
