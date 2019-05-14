package sort;

/**
 * @program: QAproject
 * @description: 插入排序
 * @author: bjweiman
 * @create: 2019-04-05 15:42
 **/
public class InsertSort {

    /**
     * 插入排序是简单排序中最快的排序算法，虽然时间复杂度仍然为O(n*n)，但是却比冒泡排序和选择排序快很多。
     * 1、将指针指向某个元素，假设该元素左侧的元素全部有序，将该元素抽取出来，然后按照从右往左的顺序分别与其左边的元素比较，
     * 遇到比其大的元素便将元素右移，直到找到比该元素小的元素或者找到最左面发现其左侧的元素都比它大，停止；
     * 2、此时会出现一个空位，将该元素放入到空位中，此时该元素左侧的元素都比它小，右侧的元素都比它大；
     * 3、指针向后移动一位，重复上述过程。每操作一轮，左侧有序元素都增加一个，右侧无序元素都减少一个。
     * @param nums
     */
    public static void insertSort(int[] nums){
        if (nums == null||nums.length == 1) return;

        for (int i=1; i<nums.length; i++){
            int tempIndex = i;
            for (int j=tempIndex; j>0; j--){
                if(nums[j-1] > nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3,1,5,7,2,4,9,6};
        insertSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
