package threadTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: QAproject
 * @description: 使用ExecutorService线程
 * @author: bjweiman
 * @create: 2019-03-25 15:44
 **/
@Slf4j
public class CreateThread5 {
    public static ExecutorService executorService = Executors.newCachedThreadPool();
    private static CountDownLatch cdl = new CountDownLatch(10);
    private static final Random random = new Random();

    public void test() {
        for (int i = 0; i < 10; i++) executorService.execute(new ThreadTest());
    }

    public static void main(String[] args) {
        new CreateThread5().test();

        //插入数据完成后  执行修改操作
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }
        System.out.println("它们已经执行完啦..............................");
        executorService.shutdown();

    }

    class ThreadTest implements Runnable {

        public void run() {
            //执行插入数据操作  每次插入一条
            // 模拟耗时
            int time = random.nextInt(10000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "执行完了，耗时：" + time / 1000 + "秒");
            cdl.countDown();
        }
    }
}
