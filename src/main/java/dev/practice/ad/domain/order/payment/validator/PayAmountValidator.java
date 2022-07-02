package dev.practice.ad.domain.order.payment.validator;

import dev.practice.ad.common.exception.InvalidParamException;
import dev.practice.ad.domain.order.Order;
import dev.practice.ad.domain.order.OrderCommand;
import org.springframework.stereotype.Component;

@org.springframework.core.annotation.Order(value = 1)
@Component
public class PayAmountValidator implements PaymentValidator {

    @Override
    public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
        if (!order.calculateTotalAmount().equals(paymentRequest.getAmount()))
            throw new InvalidParamException("주문가격이 불일치합니다");
    }
}
