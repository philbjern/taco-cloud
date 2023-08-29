package tacos.kitchen.messaging;

import tacos.model.TacoOrder;

public interface OrderReceiver {

    TacoOrder receiveOrder();

}
