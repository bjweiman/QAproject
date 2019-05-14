import lombok.extern.slf4j.Slf4j;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import testng.TestResultListener;

/**
 * @program: QAproject
 * @description: BaseCase
 * @author: bjweiman
 * @create: 2019-02-25 16:04
 **/
@ContextConfiguration(locations = "classpath:springConfig.xml")
@Slf4j
@Listeners(value = {TestResultListener.class})
public class BaseCase extends AbstractTestNGSpringContextTests {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        log.info("beforeSuite");
        //TODO 增加Suite执行前逻辑
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        log.info("beforeClass");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        log.info("afterClass");

    }

    @AfterSuite
    public void afterSuite(){
        //TODO 增加Suite执行后逻辑
    }

}
