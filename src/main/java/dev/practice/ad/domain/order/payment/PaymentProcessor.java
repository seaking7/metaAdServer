package dev.practice.ad.domain.order.payment;

import dev.practice.ad.domain.order.Order;
import dev.practice.ad.domain.order.OrderCommand;

public interface PaymentProcessor {
    void pay(Order order, OrderCommand.PaymentRequest request);
}