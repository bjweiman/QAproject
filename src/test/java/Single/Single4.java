package Single;

/**
 * @program: QAproject
 * @description: Single4
 * @author: bjweiman
 * @create: 2019-03-30 20:58
 **/
public class Single4 {
    private static volatile Single4 instance;

    private Single4(){}

    public static Single4 getInstance(){
        if (null == instance){
            synchronized (Single4.class){
                if (instance == null){
                    instance = new Single4();
                }
            }
        }

        return instance;
    }
}
