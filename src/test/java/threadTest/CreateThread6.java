package threadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: QAproject
 * @description: ExecutorService线程池多线程
 * @author: bjweiman
 * @create: 2019-03-25 16:34
 **/
public class CreateThread6 {
    private static Integer count=0;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 100; i++) {
            executorService.execute(()->{
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getId()+"---"+ count++ +"--执行完成······");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            countDownLatch.countDown();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("所有任务执行完成");

    }
}
