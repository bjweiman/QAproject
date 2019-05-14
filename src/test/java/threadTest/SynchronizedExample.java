package threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: QAproject
 * @description: SynchronizedExample
 * @author: bjweiman
 * @create: 2019-03-25 20:48
 **/
public class SynchronizedExample {
    public void function(){
        synchronized (this){
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName()+ ":"+ i);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedExample e2 = new SynchronizedExample();

        executorService.execute(()->e1.function());
        executorService.execute(()->e2.function());
      /*  SynchronizedExample1 e1 = new SynchronizedExample1();
        SynchronizedExample1 e2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func2());
        executorService.execute(() -> e2.func2());*/
    }
}


class SynchronizedExample1 {

    public void func2() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+ ":"+ i);
            }
        }
    }
}