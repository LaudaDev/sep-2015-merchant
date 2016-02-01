package bank.acquirer.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import bank.acquirer.domain.TransactionLog;
import bank.acquirer.dto.TransactionRequestDTO;
import bank.acquirer.dto.TransactionResponseDTO;
import bank.acquirer.repository.TransactionLogRepository;

@Service
public final class TransactionLogService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionLogService.class);
	
	private final TransactionLogRepository transactionRepository;
	
	@Autowired
	public TransactionLogService(TransactionLogRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	
	/**
	 * Creates a new log entry for transaction asynchronously,
	 * so api clients doesn't have to wait log creation to be finished.
	 * @param request - transaction request
	 * @param response - transaction response
	 */
	@Async
	public void createTransactionLog(
			TransactionRequestDTO request, 
			TransactionResponseDTO response) {
		
		boolean sucessLogReturnedFromIssuer = 
				response.getAcquirerInfo() != null 
				&& response.getIssuerInfo() != null;
		
		if (sucessLogReturnedFromIssuer) {
			createSucessLog(request, response);
		} else {
			createFailureLog(request, response);
		}
	}
	
	/**
	 * Creates a new log entry for transaction requests
	 * successfully processed by issuer api
	 * @param request - transaction request
	 * @param response - transaction response
	 */
	private void createSucessLog(
			TransactionRequestDTO request, 
			TransactionResponseDTO response) {
		
		TransactionLog persistedLog = TransactionLog.getBuilder()
			.logDate(new Date())
			.acquirerInfo(request.getAcquirerInfo())
			.issuerInfo(response.getIssuerInfo())
			.transactionStatus(response.getTransactionStatus())
			.transactionAmount(request.getTransactionAmount())
			.build();
		
		persistedLog = transactionRepository.save(persistedLog);
		
		LOGGER.info("Created a new transaction log entry: {}", persistedLog);
	}
	
	/**
	 * Creates a new log entry for transaction requests
	 * with some of internal errors when issuer didn't return
	 * valid answer.
	 * @param request - transaction request
	 * @param response - transaction response
	 */
	private void createFailureLog(
			TransactionRequestDTO request, 
			TransactionResponseDTO response) {
		
		TransactionLog persistedLog = TransactionLog.getBuilder()
			.logDate(new Date())
			.acquirerInfo(request.getAcquirerInfo())
			.transactionStatus(response.getTransactionStatus())
			.transactionAmount(request.getTransactionAmount())
			.build();
		
		persistedLog = transactionRepository.save(persistedLog);
		
		LOGGER.info("Created a new transaction log entry: {}", persistedLog);
	}
	
}
