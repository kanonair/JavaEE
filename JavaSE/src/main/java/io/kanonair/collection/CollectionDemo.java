package io.kanonair.collection;

import org.junit.Test;

import java.util.*;

public class CollectionDemo {

    /**
     * Collection
     */
    @Test
    public void example01() {
        Collection<Person> col = new ArrayList<>();
        // 添加
        col.add(new Person(18, "Taylor"));
        col.add(new Person(19, "Taylor"));
        col.add(new Person(20, "Taylor"));
        System.out.println(col);
        // 包含
        System.out.println(col.contains(new Person(18, "Taylor")));
        boolean containsAll = col.containsAll(
                Arrays.asList(new Person(19, "Taylor"), new Person(20, "Taylor")));
        System.out.println(containsAll);
        // 移除
        col.remove(new Person(19, "Taylor"));
        System.out.println(col);
        // 迭代
        for (Person person : col) {
            System.out.println(person);
        }
    }

    /**
     * List:有序 可重复
     * <p>
     * ArrayList:查询
     * <p>
     * LinkedList:增删
     */
    @Test
    public void example02() {
        ArrayList<Person> arrayList = new ArrayList<>();
        // 添加
        arrayList.add(new Person(18, "Taylor"));
        arrayList.add(new Person(20, "Taylor"));
        System.out.println(arrayList);
        // 修改
        arrayList.set(1, new Person(19, "Taylor"));
        // 获取
        System.out.println(arrayList.get(1));
        // 位置
        System.out.println(arrayList.indexOf(new Person(18, "Taylor")));
        // 截取
        System.out.println(arrayList.subList(0, 1));
        // 删除
        arrayList.remove(1);
        System.out.println(arrayList);
        // 清空
        arrayList.clear();
        System.out.println(arrayList);
        arrayList.add(new Person(18, "Taylor"));
        arrayList.add(new Person(19, "Taylor"));
        arrayList.add(new Person(20, "Taylor"));
        arrayList.add(new Person(21, "Taylor"));
        arrayList.add(new Person(22, "Taylor"));
        // 遍历
        for (Person person : arrayList) {
            System.out.println(person);
        }
    }

    /**
     * Set:无序 不可重复
     * <p>
     * HashSet:
     * <p>
     * LinkedHashSet:
     * <p>
     * TreeSet:
     */
    @Test
    public void example03() {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person(18, "Taylor"));
        set.add(new Person(20, "Taylor"));
        set.add(new Person(20, "Taylor"));
        set.add(new Person(20, "Taylor"));
        set.add(new Person(20, "Taylor"));
        set.add(new Person(20, "Taylor"));
        set.add(new Person(20, "Taylor"));
        set.add(new Person(20, "Taylor"));
        set.add(new Person(24, "Taylor"));
        set.add(new Person(27, "Taylor"));
        set.add(new Person(28, "Taylor"));
        System.out.println(set);
        TreeSet<Person> treeSet = new TreeSet<>((o1, o2) -> o2.getAge() - o1.getAge());
        treeSet.addAll(set);
        System.out.println(treeSet);
    }

    /**
     * Map
     */
    @Test
    public void example04() {
        HashMap<String, String> map = new HashMap<>();
        map.put("s1", "A");
        map.put("s2", "B");
        map.put("s3", "C");
        Set<String> keySet = map.keySet();
        keySet.forEach(key -> System.out.println(map.get(key)));
        Collection<String> values = map.values();
        values.forEach(System.out::println);
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        entrySet.forEach(entry -> {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        });
    }

    /**
     * Collections
     */
    @Test
    public void example05() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 反转
        Collections.reverse(list);
        System.out.println(list);
        // 随机
        Collections.shuffle(list);
        System.out.println(list);
        // 排序
        Collections.sort(list);
        System.out.println(list);
        // 交换
        Collections.swap(list, 0, 1);
        System.out.println(list);
        // 频率
        int frequency = Collections.frequency(list, 1);
        System.out.println(frequency);
        // 复制
        List<Integer> dest = Arrays.asList(new Integer[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);
        // 同步
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        System.out.println(synchronizedList);
    }

}
