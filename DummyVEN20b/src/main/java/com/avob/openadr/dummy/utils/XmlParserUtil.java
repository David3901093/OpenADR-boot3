package com.avob.openadr.dummy.utils;

import com.avob.openadr.model.oadr20b.Oadr20bJAXBContext;
import com.avob.openadr.model.oadr20b.exception.Oadr20bMarshalException;
import com.avob.openadr.model.oadr20b.exception.Oadr20bUnmarshalException;
import jakarta.xml.bind.*;
import org.apache.logging.log4j.core.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;


public class XmlParserUtil {

    public static <T> T parseOadrXml(String xmlString, Class<T> clazz) throws JAXBException, Oadr20bUnmarshalException {

            Oadr20bJAXBContext jaxbContext = Oadr20bJAXBContext.getInstance();
            T unmarshal = jaxbContext.unmarshal(xmlString, clazz);

            return unmarshal;
    }

    public static <T> String toXmlString(T object,Class<T> clazz) throws JAXBException, Oadr20bMarshalException {
        Oadr20bJAXBContext jaxbContext = Oadr20bJAXBContext.getInstance();
        String xmlString = jaxbContext.marshal(object);
        return xmlString;
    }
}
    