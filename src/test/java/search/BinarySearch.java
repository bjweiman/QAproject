package search;

/**
 * @program: QAproject
 * @description: 二分查找
 * @author: bjweiman
 * @create: 2019-04-06 13:26
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6,7};
        System.out.println(binarySearch(nums, 3));
    }
    public static int binarySearch(int[] nums, int key){
        int low = 0;
        int high = nums.length-1;

        while (low<=high){
            int mid = (high+low)/2;
            if (nums[mid] == key)
                return mid;
            if (nums[mid]>key)
                high = mid -1;

            if (nums[mid]<key)
                low = mid + 1;
        }

        return -1;
    }
}
