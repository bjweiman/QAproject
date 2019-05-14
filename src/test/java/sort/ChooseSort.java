package sort;

/**
 * @program: QAproject
 * @description: 选择排序
 * @author: bjweiman
 * @create: 2019-04-05 15:29
 **/
public class ChooseSort {
    public static void  chooseSort(int[] nums){
        if (nums == null) return;
        if (nums.length == 0 || nums.length ==1) return;

        int choose = 0;
        while (choose<nums.length){

        }
        //外层循环，比较趟数
        for (int i=0; i<nums.length-1; i++){
            int minIndex = i;
            //内层循环获取 每趟循环的找到最小值
            for (int j=i+1; j<nums.length; j++){
                if (nums[j]< nums[i]){
                    minIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
}
