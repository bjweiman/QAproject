package MapSort;

import org.testng.collections.Lists;

import java.util.*;

/**
 * @program: QAproject
 * @description: TreeMapTest
 * @author: bjweiman
 * @create: 2019-03-30 21:04
 **/
public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
        map.put("c", "ccccc");
        map.put("a", "aaaaa");
        map.put("b", "bbbbb");
        map.put("d", "ddddd");

        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key + ":" + map.get(key));
        }

    }
}


class TreeMapTest2{

    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("d", "ddddd");
        map.put("b", "bbbbb");
        map.put("a", "aaaaa");
        map.put("c", "ccccc");

        List<Map.Entry<String ,String >> list = new ArrayList<Map.Entry<String ,String >>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
    }
}

class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("c", "ccccc");
        map.put("a", "aaaaa");
        map.put("b", "bbbbb");
        map.put("d", "ddddd");

        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(Map.Entry<String,String> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}

 class HashMapTest2 {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("c", "ccccc");
        map.put("a", "aaaaa");
        map.put("b", "bbbbb");
        map.put("d", "ddddd");


        List<String> list = new ArrayList<>(map.keySet());
        for (String s : list) {
            System.out.println("key:" + s + " value:" + map.get(s));
        }

    }
}