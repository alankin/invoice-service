package aforo255.ms.test.invoiceservice.dao;

import aforo255.ms.test.invoiceservice.entity.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDao extends CrudRepository<Invoice, Integer> {

}
