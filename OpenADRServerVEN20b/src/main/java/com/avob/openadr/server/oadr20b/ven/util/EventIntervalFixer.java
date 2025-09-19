package com.avob.openadr.server.oadr20b.ven.util;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.avob.openadr.model.oadr20b.ei.EiEventType;
import com.avob.openadr.model.oadr20b.ei.IntervalType;
import com.avob.openadr.model.oadr20b.ei.EiActivePeriodType;
import com.avob.openadr.model.oadr20b.ei.EiEventSignalType;
import com.avob.openadr.model.oadr20b.xcal.Properties;

public class EventIntervalFixer {


    public static void fixIntervals(EiEventType eiEvent) throws Exception {
        XMLGregorianCalendar activePeriodStart = null;
        if (eiEvent.getEiActivePeriod() != null &&
                eiEvent.getEiActivePeriod().getProperties() != null &&
                eiEvent.getEiActivePeriod().getProperties().getDtstart() != null) {
            activePeriodStart = eiEvent.getEiActivePeriod().getProperties().getDtstart().getDateTime();
        } else {
            GregorianCalendar now = new GregorianCalendar();
            activePeriodStart = DatatypeFactory.newInstance().newXMLGregorianCalendar(now);
            if (eiEvent.getEiActivePeriod() == null) {
                eiEvent.setEiActivePeriod(new EiActivePeriodType());
            }
            if (eiEvent.getEiActivePeriod().getProperties() == null) {
                eiEvent.getEiActivePeriod().setProperties(new Properties());
            }
            com.avob.openadr.model.oadr20b.xcal.Dtstart dtstart = new com.avob.openadr.model.oadr20b.xcal.Dtstart();
            dtstart.setDateTime(activePeriodStart);
            eiEvent.getEiActivePeriod().getProperties().setDtstart(dtstart);
        }

        for (EiEventSignalType signal : eiEvent.getEiEventSignals().getEiEventSignal()) {
            List<IntervalType> intervals = signal.getIntervals().getInterval();
            if (intervals.isEmpty()) continue;

            Duration intervalDuration = null;
            if (intervals.get(0).getDuration() != null && intervals.get(0).getDuration().getDuration() != null) {
                intervalDuration = DatatypeFactory.newInstance().newDuration(intervals.get(0).getDuration().getDuration());
            } else {
                throw new IllegalArgumentException("invalid interval duration，can't restore dtstart");
            }

            XMLGregorianCalendar currentStart = (XMLGregorianCalendar) activePeriodStart.clone();

            for (IntervalType interval : intervals) {
                if (interval.getDtstart() == null) {
                    com.avob.openadr.model.oadr20b.xcal.Dtstart dtstart = new com.avob.openadr.model.oadr20b.xcal.Dtstart();
                    dtstart.setDateTime((XMLGregorianCalendar) currentStart.clone());
                    interval.setDtstart(dtstart);
                }

                intervalDuration.addTo(currentStart.toGregorianCalendar());
                currentStart = DatatypeFactory.newInstance().newXMLGregorianCalendar( currentStart.toGregorianCalendar());
            }
        }
    }
}
