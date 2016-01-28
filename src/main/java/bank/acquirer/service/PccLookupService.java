package bank.acquirer.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import bank.acquirer.config.PccApiProperties;
import bank.acquirer.domain.TransactionRequest;
import bank.acquirer.domain.TransactionResponse;

@Service
public class PccLookupService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PccLookupService.class);
	
	@Autowired
	private PccApiProperties pccApiProperties;
	
	final RestTemplate restTemplate = new RestTemplate();
	
	public TransactionResponse postForTransactionResponse(TransactionRequest request) {
		String requestUrl = pccApiProperties.getBaseUrl() + pccApiProperties.getResourceName();
		
		LOGGER.info("Forwarding transaction request to PCC api : {}", requestUrl);
		
		TransactionResponse response = restTemplate.postForObject(
				requestUrl, request, TransactionResponse.class);
		
		LOGGER.info("Response from PCC api: {}", response);
		
		return response;
	}
	
}
