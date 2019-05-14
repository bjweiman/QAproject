package LockLearn;

/**
 * @program: QAproject
 * @description: DeadLock
 * @author: bjweiman
 * @create: 2019-03-30 19:43
 **/
public class DeadLock implements Runnable{
    public int flag = 1;
    //静态对象是类的所有对象共享的
    private static Object o1 = new Object(), o2 = new Object();
    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                    System.out.println("flag==1 sleep结束");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("flag==1  o2资源");
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                    System.out.println("flag==0 sleep结束");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("flag==0  o1资源");
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {

        DeadLock td1 = new DeadLock();
        DeadLock td2 = new DeadLock();
        td1.flag = 1;
        td2.flag = 0;
        //td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
        //td2的run()可能在td1的run()之前运行
        new Thread(td1).start();
        new Thread(td2).start();

        new Thread(() -> {
            try {
                System.out.println("thread1 is running");
                synchronized (DeadLock.class) {
                    System.out.println("thread is block obj1");

                    Thread.sleep(1000);
                    synchronized (Object.class) {
                        System.out.println("thread is block ojb2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("thread1 is running");
                synchronized (Object.class) {
                    System.out.println("thread is block obj1");

                    Thread.sleep(1000);
                    synchronized (DeadLock.class) {
                        System.out.println("thread is block ojb2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();


    }
    /*
    public static void main(String[] args) {
       new Thread(() -> {
           try {
               System.out.println("thread1 is running");
               synchronized (DeadLock.class) {
                   System.out.println("thread is block obj1");

                   Thread.sleep(1000);
                   synchronized (Object.class) {
                       System.out.println("thread is block ojb2");
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }).start();
       new Thread(() -> {
           try {
               System.out.println("thread1 is running");
               synchronized (Object.class) {
                   System.out.println("thread is block obj1");

                   Thread.sleep(1000);
                   synchronized (DeadLock.class) {
                       System.out.println("thread is block ojb2");
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }).start();
   }*/
}
