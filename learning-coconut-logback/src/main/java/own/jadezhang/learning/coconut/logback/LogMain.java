package own.jadezhang.learning.coconut.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Zhang Junwei on 2017/4/20 0020.
 */
public class LogMain {
    private final static Logger logger = LoggerFactory.getLogger(LogMain.class);

    public static void main(String[] args) {
        logger.debug("this is test for logback[debug]");
        logger.info("this is test for logback[info]");
        try {
            int a = 5/0;
        }catch (Exception e){
            logger.debug("method[{}] in {} throw a exception : {}", "main", "LogMain", e.getMessage());
            logger.error("throw a exception", e);
        }
    }
}
