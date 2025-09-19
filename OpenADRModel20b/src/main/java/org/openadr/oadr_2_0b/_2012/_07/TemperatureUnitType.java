//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package org.openadr.oadr_2_0b._2012._07;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>temperatureUnitType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="temperatureUnitType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="celsius"/&gt;
 *     &lt;enumeration value="fahrenheit"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "temperatureUnitType")
@XmlEnum
public enum TemperatureUnitType {

    @XmlEnumValue("celsius")
    CELSIUS("celsius"),
    @XmlEnumValue("fahrenheit")
    FAHRENHEIT("fahrenheit");
    private final String value;

    TemperatureUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TemperatureUnitType fromValue(String v) {
        for (TemperatureUnitType c: TemperatureUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
