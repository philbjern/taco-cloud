package tacos.kitchen.messaging.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import tacos.kitchen.messaging.OrderReceiver;
import tacos.model.TacoOrder;

@Component
public class RabbitOrderReceiver implements OrderReceiver {

    private RabbitTemplate rabbit;
    private MessageConverter converter;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
        this.converter = rabbit.getMessageConverter();
    }

    @Override
    public TacoOrder receiveOrder() {
        Message message = rabbit.receive("tacocloud.order");
        return message != null
                ? (TacoOrder) converter.fromMessage(message)
                : null;
    }

    public TacoOrder receiveAndConvertOrder() {
        return rabbit.receiveAndConvert("tacocloud.order.queue",
                new ParameterizedTypeReference<TacoOrder>() {});
    }

}
