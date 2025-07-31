package sv.com.webster.orders.interfaces.controller;

import java.util.List;

public record CreateOrderDTO(String clientEmail, List<CreateOrderDetailDTO> details) {
}
