package threadTest;

/**
 * @program: QAproject
 * @description: 实现Runnable接口创建线程
 * @author: bjweiman
 * @create: 2019-03-25 15:07
 **/
public class CreateThread2  implements Runnable{
    private String threadName;

    /**
     * 构造函数
     */
    CreateThread2(){

    }

    /**
     * 构造函数
     * @param threadName
     */
    CreateThread2(String threadName){
        this.threadName = threadName;
    }
    public void  run(){
        System.out.println(this.threadName + "开始执行");
    }

    public static void main(String[] args) {
        CreateThread2 createThread21 = new CreateThread2("Thread-1");
        Thread thread1 = new Thread(createThread21);
        thread1.start();

        CreateThread2 createThread22 = new CreateThread2("Thread-2");
        Thread thread2 = new Thread(createThread22);
        thread2.start();

    }
}
