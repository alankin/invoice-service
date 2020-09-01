package aforo255.ms.test.invoiceservice.service;

import aforo255.ms.test.invoiceservice.entity.Operation;

public interface IOperationService {

    public Operation save(Operation Operation);

    public Iterable<Operation> findAll();

    public Operation findById(Integer operationId);
}