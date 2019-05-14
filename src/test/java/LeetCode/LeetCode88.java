package LeetCode;

/**
 * @program: QAproject
 * @description: 合并两个有序数组
 * @author: bjweiman
 * @create: 2019-04-03 11:37
 **/
public class LeetCode88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums1.length == 0) printNums(nums2);
        if(nums2 == null || nums2.length == 0) {
            printNums(nums1);
        }

        int p=0;
        int q=0;

        int[] numsNew = new int[m+n];
        for(int i=0; i<m+n; i++){
            if(p>=m){
                numsNew[i] = nums2[q];
                q++;
                continue;
            }
            if(q >=n){
                numsNew[i] = nums1[p];
                p++;
                continue;
            }
            if(p<m&&q<n){
                if(nums1[p]<=nums2[q]){
                    numsNew[i]  = nums1[p];
                    p++;
                    continue;
                }else{
                    numsNew[i] = nums2[q];
                    q++;
                    continue;
                }


            }
        }
        nums1 = numsNew;

        System.out.println(printNums(nums1));
    }

    public static String printNums(int[] nums){
        String str = "[";
        if(nums.length != 0){
            for(int i=0; i<nums.length; i++){
                if(i<nums.length-1) {
                    str += nums[i] + ",";
                }
                else{
                    str += nums[i] + "";
                }
            }
        }
        str+="]";
        return str;
    }

    public static void main(String[] args) {

        int m=3, n = 3;
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];
        for (int i = 0; i <m; i++) {
            nums1[i] = i+1;
        }
        nums2[0] = 2;
        nums2[1] = 5;
        nums2[2] = 6;

      /*  for (int i = 0; i < n; i++) {
            nums2[i] = i+2;
        }*/
        merge(nums1, m, nums2, n);
    }
}
