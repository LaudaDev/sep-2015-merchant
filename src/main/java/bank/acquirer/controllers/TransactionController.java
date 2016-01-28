package bank.acquirer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bank.acquirer.domain.TransactionRequest;
import bank.acquirer.domain.TransactionResponse;
import bank.acquirer.service.PccLookupService;

@RestController
@RequestMapping("/api/bank/acquirer")
public class TransactionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	private PccLookupService pccLookupService;
	
	@RequestMapping(value = "/auth", 
			method = RequestMethod.POST)
	public TransactionResponse processTransaction(
			@RequestBody TransactionRequest transactionRequest) {

		LOGGER.info("Received transaction request : {}", transactionRequest);
		
		TransactionResponse response = 
				pccLookupService.postForTransactionResponse(transactionRequest);
		
		return response;
	}
}
