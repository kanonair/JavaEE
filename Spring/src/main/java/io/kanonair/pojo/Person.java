package io.kanonair.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private Integer id;
    private String name;
    private String phone;
    private Integer age;
    private Car car;
    private List<Object> list;
}
