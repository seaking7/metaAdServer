package dev.practice.ad.domain.order;

public interface OrderReader {
    Order getOrder(String orderToken);
}
