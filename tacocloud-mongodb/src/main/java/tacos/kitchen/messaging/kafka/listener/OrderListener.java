package tacos.kitchen.messaging.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import tacos.kitchen.KitchenUI;
import tacos.model.TacoOrder;

import java.util.Locale;

@Component
public class OrderListener {

    private KitchenUI ui;
    private Logger log;

    @Autowired
    public OrderListener(KitchenUI ui, Logger log) {
        this.ui = ui;
        this.log = log;
    }

//    @KafkaListener(topics = "tacocloud.orders.topic", groupId = "sia")
//    public void handle(TacoOrder order) {
//        ui.displayOrder(order);
//    }
//
//    @KafkaListener(topics = "tacocloud.orders.topic", groupId = "sia")
//    public void handle(TacoOrder order, ConsumerRecord<String, TacoOrder> record) {
//        log.info("Received from partition {} with timestamp {}", record.partition(), record.timestamp());
//        ui.displayOrder(order);
//    }
//
//    @KafkaListener(topics = "tacocloud.orders.topic", groupId = "sia")
//    public void handle(TacoOrder order, Message<TacoOrder> message) {
//        MessageHeaders headers = message.getHeaders();
//        log.info("Received from partition {} with timestamp {}",
//                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID),
//                headers.get(KafkaHeaders.RECEIVED_TIMESTAMP));
//        ui.displayOrder(order);
//    }

}
