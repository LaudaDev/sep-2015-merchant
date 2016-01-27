package bank.acquirer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bank.acquirer.domain.TransactionRequest;
import bank.acquirer.domain.TransactionResponse;

@RestController
@RequestMapping("/api/bank/acquirer")
public class TransactionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public TransactionResponse processTransaction(
			@RequestParam TransactionRequest transactionRequest) {

		LOGGER.info("Sending new transaction request to PCC : {}", transactionRequest);

		// TODO: Pass transaction request to PCC and return the result
		return null;
	}
}
