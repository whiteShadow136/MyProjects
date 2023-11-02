/**
 * @Description:PACKAGE_NAME
 * @Date:2023/11/1
 * @Author:谢锦创
 */
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);

            // 在遍历过程中尝试修改列表
            if (item.equals("A")) {
                list.remove(item);
            }
        }

//        for (String item : list) {
//            System.out.println(item);
//
//            // 在foreach循环中尝试修改列表
//            if (item.equals("B")) {
//                list.remove(item);
//            }
//        }

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            System.out.println(item);
//
//            if (item.equals("B")) {
//                list.remove(item);
//            }
//        }

        // 成功报错的
//        List<String> myList = new ArrayList<String>();
//
//        myList.add("1");
//        myList.add("2");
//        myList.add("3");
//        myList.add("4");
//        myList.add("5");
//
//        Iterator<String> it = myList.iterator();
//        while (it.hasNext()) {
//            String value = it.next();
//            System.out.println("List Value:" + value);
//            if (value.equals("2"))
//                myList.remove(value);
//        }

//        Map<String, String> myMap = new HashMap<String, String>();
//        myMap.put("1", "1");
//        myMap.put("2", "2");
//        myMap.put("3", "3");
//
//        Iterator<String> it1 = myMap.keySet().iterator();
//        while (it1.hasNext()) {
//            String key = it1.next();
//            System.out.println("Map Value:" + myMap.get(key));
//            if (key.equals("2")) {
//                myMap.put("1", "4");
//                // myMap.put("4", "4");
//            }
//        }

    }

}
