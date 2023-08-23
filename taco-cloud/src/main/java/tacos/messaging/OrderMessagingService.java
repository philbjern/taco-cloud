package tacos.messaging;

import tacos.model.TacoOrder;

public interface OrderMessagingService {

    void sendOrder(TacoOrder order);

}
