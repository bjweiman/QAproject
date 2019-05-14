package threadTest;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: QAproject
 * @description: 继承Thread类创建线程
 * @author: bjweiman
 * @create: 2019-03-25 14:58
 **/
@Slf4j
public class CreateThread1 extends Thread{
    public void run(){
      log.info("{}-线程开始执行", getId());
    }

    public static void main(String[] args) {
        CreateThread1 createThread1 = new CreateThread1();
        createThread1.start();

        CreateThread1 createThread2 = new CreateThread1();
        createThread2.start();
    }
}
