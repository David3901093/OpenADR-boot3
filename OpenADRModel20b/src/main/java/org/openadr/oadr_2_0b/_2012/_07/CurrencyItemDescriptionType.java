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
 * <p>currencyItemDescriptionType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="currencyItemDescriptionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="currency"/&gt;
 *     &lt;enumeration value="currencyPerKW"/&gt;
 *     &lt;enumeration value="currencyPerKWh"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "currencyItemDescriptionType")
@XmlEnum
public enum CurrencyItemDescriptionType {

    @XmlEnumValue("currency")
    CURRENCY("currency"),
    @XmlEnumValue("currencyPerKW")
    CURRENCY_PER_KW("currencyPerKW"),
    @XmlEnumValue("currencyPerKWh")
    CURRENCY_PER_K_WH("currencyPerKWh");
    private final String value;

    CurrencyItemDescriptionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CurrencyItemDescriptionType fromValue(String v) {
        for (CurrencyItemDescriptionType c: CurrencyItemDescriptionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
