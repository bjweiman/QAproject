package Single;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: QAproject
 * @description: Single3 synchronized 语句
 * @author: bjweiman
 * @create: 2019-03-30 20:46
 **/
public class Single3 {
    private static Single3 instance;
    private Single3(){}

    public static Single3 getInstance(){
        if (instance == null){
            synchronized (Single3.class){
                if (null == instance){
                    instance = new Single3();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            executorService.execute(()->{
                Single3 single3 = new Single3();
                System.out.println(single3.getInstance().hashCode());
            });
        }
        System.out.println(System.currentTimeMillis()-start);

    }
}
