package dev.practice.ad.infrastructure.order.payment;

import dev.practice.ad.domain.order.OrderCommand;
import dev.practice.ad.domain.order.payment.PayMethod;

public interface PaymentApiCaller {
    boolean support(PayMethod payMethod);
    void pay(OrderCommand.PaymentRequest request);
}
