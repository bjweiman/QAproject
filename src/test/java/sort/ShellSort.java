package sort;

/**
 * @program: QAproject
 * @description: 希尔排序
 * @author: bjweiman
 * @create: 2019-04-05 16:28
 **/
public class ShellSort {
    public static void shellSort(int[] nums){
        if (nums == null||nums.length == 1) return;

        int incrementNum = nums.length/2;

        while (incrementNum>=1){
            for (int i=incrementNum; i<nums.length; i++){
                for (int j=i; j>=incrementNum; j=j-incrementNum){
                    if (nums[j] < nums[j-incrementNum]){
                        int temp = nums[j];
                        nums[j] = nums[j-incrementNum];
                        nums[j-incrementNum] = temp;
                    }
                }
            }
            incrementNum = incrementNum/2;
            for (int i : nums) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {3,1,5,7,2,4,9,6};
        shellSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
