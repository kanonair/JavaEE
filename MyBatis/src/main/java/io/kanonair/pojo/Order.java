package io.kanonair.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    private Double price;
    private Date time;
    private User user;
}
