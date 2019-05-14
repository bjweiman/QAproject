package sort;

/**
 * @program: QAproject
 * @description: 归并排序
 * @author: bjweiman
 * @create: 2019-04-05 17:03
 **/
public class MergeSort {
    public static void sort(int[] nums, int low, int high){
        if (nums == null) return;
        if (nums.length == 1) return;

        int mid = (low+high)/2;
        if (low<high){
            sort(nums,low, mid);
            sort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }

    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] array = {3,1,5,7,2,4,9,6};
        sort(array, 0, array.length-1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

}
