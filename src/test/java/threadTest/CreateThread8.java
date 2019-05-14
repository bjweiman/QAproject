package threadTest;

import java.util.concurrent.*;

/**
 * @program: QAproject
 * @description: 线程池
 * @author: bjweiman
 * @create: 2019-03-25 18:34
 **/
public class CreateThread8 {
    public static void main(String[] args) {
        threadTest1();

        while (true){

        }
    }

    public static void test(){
        int i=100;
        while (i>=0){
            threadTest();
            i--;
        }
    }


    public static  void threadTest(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " finished!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("任务提交成功!");
    }

    public static void threadTest1(){
        ExecutorService service = new ThreadPoolExecutor(10,20,1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(10));
        for (int i = 0; i < 200; i++) {
            service.execute(new myThread(String.valueOf(i)));
        }
    }
}

class myThread extends Thread{
    private String threadId;
    myThread(){

    }

    myThread(String threadId){
        this.threadId = threadId;
    }
    @Override
    public void run(){
        this.setName("wm-thread-" + threadId);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"---开始执行---" + this.getId());
    }
}
