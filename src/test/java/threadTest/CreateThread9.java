package threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: QAproject
 * @description: InterruptedException
 * @author: bjweiman
 * @create: 2019-03-25 20:31
 **/
public class CreateThread9 {
    private static class Mythread extends Thread{
        public void run(){
            try {
                Thread.sleep(300);
                System.out.println(Thread.currentThread().getName()+ "---线程执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /*Thread thread = new Mythread();
        thread.start();
        thread.interrupt();
        System.out.println("Main run");*/

       /* Thread thread = new Mythread1();
        thread.start();
        thread.interrupt();
        System.out.println("Main run");*/

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");
    }

    private static class Mythread1 extends Thread{
        public void run(){

            while (!interrupted()){
                System.out.println("中断");
            }

            System.out.println("线程结束");
        }
    }
}
