package aforo255.ms.test.invoiceservice.dao;

import aforo255.ms.test.invoiceservice.entity.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDao extends CrudRepository<Operation, Integer> {

}
