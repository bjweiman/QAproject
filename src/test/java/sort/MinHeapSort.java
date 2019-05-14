package sort;

/**
 * @program: QAproject
 * @description: 最小堆排序
 * @author: bjweiman
 * @create: 2019-04-06 11:25
 **/
public class MinHeapSort {
    public static void heapDesc(int[] nums, int n){
        for(int i=n/2-1; i>=0; i--){
            createMinHeap(nums, i, n-1);
        }
        for (int i=0; i<nums.length; i++)
            System.out.printf("%d ", nums[i]);
        System.out.printf("\n");

        for (int i=n-1; i>0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            createMinHeap(nums, 0, i-1);
        }
    }

    public static void createMinHeap(int[] nums, int start, int end){
        int c = start;
        int left = 2*start +1;
        int temp = nums[c];

        for(;left<end; c=left, left=2*left+1){
            if (left<end && nums[left]>nums[left+1]){
                left++;
            }

            if(temp<=nums[left]) break;
            else {
                nums[c] = nums[left];
                nums[left] = temp;
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

        heapDesc(a, a.length);            // 升序排列
        //heapSortDesc(a, a.length);        // 降序排列

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
