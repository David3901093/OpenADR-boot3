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
 * <p>OptReasonEnumeratedType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="OptReasonEnumeratedType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="economic"/&gt;
 *     &lt;enumeration value="emergency"/&gt;
 *     &lt;enumeration value="mustRun"/&gt;
 *     &lt;enumeration value="notParticipating"/&gt;
 *     &lt;enumeration value="outageRunStatus"/&gt;
 *     &lt;enumeration value="overrideStatus"/&gt;
 *     &lt;enumeration value="participating"/&gt;
 *     &lt;enumeration value="x-schedule"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OptReasonEnumeratedType")
@XmlEnum
public enum OptReasonEnumeratedType {

    @XmlEnumValue("economic")
    ECONOMIC("economic"),
    @XmlEnumValue("emergency")
    EMERGENCY("emergency"),
    @XmlEnumValue("mustRun")
    MUST_RUN("mustRun"),
    @XmlEnumValue("notParticipating")
    NOT_PARTICIPATING("notParticipating"),
    @XmlEnumValue("outageRunStatus")
    OUTAGE_RUN_STATUS("outageRunStatus"),
    @XmlEnumValue("overrideStatus")
    OVERRIDE_STATUS("overrideStatus"),
    @XmlEnumValue("participating")
    PARTICIPATING("participating"),
    @XmlEnumValue("x-schedule")
    X_SCHEDULE("x-schedule");
    private final String value;

    OptReasonEnumeratedType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OptReasonEnumeratedType fromValue(String v) {
        for (OptReasonEnumeratedType c: OptReasonEnumeratedType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
