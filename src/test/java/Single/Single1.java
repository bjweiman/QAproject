package Single;

/**
 * @program: QAproject
 * @description: Single3
 * @author: bjweiman
 * @create: 2019-03-30 20:27
 **/
public class Single1 {
    private static Single1 instance;


    public Single1 getInstance(){
        if (instance == null){
            instance = new Single1();
        }
        return instance;
    }

    public static void main(String[] args) {
      /*  Single1 single1 = new Single1();
        Single1 single12 = new Single1();

        System.out.println(single1.getInstance().hashCode()==(single12.getInstance().hashCode()));

        System.out.println(single1.getInstance().equals(single12.getInstance().hashCode()));*/
        /**
         * 该方式在多线程情况下失效
         */
        new Thread(()->{
            Single1 single11 = new Single1();
            System.out.println(single11.hashCode());
        }).start();

        new Thread(()->{
            Single1 single11 = new Single1();
            System.out.println(single11.hashCode());
        }).start();

//        System.out.println(single12.getInstance().hashCode());
    }
}
