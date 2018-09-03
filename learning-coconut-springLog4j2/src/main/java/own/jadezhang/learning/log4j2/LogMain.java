package own.jadezhang.learning.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Zhang Junwei on 2017/4/20 0020.
 */
@Component
public class LogMain {
    
    private final static Logger logger = LoggerFactory.getLogger(LogMain.class);

    public void logMsg(String msg){
        logger.debug("this is a test for log4j2 with debug msg:" + msg);
        logger.info("this is a test for log4j2 with info msg:" + msg);
        logger.error("this is a test for log4j2 with error msg:" + msg);
    }


    public static void main(String[] args) {
        ApplicationContext xmlACtx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        LogMain bean = xmlACtx.getBean(LogMain.class);
        bean.logMsg("jack");
    }

}
