package MapSort;

import java.util.*;

/**
 * @program: QAproject
 * @description: hashmap key排序
 * @author: bjweiman
 * @create: 2019-04-02 19:59
 **/
public class HashMapKeySort {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(1,"a");
        map.put(3,"c");
        map.put(5,"e");
        map.put(2,"b");
        map.put(11,"l");

        List<Integer> list = new ArrayList<Integer>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o1);
            }
        });

        for (Integer integer : list) {
            System.out.println("key:"+ integer  + " value:"+map.get(integer));
        }
    }
}
