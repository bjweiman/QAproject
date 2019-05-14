package ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: QAproject
 * @description:
 * @author: bjweiman
 * @create: 2019-03-30 16:30
 **/
public class test {
    /*public static void main(String[] args) throws Exception{
//        reflectLearn.setPrice(8);

        Class cla = Class.forName("ReflectTest.ReflectLearn");
        Method setMethod = cla.getMethod("setPrice", int.class);
        Constructor constructor = cla.getConstructor();
        Object object = constructor.newInstance();

        setMethod.invoke(object, 8);

        Method getMethod = cla.getMethod("getPrice");
        System.out.println("1-price:" + getMethod.invoke(object));

        Method addMethod = cla.getDeclaredMethod("addPrice");
        addMethod.setAccessible(true);
        addMethod.invoke(object);
        System.out.println("2-price:" + getMethod.invoke(object));

        ReflectLearn reflectLearn = new ReflectLearn();
        Field feild=cla.getDeclaredField("price");//获取对应的属性

        feild.setAccessible(true);
        feild.set(reflectLearn,666);

        System.out.println(reflectLearn.getPrice());


        String a = "ab"; String b = "a" + "b";
        System.out.println( a == b);

    }*/

    public static void main(String[] args) {
        System.out.println(reverseWords1("public static boolean"));;

    }

    public static boolean isPalindrome(int x) {
        if (x <0) return false;
        if(x == 0 || x%10==0) return true;
        String str = x + "";
        for(int i = 0, j=str.length()-1; i<j; i++,j--){
            if(str.substring(i).equals(str.substring(j))){
                System.out.println();
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    //我的方法，效率高
    public static String reverseWords1(String s) {
        String[] strlist = s.trim().split(" ");//split的参数是正则表达式

        for (int i = 0; i < strlist.length; i++) {
            System.out.println(strlist[i]);
        }
        //用StringBuffer的效率要比String高一些，这里用String也是可以的
        StringBuffer sb = new StringBuffer();

        for(int i = strlist.length-1; i>=0; i--){
            sb.append(strlist[i] + " ");
        }

        return sb.toString().trim();
    }
}
