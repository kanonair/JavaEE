package io.kanonair.mapper;

import io.kanonair.pojo.Order;

import java.util.List;

public interface OrderMapper {

    Order selectById(Integer id);

    List<Order> selectByUserId(Integer id);

}
