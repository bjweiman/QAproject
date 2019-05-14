package MapSort;

import java.util.*;

/**
 * @program: QAproject
 * @description: treeMap value排序
 * @author: bjweiman
 * @create: 2019-04-02 20:53
 **/
public class TreeMapValeSort {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("d", "ddddd");
        map.put("b", "bbbbb");
        map.put("a", "aaaaa");
        map.put("c", "ccccc");

        List<Map.Entry<String, String>>  list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, String> stringStringEntry : list) {
            System.out.println("getKey:" + stringStringEntry.getKey() + " getValue" + stringStringEntry.getValue());
        }
    }
}
