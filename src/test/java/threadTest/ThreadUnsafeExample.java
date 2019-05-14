package threadTest;

import lombok.Synchronized;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: QAproject
 * @description: ThreadUnsafeExample 线程不安全示例
 * 如果多个线程对同一个共享数据进行访问而不采用同步操作的话，那么操作的结果是不一致的
 * 以下代码演示了 1000 个线程同时对 cnt 执行自增操作，操作结束之后它的值有可能小于 1000。
 * @author: bjweiman
 * @create: 2019-03-28 15:21
 **/

public class ThreadUnsafeExample {
    private int cnt = 0;

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    public   void add(){
        /*synchronized(ThreadUnsafeExample.class){

        }*/
        cnt++;
    }

    public static void main(String[] args) throws InterruptedException{
        final int threadSize = 1000;

        ThreadUnsafeExample threadUnsafeExample = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);

        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
        for (int i = 0; i < threadSize*3; i++) {
            executorService.execute(()->{
                threadUnsafeExample.add();
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("结果："+ threadUnsafeExample.getCnt());

    }
}
