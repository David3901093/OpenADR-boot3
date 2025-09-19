//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.oasis_open.docs.ns.energyinterop._201110;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>reportNameEnumeratedType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="reportNameEnumeratedType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="METADATA_HISTORY_USAGE"/&gt;
 *     &lt;enumeration value="HISTORY_USAGE"/&gt;
 *     &lt;enumeration value="METADATA_HISTORY_GREENBUTTON"/&gt;
 *     &lt;enumeration value="HISTORY_GREENBUTTON"/&gt;
 *     &lt;enumeration value="METADATA_TELEMETRY_USAGE"/&gt;
 *     &lt;enumeration value="TELEMETRY_USAGE"/&gt;
 *     &lt;enumeration value="METADATA_TELEMETRY_STATUS"/&gt;
 *     &lt;enumeration value="TELEMETRY_STATUS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "reportNameEnumeratedType")
@XmlEnum
public enum ReportNameEnumeratedType {

    METADATA_HISTORY_USAGE,
    HISTORY_USAGE,
    METADATA_HISTORY_GREENBUTTON,
    HISTORY_GREENBUTTON,
    METADATA_TELEMETRY_USAGE,
    TELEMETRY_USAGE,
    METADATA_TELEMETRY_STATUS,
    TELEMETRY_STATUS;

    public String value() {
        return name();
    }

    public static ReportNameEnumeratedType fromValue(String v) {
        return valueOf(v);
    }

}
