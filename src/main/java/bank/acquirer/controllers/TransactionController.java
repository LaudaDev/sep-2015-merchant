package bank.acquirer.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bank.acquirer.dto.TransactionRequestDTO;
import bank.acquirer.dto.TransactionResponseDTO;
import bank.acquirer.service.PccLookupService;
import bank.acquirer.service.TransactionLogService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	private PccLookupService pccLookupService;
	
	@Autowired
	private TransactionLogService transactionLogService;
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public TransactionResponseDTO processTransaction(
			@Valid
			@RequestBody TransactionRequestDTO transactionRequest) {

		LOGGER.info("Received transaction request: {}", transactionRequest);
		
		TransactionResponseDTO transactionResponse = 
				pccLookupService.postForTransactionResponse(transactionRequest);
		
		transactionLogService.createTransactionLog(transactionRequest, transactionResponse);
		
		return transactionResponse;
	}
	
}

