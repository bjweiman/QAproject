package Single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: QAproject
 * @description: Single1 synchronized版本
 * @author: bjweiman
 * @create: 2019-03-30 20:39
 **/
public class Single2 {
    private static Single2 instance;
    private Single2() {}
    public static synchronized Single2 getInstance() {
        if (instance == null) {
            instance = new Single2();
        }
        return instance;
    }

    public static void main(String[] args) {
        /*Single1 single1 = new Single1();
        Single1 single12 = new Single1();

        System.out.println(single1.getInstance().hashCode()==(single12.getInstance().hashCode()));

        System.out.println(single1.getInstance().equals(single12.getInstance()));*/
        /**
         * 该方式在多线程情况下失效
         */
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 101010; i++) {
            executorService.execute(()->{
                Single2 single2 = new Single2();
                System.out.println(single2.getInstance().hashCode());
            });
        }

//        System.out.println(single12.getInstance().hashCode());
    }
}
