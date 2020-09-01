package aforo255.ms.test.invoiceservice.kafka.listener;

import aforo255.ms.test.invoiceservice.service.TransactionEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventsConsumer {

    @Autowired
    public TransactionEvents transactionEvents;

    private Logger log = LoggerFactory.getLogger(TransactionEventsConsumer.class);

    @KafkaListener(topics = {"transaction-events"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        log.info("ConsumerRecord: {}", consumerRecord.value());
        transactionEvents.process(consumerRecord);
    }

}
