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
 * <p>SignalTypeEnumeratedType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="SignalTypeEnumeratedType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="delta"/&gt;
 *     &lt;enumeration value="level"/&gt;
 *     &lt;enumeration value="multiplier"/&gt;
 *     &lt;enumeration value="price"/&gt;
 *     &lt;enumeration value="priceMultiplier"/&gt;
 *     &lt;enumeration value="priceRelative"/&gt;
 *     &lt;enumeration value="setpoint"/&gt;
 *     &lt;enumeration value="x-loadControlCapacity"/&gt;
 *     &lt;enumeration value="x-loadControlLevelOffset"/&gt;
 *     &lt;enumeration value="x-loadControlPercentOffset"/&gt;
 *     &lt;enumeration value="x-loadControlSetpoint"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SignalTypeEnumeratedType")
@XmlEnum
public enum SignalTypeEnumeratedType {


    /**
     * Signal indicates the amount to change from what one would have used without the signal.
     * 
     */
    @XmlEnumValue("delta")
    DELTA("delta"),

    /**
     * Signal indicates a program level.
     * 
     */
    @XmlEnumValue("level")
    LEVEL("level"),

    /**
     * Signal indicates a multiplier applied to the current rate of  delivery or usage from what one would have used without the signal.
     * 
     */
    @XmlEnumValue("multiplier")
    MULTIPLIER("multiplier"),

    /**
     * Signal indicates the price.
     * 
     */
    @XmlEnumValue("price")
    PRICE("price"),

    /**
     * Signal indicates the price multiplier. Extended price is the computed price value multiplied by the number of units.
     * 
     */
    @XmlEnumValue("priceMultiplier")
    PRICE_MULTIPLIER("priceMultiplier"),

    /**
     * Signal indicates the relative price.
     * 
     */
    @XmlEnumValue("priceRelative")
    PRICE_RELATIVE("priceRelative"),

    /**
     * Signal indicates a target amount of units.
     * 
     */
    @XmlEnumValue("setpoint")
    SETPOINT("setpoint"),

    /**
     * This is an instruction for the load controller to operate at a level that is some percentage of its maximum load consumption capacity. This can be mapped to specific load controllers to do things like duty cycling. Note that 1.0 refers to 100% consumption. In the case of simple ON/OFF type devices then 0 = OFF and 1 = ON.
     * 
     */
    @XmlEnumValue("x-loadControlCapacity")
    X_LOAD_CONTROL_CAPACITY("x-loadControlCapacity"),

    /**
     * Discrete integer levels that are relative to normal operations where 0 is normal operations.
     * 
     */
    @XmlEnumValue("x-loadControlLevelOffset")
    X_LOAD_CONTROL_LEVEL_OFFSET("x-loadControlLevelOffset"),

    /**
     * Percentage change from normal load control operations.
     * 
     */
    @XmlEnumValue("x-loadControlPercentOffset")
    X_LOAD_CONTROL_PERCENT_OFFSET("x-loadControlPercentOffset"),

    /**
     * Load controller set points.
     * 
     */
    @XmlEnumValue("x-loadControlSetpoint")
    X_LOAD_CONTROL_SETPOINT("x-loadControlSetpoint");
    private final String value;

    SignalTypeEnumeratedType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SignalTypeEnumeratedType fromValue(String v) {
        for (SignalTypeEnumeratedType c: SignalTypeEnumeratedType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
