package testngbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @program: QAproject
 * @description: 测试case1
 * @author: bjweiman
 * @create: 2018-11-30 11:00
 **/
public class TestCase1 {
    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("TestCase1 Before test-method. Thread id is: " + id);
    }

    @Test(groups = "testngbase", threadPoolSize = 3, invocationCount = 6, timeOut = 1000)
    public void testMethodsOne() {
        long id = Thread.currentThread().getId();
        System.out.println("TestCase1 Simple test-method One. Thread id is: " + id);
    }
/*
    @Test
    public void testMethodsTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Two. Thread id is: " + id);
    }
    @Test
    public void testMethodsThree() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Three. Thread id is: " + id);
    }*/
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("TestCase1 After test-method. Thread id is: " + id);
    }
}
