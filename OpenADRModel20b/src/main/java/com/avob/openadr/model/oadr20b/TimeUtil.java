package com.avob.openadr.model.oadr20b;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeUtil {
    public static XMLGregorianCalendar now() {
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            gregorianCalendar.setTimeInMillis(System.currentTimeMillis());
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (Exception e) {
            throw new RuntimeException("Error creating XMLGregorianCalendar", e);
        }
    }
}
