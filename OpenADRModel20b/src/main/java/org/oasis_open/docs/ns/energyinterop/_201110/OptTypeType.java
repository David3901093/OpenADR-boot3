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
 * <p>OptTypeType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="OptTypeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="optIn"/&gt;
 *     &lt;enumeration value="optOut"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OptTypeType")
@XmlEnum
public enum OptTypeType {

    @XmlEnumValue("optIn")
    OPT_IN("optIn"),
    @XmlEnumValue("optOut")
    OPT_OUT("optOut");
    private final String value;

    OptTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OptTypeType fromValue(String v) {
        for (OptTypeType c: OptTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
