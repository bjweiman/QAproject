/**
 * @program: QAproject
 * @description: s
 * @author: bjweiman
 * @create: 2019-02-25 20:09
 **/
public class test {

    public static void main(String[] args) {
//        reverseWords1("public static boolean");
        for (int i = 0; i < 100; i++) {
            System.out.println("=="+i);
            if (i == 4)
                break;
        }


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
        String[] strlist = s.trim().split(" +");//split的参数是正则表达式

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
