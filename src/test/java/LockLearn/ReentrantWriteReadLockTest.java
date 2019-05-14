package LockLearn;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: QAproject
 * @description:
 * @author: bjweiman
 * @create: 2019-03-30 19:29
 **/
public class ReentrantWriteReadLockTest {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public void read(){
        try {
            readLock.lock();
            System.out.println("线程"+Thread.currentThread().getName()+"进入...");
            Thread.sleep(3000);
            System.out.println("线程"+Thread.currentThread().getName()+"退出...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            readLock.unlock();
        }
    }

    public void write(){
        try {
            writeLock.lock();
            System.out.println("线程"+Thread.currentThread().getName()+"进入。。。");
            Thread.sleep(3000);
            System.out.println("线程"+Thread.currentThread().getName()+"退出。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            writeLock.unlock();
        }
    }


    public static void main(String[] args) {
        final ReentrantWriteReadLockTest wr = new ReentrantWriteReadLockTest();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                wr.read();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                wr.read();
            }
        }, "t2");
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                wr.write();
            }
        }, "t3");
        Thread t4 = new Thread(new Runnable() {
            public void run() {
                wr.write();
            }
        }, "t4");

        /*t1.start();
        t2.start();
        t3.start();*/
        t4.start();
        t2.start();

    }
}
