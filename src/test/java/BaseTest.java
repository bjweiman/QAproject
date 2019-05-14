import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @program: QAproject
 * @description: testng测试类
 * @author: bjweiman
 * @create: 2018-11-30 11:00
 **/
@ContextConfiguration(locations = {"classpath:"})
public class BaseTest extends AbstractJUnit4SpringContextTests{
    public boolean isPalindrome(int x) {
        if (x <0) return false;
        if(x == 0 || x%10==0) return true;
        String str = x + "";
        for(int i = 0, j=str.length()-1; i<j; i++,j--){
            if(str.substring(i).equals(str.substring(j))){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

}
