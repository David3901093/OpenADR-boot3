package com.avob.openadr.dummy.controller;

/**
 * @author david
 * Date  2025/8/11
 */
import com.avob.openadr.dummy.appender.InMemoryLogAppender;
import com.avob.openadr.dummy.config.VenUrlPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = VenUrlPath.VEN_BASE_PATH,method = RequestMethod.GET)
public class LoggerController {

    @GetMapping("/logs")
    public Map<String, Object> getLogs() {
        List<InMemoryLogAppender.LogData> logDataList = InMemoryLogAppender.getLogDataList();
        Map<String, Object> response = new HashMap<>();
        response.put("logData", logDataList);
        return response;
    }
}
