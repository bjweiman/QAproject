package threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @program: QAproject
 * @description: 实现Callable接口通过FutureTask包装器来创建Thread线程
 * @author: bjweiman
 * @create: 2019-03-25 15:17
 **/
public class CreateThread3<V> implements Callable<V>{
    /**
     * 线程名称
     */
    private String threadName;
    public V call() throws Exception{
        System.out.println("线程开始执行······");
        return null;
    }

    public static void main(String[] args) {
        Callable<String> oneCallable = new CreateThread3<>();
        FutureTask<String> task = new FutureTask<>(oneCallable);
        Thread thread = new Thread(task);
        thread.start();

    }
}
