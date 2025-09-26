package com.avob.openadr.model.oadr20b.builders.eireport;
import java.util.List;

import com.avob.openadr.model.oadr20b.Oadr20bFactory;
import com.avob.openadr.model.oadr20b.TimeUtil;
import com.avob.openadr.model.oadr20b.builders.eipayload.Oadr20bReportIntervalTypeBuilder;
import com.avob.openadr.model.oadr20b.oadr.OadrReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrUpdateReportType;
import com.avob.openadr.model.oadr20b.oadr.OadrReportPayloadType;
import com.avob.openadr.model.oadr20b.ei.IntervalType;
import com.avob.openadr.model.oadr20b.ei.SchemaVersionEnumeratedType;
import com.avob.openadr.model.oadr20b.ei.ReportPayloadType;
import com.avob.openadr.model.oadr20b.xcal.Dtstart;
import com.avob.openadr.model.oadr20b.strm.Intervals;
import com.avob.openadr.model.oadr20b.ei.PayloadFloatType;
import  com.avob.openadr.model.oadr20b.ei.ReportSpecifierType;
import com.avob.openadr.model.oadr20b.ei.SpecifierPayloadType;
import jakarta.xml.bind.JAXBElement;


import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;



public class Oadr20bUpdateReportBuilder {
    private OadrUpdateReportType oadrUpdateReportType;

    public Oadr20bUpdateReportBuilder(String requestId, String venId) {
        oadrUpdateReportType = Oadr20bFactory.createOadrUpdateReportType(requestId, venId);
    }

    public Oadr20bUpdateReportBuilder addReport(List<OadrReportType> report) {
        oadrUpdateReportType.getOadrReport().addAll(report);
        return this;
    }

    public Oadr20bUpdateReportBuilder addReport(OadrReportType report) {
        oadrUpdateReportType.getOadrReport().add(report);
        return this;
    }

    public Oadr20bUpdateReportBuilder withSchemaVersion(String schemaVersion) {
        oadrUpdateReportType.setSchemaVersion(schemaVersion);
        return this;
    }

    public OadrUpdateReportType build() {
        return oadrUpdateReportType;
    }
    public OadrUpdateReportType buildDefaultUpdateReport(String requestId, String venId, String reportRequestID, String specifierID, ReportSpecifierType reportSpecifier,String reportName) {
        OadrUpdateReportType updateReport = new OadrUpdateReportType();
        updateReport.setRequestID(requestId);
        updateReport.setVenID(venId);
        updateReport.setSchemaVersion(SchemaVersionEnumeratedType.OADR_20B.value());

        OadrReportType report = new OadrReportType();
        report.setReportRequestID(reportRequestID);
        report.setReportSpecifierID(specifierID);
        report.setReportName(reportName);
        report.setCreatedDateTime(TimeUtil.now());
        report.setIntervals(new Intervals());
        // ---- Report Dtstart ----
        Dtstart reportStart = new Dtstart();
        XMLGregorianCalendar now = TimeUtil.now();
        reportStart.setDateTime(now);
        report.setDtstart(reportStart);
        List<SpecifierPayloadType>specifiers = reportSpecifier.getSpecifierPayload();
        List<String> rids = specifiers.stream().map(SpecifierPayloadType::getRID).toList();
        IntervalType interval = new Oadr20bReportIntervalTypeBuilder( "0", System.currentTimeMillis(), reportSpecifier.getGranularity().getDuration(),rids.stream().findFirst().orElse(null), 1L, 1.0F,-1.0F ).build();
        // ---- ReportPayloadType for RealPower ----
        QName payloadQName = new QName("http://openadr.org/oadr-2.0b/2012/07", "oadrReportPayload");
        QName payloadBaseQName = new QName("http://docs.oasis-open.org/ns/energyinterop/201110", "payloadFloat");

        // ---- Interval with ReportPayloadType for payloadType  ----
        Dtstart dtstart = new Dtstart();
        dtstart.setDateTime(now);
        interval.setDtstart(dtstart);
        // add payloadType
        if (rids.size()>1){
            for (int i = 1; i < rids.size(); i++) {
                OadrReportPayloadType payloadType = new OadrReportPayloadType();
                payloadType.setRID(rids.get(i));
                payloadType.setConfidence(1L);
                payloadType.setAccuracy(1F);
                PayloadFloatType payloadFloatType = new PayloadFloatType();
                payloadFloatType.setValue(-1.0F);
                payloadType.setPayloadBase(new JAXBElement<>(payloadBaseQName, PayloadFloatType.class, payloadFloatType));
                interval.getStreamPayloadBase().add(new JAXBElement<>(payloadQName, ReportPayloadType.class, payloadType));
            }
        }

        report.getIntervals().getInterval().add(interval);
        updateReport.getOadrReport().add(report);

        return updateReport;
    }

}
