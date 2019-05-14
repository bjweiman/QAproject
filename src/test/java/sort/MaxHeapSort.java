package sort;

/**
 * @program: QAproject
 * @description: 最大堆排序
 * @author: bjweiman
 * @create: 2019-04-06 10:35
 **/
public class MaxHeapSort {
    public static void createMaxHeap(int[] nums, int start, int end){

        int temp = start;
        int left = 2*temp +1;
        int right = left+1;

        for(;left<=end; temp=left,left=2*left+1){
            //左节点如果大于根节点，交换

            if (left<end && nums[left]<nums[left+1]){
                left++;
            }
            if (nums[left]>nums[temp]){
                int value = nums[left];
                nums[left] = nums[temp];
                nums[temp] = value;
            }
        }
    }

    public static void heapAsc(int[] nums, int n){{
        for (int i=n/2-1; i>=0; i--){
            createMaxHeap(nums, i, n-1);
        }
        for (int i=0; i<nums.length; i++)
            System.out.printf("%d ", nums[i]);
        System.out.printf("\n");
        for (int i=n-1; i>0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            createMaxHeap(nums, 0, i-1);
        }
    }

    }


    public static void main(String[] args) {
        int i;
        int a[] = {20,30,90,40,70,110,60,10,100,50,80};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        heapAsc(a, a.length);            // 升序排列
        //heapSortDesc(a, a.length);        // 降序排列

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
