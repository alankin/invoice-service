package aforo255.ms.test.invoiceservice.controller;


import aforo255.ms.test.invoiceservice.entity.Invoice;
import aforo255.ms.test.invoiceservice.service.IInvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceEventController {

    private Logger logger = LoggerFactory.getLogger(InvoiceEventController.class);

    @Autowired
    private IInvoiceService service;


    @GetMapping("/invoices")
    public List<Invoice> listInvoices() {
        return (List<Invoice>) service.findAll();
    }
}
