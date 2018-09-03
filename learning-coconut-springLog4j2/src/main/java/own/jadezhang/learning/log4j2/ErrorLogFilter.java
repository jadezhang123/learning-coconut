package own.jadezhang.learning.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

/**
 * @author Zhang Junwei
 * @date 2018/9/3
 */
@Plugin(name = "ErrorLogFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE, printObject = true)
public class ErrorLogFilter extends AbstractFilter{
    private final Level level = Level.valueOf("ERROR");

    public ErrorLogFilter(final Result onMatch, final Result onMismatch) {
        super(onMatch, onMismatch);
    }

    @Override
    public Result filter(Logger logger, Level testLevel, Marker marker, String msg, Object... params) {
        return this.filter(testLevel, msg);
    }

    @Override
    public Result filter(Logger logger, Level testLevel, Marker marker, Object msg, Throwable t) {
        return this.filter(testLevel, msg.toString());
    }

    @Override
    public Result filter(Logger logger, Level testLevel, Marker marker, Message msg, Throwable t) {
        return this.filter(testLevel, msg.toString());
    }

    @Override
    public Result filter(LogEvent event) {
        return this.filter(event.getLevel(), event.getMessage().toString());
    }

    private Result filter(final Level testLevel, String msg) {
        if (testLevel.isMoreSpecificThan(this.level)) {
            NotifyService bizService = (NotifyService) SpringContextUtils.getBean("bizService");
            bizService.run(msg);
            return onMatch;
        }
        return onMismatch;
    }

    @PluginFactory
    public static ErrorLogFilter createFilter(
            @PluginAttribute("onMatch") final Result match,
            @PluginAttribute("onMismatch") final Result mismatch) {
        final Result onMatch = match == null ? Result.NEUTRAL : match;
        final Result onMismatch = mismatch == null ? Result.DENY : mismatch;
        System.out.println("create filter");
        return new ErrorLogFilter(onMatch, onMismatch);
    }
}
