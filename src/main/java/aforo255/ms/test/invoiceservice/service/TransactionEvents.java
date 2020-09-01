package aforo255.ms.test.invoiceservice.service;

import aforo255.ms.test.invoiceservice.entity.Invoice;
import aforo255.ms.test.invoiceservice.entity.Operation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionEvents {

    private Logger logger = LoggerFactory.getLogger(TransactionEvents.class);

    @Autowired
    private IInvoiceService invoiceService;

    @Autowired
    private IOperationService operationService;

    @Autowired
    private ObjectMapper objectMapper;

    public void process(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        Operation operation = objectMapper.readValue(consumerRecord.value(), Operation.class);

        operationService.save(operation);

        Invoice invoice = invoiceService.findById(operation.getIdInvoice());

        if (invoice != null) {
            logger.info("Updating invoice register with id: {} and amount: {}", operation.getIdInvoice(), operation.getAmount());
            invoice.setAmount(invoice.getAmount() - operation.getAmount());
            invoiceService.save(invoice);
            logger.info("Updated, invoice amount now is: {}", invoice.getAmount());
        }

    }
}
