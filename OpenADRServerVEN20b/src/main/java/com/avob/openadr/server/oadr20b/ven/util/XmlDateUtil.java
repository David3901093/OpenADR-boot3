package com.avob.openadr.server.oadr20b.ven.util;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class XmlDateUtil {

    public static XMLGregorianCalendar nowXmlCalendar() {
        try {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(new Date());
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {
            throw new RuntimeException("无法生成 XMLGregorianCalendar", e);
        }
    }


    public static XMLGregorianCalendar todayXmlCalendar() {
        try {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(new Date());

            XMLGregorianCalendar xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);

            xmlCal.setTime(0, 0, 0);
            xmlCal.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);

            return xmlCal;
        } catch (Exception e) {
            throw new RuntimeException("无法生成 XMLGregorianCalendar", e);
        }
    }
}
