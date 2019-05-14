package testNGcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testng.TestResultListener;

/**
 * @program: QAproject
 * @description: testNG 学习
 * @author: bjweiman
 * @create: 2019-04-04 15:40
 **/
@Listeners(value = {TestResultListener.class})
public class testNGcase{
    @Test(groups = "testNGcase",dependsOnMethods = "test2")
    public void test1(){
        System.out.println("test1");
    }

    @Test(groups = "testNGcase2", dependsOnGroups = {"testNGcase"})
    public void test2(){
        System.out.println("test2");
    }
}
