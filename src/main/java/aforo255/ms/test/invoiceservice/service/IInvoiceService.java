package aforo255.ms.test.invoiceservice.service;

import aforo255.ms.test.invoiceservice.entity.Invoice;

public interface IInvoiceService {

    public Invoice save(Invoice invoice);

    public Iterable<Invoice> findAll();

    public Invoice findById(Integer invoiceId);
}