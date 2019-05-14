package testng;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.util.StringUtils;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import util.TraceUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: QAproject
 * @description: 监听用例执行过程，并打印结果
 * @author: bjweiman
 * @create: 2019-02-25 17:02
 **/
@Slf4j
public class TestResultListener extends TestListenerAdapter {

    /**
     * key : 测试方法
     * value : 测试方法是否自动管理参数
     */
    private Map<Method,Boolean> autoManagerParameter = new HashMap<>();

    /**
     * key : 测试方法
     * value : 测试方法是否自动填充参数
     */
    private Map<Method,Boolean> autoFillParameter = new HashMap<>();

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        log.info("接口 {}#{} 执行成功,耗时: {} ms\n\n\n",tr.getTestClass().getName(),tr.getMethod().getMethodName(),tr.getEndMillis()- tr.getStartMillis());
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        log.error("接口 {}#{} 执行失败,耗时: {} ms\n\n\n",tr.getTestClass().getName(),tr.getMethod().getMethodName(),tr.getEndMillis()- tr.getStartMillis());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        log.warn("接口 {}#{} 跳过,耗时: {} ms\n\n\n",tr.getTestClass().getName(),tr.getMethod().getMethodName(),tr.getEndMillis()- tr.getStartMillis());
    }

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        TraceUtil.setTrace();
        log.info("---------------------------------------------------------");
        log.info("接口 {}#{} 开始执行\n",result.getTestClass().getName(),result.getMethod().getMethodName());
        String caseDescription = getCaseDescription(result);
        if (!org.springframework.util.StringUtils.isEmpty(caseDescription)){
            log.info("开始执行用例 {}",caseDescription);
        }
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        boolean needAutoParameter = needAutoParameter(method);

        if (needAutoParameter){
//            NsipTestContext.getInstance().setAutoFillParameters(autoFillParameter.get(method));
            //用例参数 形参
            Parameter[] methodParameters = method.getParameters();
            //用例参数 实参
            Object[] testParameters = result.getParameters();
//            nsipTestContext.filledParameters(methodParameters,testParameters);
        }else {
            log.debug("接口 {}#{} 不需要自动管理参数!",result.getTestClass().getName(),result.getMethod().getMethodName());
        }
    }

    /**
     * 获取用例介绍
     * @param testResult 测试结果
     * @return 用例介绍
     */
    private String getCaseDescription(ITestResult testResult){
        Object[] parameters = testResult.getParameters();
        if (parameters != null && parameters.length>0){
            for (Object parameter : parameters) {
                if (parameter instanceof JsonObject){
                    String desc = ((JSONObject)parameter).getString("caseDescription");
                    if (!org.springframework.util.StringUtils.isEmpty(desc)){
                        return desc;
                    }
                }
            }
        }
        return null;
    }
    private boolean needAutoParameter(Method method){
        Boolean need = autoManagerParameter.get(method);
        if (null != need){
            return need;
        }

        return false;
    }
}
