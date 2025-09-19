package com.avob.openadr.server.oadr20b.vtn.models.venreport.request;

import java.util.List;

import com.avob.openadr.server.common.vtn.models.ven.Ven;
import org.springframework.data.repository.CrudRepository;

public interface SelfReportRequestDao extends ReportRequestDao<SelfReportRequest>, CrudRepository<SelfReportRequest, Long> {

    public List<SelfReportRequest> findByTargetAndReportRequestIdIn(Ven ven, List<String> reportRequestId);
    
    public List<SelfReportRequest> findByTarget(Ven ven);

}
