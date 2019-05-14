package search;

/**
 * @program: QAproject
 * @description: 插值查找
 * @author: bjweiman
 * @create: 2019-04-06 13:56
 **/
public class InsertValueSearch {
    /**
     * 插值查找算法类似于二分查找，不同的是插值查找每次从自适应mid处开始查找，例如我们要从1~100找5这个数，
     那我们就会从前边开始找，插值查找就是应用这种原理
     插值公式： mid = left+(x-a[left])/(a[right]-a[left])*(right-left);
     */
    public static int insertValueSearch(int[] nums, int key){
        int left = 0;
        int right = nums.length-1;

        while (left<right){

            int mid = left + (key-nums[left])*(right-left)/(nums[right]-nums[left]);

            if (nums[mid] == key) return mid;
            if (nums[mid] > key) right = mid - 1;
            if (nums[mid]<key) left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,43,55,56,98};
        System.out.println(insertValueSearch(nums, 43));
    }
}
