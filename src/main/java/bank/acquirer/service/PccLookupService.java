package bank.acquirer.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import bank.acquirer.config.PccApiProperties;
import bank.acquirer.domain.TransactionStatus;
import bank.acquirer.dto.TransactionRequestDTO;
import bank.acquirer.dto.TransactionResponseDTO;

@Service
public class PccLookupService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PccLookupService.class);
	
	@Autowired
	private PccApiProperties pccApiProperties;
	
	private final RestTemplate restClient = new RestTemplate();

	public TransactionResponseDTO postForTransactionResponse(TransactionRequestDTO request) {
		
		String requestUrl = pccApiProperties.getBaseUrl() + pccApiProperties.getResourceName();
		
		LOGGER.info("Forwarding transaction request to PCC api : {}", requestUrl);
		
		TransactionResponseDTO transactionResponse;
		try {
			transactionResponse = 
					restClient.postForObject(requestUrl, request, TransactionResponseDTO.class);
		} catch (Exception e) {
			LOGGER.debug("Exception thrown while posting to PCC: {}", e.getMessage());
			
			transactionResponse = createTransactionResponseWithServerError();
		}
		
		LOGGER.info("Response from PCC api: {}", transactionResponse);
		
		return transactionResponse;
	}
	
	private static TransactionResponseDTO createTransactionResponseWithServerError() {
		TransactionStatus transactionStatus = 
				new TransactionStatus("05", "SERVER_ERROR");
		
		TransactionResponseDTO transactionResponse = 
				new TransactionResponseDTO();
		
		transactionResponse.setTransactionStatus(transactionStatus);
		
		return transactionResponse;
	}
	
}
