package own.jadezhang.learning.coconut.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Zhang Junwei on 2017/4/20 0020.
 */
public class LogMain {
    private final static Logger logger = LoggerFactory.getLogger(LogMain.class);

    public static void main(String[] args) {

        logger.debug("this is test for log4j12[debug]");
        logger.info("this is test for log4j12[info]");
        try {
            int a = 5/0;
        }catch (Exception e){
            logger.debug("method[%s] in %s throw a exception : %s", "main", "LogMain", e.getMessage());
            logger.error("throw a exception", e);
        }
    }
}
