package dev.practice.ad.domain.order.payment.validator;

import dev.practice.ad.common.exception.InvalidParamException;
import dev.practice.ad.domain.order.Order;
import dev.practice.ad.domain.order.OrderCommand;
import org.springframework.stereotype.Component;

@org.springframework.core.annotation.Order(value = 3)
@Component
public class PayStatusValidator implements PaymentValidator {

    @Override
    public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
        if (order.isAlreadyPaymentComplete()) throw new InvalidParamException("이미 결제완료된 주문입니다");
    }
}
