package sort;

/**
 * @program: QAproject
 * @description: 冒泡排序
 * @author: bjweiman
 * @create: 2019-04-05 14:01
 **/
public class BubbleSort {
    public static void sort(int[] nums){
        if (nums == null || nums.length==0 || nums.length == 1) return;

        //外层循环控制排序趟数
        for (int i=0; i<nums.length-1; i++){
            //内层循环 控制每次比较的排序
            for (int j=0; j<nums.length-1-i; j++){
                if (nums[j]>nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
       int[] arr={6,3,8,2,9,1};

       sort(arr);

        for (int i : arr) {
            System.out.print(i+",");
        }
    }
}
