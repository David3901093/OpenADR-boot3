package com.avob.openadr.dummy.appender;

import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.PatternLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

@Plugin(name = "InMemoryLogAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE)
public class InMemoryLogAppender extends AbstractAppender {


    private static final int MAX_LOG_SIZE = 1000;
    private static final List<LogData> logDataList = new CopyOnWriteArrayList<>();
    private static final ReentrantLock lock = new ReentrantLock();

    protected InMemoryLogAppender(String name, Filter filter, Layout<?> layout, boolean ignoreExceptions, Property[] properties) {
        super(name, filter, layout, ignoreExceptions, properties);
    }


    @PluginFactory
    public static InMemoryLogAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Filter") Filter filter) {
        Layout<?> layout = PatternLayout.createDefaultLayout();
        return new InMemoryLogAppender(name, filter, layout, true, Property.EMPTY_ARRAY);
    }

    @Override
    public void append(LogEvent event) {
        lock.lock();
        try {

            LogData logData = new LogData();
            logData.setTimestamp(event.getTimeMillis());
            logData.setThreadName(event.getThreadName());
            logData.setLevel(event.getLevel().name());
            logData.setLoggerName(event.getLoggerName());
            logData.setMessage(event.getMessage().getFormattedMessage());

            if (logDataList.size() >= MAX_LOG_SIZE) {
                logDataList.remove(0);
            }
            logDataList.add(logData);
        } finally {
            lock.unlock();
        }
    }

    public static List<LogData> getLogDataList() {
        return new CopyOnWriteArrayList<>(logDataList);
    }

    public static class LogData {
        private long timestamp;
        private String threadName;
        private String level;
        private String loggerName;
        private String message;

        public long getTimestamp() { return timestamp; }
        public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
        public String getThreadName() { return threadName; }
        public void setThreadName(String threadName) { this.threadName = threadName; }
        public String getLevel() { return level; }
        public void setLevel(String level) { this.level = level; }
        public String getLoggerName() { return loggerName; }
        public void setLoggerName(String loggerName) { this.loggerName = loggerName; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }
}