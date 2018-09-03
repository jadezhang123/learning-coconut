package own.jadezhang.learning.log4j2;

import org.springframework.stereotype.Service;

/**
 * @author Zhang Junwei
 * @date 2018/9/3
 */
@Service
public class BizService {
    public void run(String msg){
        System.out.println("error log occur" + msg);
    }
}
