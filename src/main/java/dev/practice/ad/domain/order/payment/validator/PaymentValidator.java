package dev.practice.ad.domain.order.payment.validator;

import dev.practice.ad.domain.order.Order;
import dev.practice.ad.domain.order.OrderCommand;

public interface PaymentValidator {
    void validate(Order order, OrderCommand.PaymentRequest paymentRequest);
}
