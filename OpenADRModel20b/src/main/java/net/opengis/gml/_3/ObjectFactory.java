//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.2 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2025.07.07 时间 05:34:12 PM CST 
//


package net.opengis.gml._3;

import java.util.List;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.gml._3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PosList_QNAME = new QName("http://www.opengis.net/gml/3.2", "posList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.gml._3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FeatureCollection }
     * 
     */
    public FeatureCollection createFeatureCollection() {
        return new FeatureCollection();
    }

    /**
     * Create an instance of {@link FeatureCollection.Location }
     * 
     */
    public FeatureCollection.Location createFeatureCollectionLocation() {
        return new FeatureCollection.Location();
    }

    /**
     * Create an instance of {@link FeatureCollection.Location.Polygon }
     * 
     */
    public FeatureCollection.Location.Polygon createFeatureCollectionLocationPolygon() {
        return new FeatureCollection.Location.Polygon();
    }

    /**
     * Create an instance of {@link FeatureCollection.Location.Polygon.Exterior }
     * 
     */
    public FeatureCollection.Location.Polygon.Exterior createFeatureCollectionLocationPolygonExterior() {
        return new FeatureCollection.Location.Polygon.Exterior();
    }

    /**
     * Create an instance of {@link FeatureCollection.Location.Polygon.Exterior.LinearRing }
     * 
     */
    public FeatureCollection.Location.Polygon.Exterior.LinearRing createFeatureCollectionLocationPolygonExteriorLinearRing() {
        return new FeatureCollection.Location.Polygon.Exterior.LinearRing();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link Double }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml/3.2", name = "posList")
    public JAXBElement<List<Double>> createPosList(List<Double> value) {
        return new JAXBElement<List<Double>>(_PosList_QNAME, ((Class) List.class), null, ((List<Double> ) value));
    }

}
