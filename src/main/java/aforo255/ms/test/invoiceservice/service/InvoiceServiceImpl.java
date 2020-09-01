package aforo255.ms.test.invoiceservice.service;

import aforo255.ms.test.invoiceservice.dao.InvoiceDao;
import aforo255.ms.test.invoiceservice.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

    @Autowired
    private InvoiceDao repository;

    @Override
    public Invoice save(Invoice invoice) {
        return repository.save(invoice);
    }

    @Override
    public Iterable<Invoice> findAll() {
        return repository.findAll();
    }

    @Override
    public Invoice findById(Integer invoiceId) {
        return repository.findById(invoiceId).orElse(null);
    }
}
