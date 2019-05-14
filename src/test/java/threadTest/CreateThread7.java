package threadTest;

import java.util.concurrent.*;

/**
 * @program: QAproject
 * @description: ExecutorService线程池多线程
 * @author: bjweiman
 * @create: 2019-03-25 17:43
 **/
public class CreateThread7 {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("Main");
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20,
                10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(480), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("pool" + thread.getId());
                return thread;
            }


        });
        executor.allowCoreThreadTimeOut(true);

        for (int i = 0; i < 500; i++) {
            executor.execute(new MyRunnable());
//            countDownLatch.countDown();

        }


        Thread.sleep(5000);
//
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        executorService.shutdown();
    }
}
class MyRunnable implements Runnable{
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId()+" 线程执行···");
    }

        @Override
        protected void finalize() {
        System.out.println(Thread.currentThread().getName() + " finalize!");
    }


}