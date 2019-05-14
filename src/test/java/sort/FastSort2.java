package sort;

/**
 * @program: QAproject
 * @description: 快排2
 * @author: bjweiman
 * @create: 2019-04-08 20:40
 **/
public class FastSort2 {
    public static void quickSort_1(int[] data, int start, int end) {
        if (data == null || start < 0 || end > data.length - 1) {
            throw new IllegalArgumentException("Invalid Parameters");
        }
        if (start == end) return;
        int index = partition(data, start, end);
        if (index > start) {
            quickSort_1(data, start, index - 1);
        }
        if (index < end) {
            quickSort_1(data, index + 1, end);
        }
    }

    private static int partition(int[] data, int start, int end) {
        int index = start + (int)(Math.random() * (end - start + 1));
        swap(data, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }
        swap(data, small + 1, end);
        return small + 1;
    }

    private static void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String []args){
        System.out.println("Hello World");
        int[] a = {12,20,5,16,15,1,30,45,23,9};
        int start = 0;
        int end = a.length-1;
        quickSort_1(a,start,end);
        for(int i = 0; i<a.length; i++){
            System.out.print(a[i]+",");
        }

    }
}
