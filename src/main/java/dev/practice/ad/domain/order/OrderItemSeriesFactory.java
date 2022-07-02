package dev.practice.ad.domain.order;

import dev.practice.ad.domain.order.item.OrderItem;

import java.util.List;

public interface OrderItemSeriesFactory {
    List<OrderItem> store(Order order, OrderCommand.RegisterOrder requestOrder);
}
