package io.kanonair.java8;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> init() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Taylor1", 18, 10000.0));
        list.add(new Employee(2, "Taylor2", 19, 11000.0));
        list.add(new Employee(3, "Taylor3", 20, 10100.0));
        list.add(new Employee(4, "Taylor4", 21, 10010.0));
        list.add(new Employee(5, "Taylor5", 22, 10001.0));
        return list;
    }
}
