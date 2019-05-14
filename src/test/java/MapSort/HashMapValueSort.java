package MapSort;

import java.util.*;

/**
 * @program: QAproject
 * @description: map值排序
 * @author: bjweiman
 * @create: 2019-04-02 20:06
 **/
public class HashMapValueSort {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(1,"a");
        map.put(23,"c");
        map.put(5,"e");
        map.put(2,"b");
        map.put(11,"l");

        List<Map.Entry<Integer, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<Integer, String> integerStringEntry : list) {
            System.out.println("key:" + integerStringEntry.getKey() + " value:" +integerStringEntry.getValue());
        }
    }


}
