package dev.practice.ad.domain.order;

import dev.practice.ad.domain.order.item.OrderItem;
import dev.practice.ad.domain.order.item.OrderItemOption;
import dev.practice.ad.domain.order.item.OrderItemOptionGroup;

public interface OrderStore {
    Order store(Order order);
    OrderItem store(OrderItem orderItem);
    OrderItemOptionGroup store(OrderItemOptionGroup orderItemOptionGroup);
    OrderItemOption store(OrderItemOption orderItemOption);
}
