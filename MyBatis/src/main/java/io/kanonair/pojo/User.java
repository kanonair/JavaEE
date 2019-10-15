package io.kanonair.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String name;
    private Integer sex;
    private List<Order> orderList;
}
