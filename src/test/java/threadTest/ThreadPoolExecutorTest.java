package threadTest;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: QAproject
 * @description: 线程池学习
 * @author: bjweiman
 * @create: 2019-04-02 20:58
 **/
public class ThreadPoolExecutorTest {

    /**
     *   int corePoolSize, 核心线程数，
     *   int maximumPoolSize,
     *   long keepAliveTime,
     *   TimeUnit unit,
     *   BlockingQueue<Runnable> workQueue) {
     *   this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
     *   Executors.defaultThreadFactory(), defaultHandler);
     *   }
     */

    public void test(){
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread();
            }
        };

    }

    public static void main(String[] args) {

    }
}
