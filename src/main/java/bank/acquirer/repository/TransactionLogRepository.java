package bank.acquirer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bank.acquirer.domain.TransactionLog;

public interface TransactionLogRepository extends MongoRepository<TransactionLog, String> {

}
