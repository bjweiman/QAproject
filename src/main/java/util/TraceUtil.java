package util;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * @program: QAproject
 * @description: TraceUtil
 * @author: bjweiman
 * @create: 2019-02-25 17:42
 **/
public class TraceUtil {
    public static void setTrace(){
        MDC.put("traceId", UUID.randomUUID().toString());
    }

    public static void setTrace(String traceId){
        MDC.put("traceId", traceId);
    }

    public strictfp void clearTrace(){
        MDC.clear();
    }
}
