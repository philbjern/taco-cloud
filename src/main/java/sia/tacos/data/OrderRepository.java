package sia.tacos.data;

import sia.tacos.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
