package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: QAproject
 * @description: 前面的数比目标值小，后面的比目标值大
 * @author: bjweiman
 * @create: 2019-04-07 21:31
 **/
public class SmallToBig {
    /**
     * 一个整数的数组例如int a[]={21,11,45,56,9,66,77,89,78,68,100,120,111}
     * 查询数组中有没有比它前面元素都大,比它后面的元素都小的数,没有打印-1,有显示其索引
     */
    public static void main(String[] args) {
        int [] array = {21,11,45,56,9,66,77,89,78,68,100,120,111};
        /*List<Integer> result = findCount(array);
        for (Integer num:result) {
            System.out.println(num);
        }*/
        System.out.println( test(array));;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static List<Integer> findCount(int [] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<array.length; i++) {
            boolean isSmall = true;
            boolean isBig = true;
            int currentNumber = array[i];
            //比前面数大
            for (int j=0; j<i; j++) {
                if (currentNumber < array[j]) {
                    isSmall = false;
                    break;
                }
            }
            //比后面数小
            for (int z=i+1; z<array.length; z++) {
                if (currentNumber > array[z]) {
                    isBig = false;
                    break;
                }
            }
            //添加符合条件的数
            if (isSmall && isBig) {
                list.add(currentNumber);
            }
        }
        //没有符合条件的数就增加-1
        if (list.size() < 1)
            list.add(-1);
        return list;
    }

    /**
     * 使用变量求解：

     （1）目前找到符合题意的候选值，nCandid

     （2）目前已遍历数组的最大值，nMax：为了选下一次的候选值

     （3）目前的候选值是否有效，bIsExist：检测是否需要重新选择候选值

     思路：如果候选值有效，可以继续遍历下面的数据

     如果候选值小于目前的值，则该候选失效。之后遍历元素时，就要重新选择候选值

     选择候选值时，对于某一个元素，如果该元素比之前遍历过元素的最大值还要大nMax，则该元素就为候选。

     复杂度：遍历一遍数组即可，时间：O（n），空间O（1）

     * @param nArr
     * @return
     */
    public static int test(int[] nArr){
        int nPos = 0;
        int nCandid = nArr[0];
        int nMax = nArr[0];
        Boolean bIsExist = true;
        for (int i = 1;i < nArr.length;i++)
        {
            if (bIsExist)//候选有效
            {
                if (nCandid > nArr[i])//候选失效
                {
                    bIsExist = false;
                }
                else
                {
                    nMax = nArr[i];
                }
            }
            else //候选失效
            {
                if (nArr[i] >= nMax)//重新找到候选
                {
                    bIsExist = true;

                    nCandid = nArr[i];
                    nMax = nArr[i];
                    nPos = i;
                }
            }
        }
        return bIsExist ? nPos : -1;

    }
}
