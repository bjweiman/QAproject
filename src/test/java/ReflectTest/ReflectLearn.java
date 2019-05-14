package ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @program: QAproject
 * @description: java反射学习
 * 反射就是在运行时候才知道要操作的类是什么，并且可以在运行时获取类的完整构造，并调用对应的方法
 * @author: bjweiman
 * @create: 2019-03-30 15:25
 **/
public class ReflectLearn {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int addPrice(){
      /*  price = price+1;
        System.out.println(price);*/
        return price++;
    }

    public static void main(String[] args) throws Exception{
        ReflectLearn reflectLearn = new ReflectLearn();
        reflectLearn.setPrice(6);

        System.out.println("reflectLearn-正常：" + reflectLearn.getPrice());

        Class cla = Class.forName("ReflectTest.ReflectLearn");
        Method setMethod = cla.getMethod("setPrice", int.class);
        Constructor constructor = cla.getConstructor();
        Object reflectObject = constructor.newInstance();
        setMethod.invoke(reflectObject, 15);
        Method getMethod = cla.getMethod("getPrice");
        System.out.println("reflectLearn-反射："+ getMethod.invoke(reflectObject));


    }
}
