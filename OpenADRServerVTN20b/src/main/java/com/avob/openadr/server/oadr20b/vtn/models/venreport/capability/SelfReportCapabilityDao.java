package com.avob.openadr.server.oadr20b.vtn.models.venreport.capability;

import org.springframework.data.repository.CrudRepository;

public interface SelfReportCapabilityDao extends ReportCapabilityDao<SelfReportCapability>, CrudRepository<SelfReportCapability, Long> {

}
