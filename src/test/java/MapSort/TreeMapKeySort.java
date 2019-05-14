package MapSort;


import java.util.*;

/**
 * @program: QAproject
 * @description: treeMap 值排序
 * @author: bjweiman
 * @create: 2019-04-02 20:11
 **/
public class TreeMapKeySort {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("d", "ddddd");
        map.put("b", "bbbbb");
        map.put("a", "aaaaa");
        map.put("c", "ccccc");

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String s : list) {
            System.out.println("key:" + s + " value:" + map.get(s));
        }
    }

}
