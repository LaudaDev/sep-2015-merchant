package bank.acquirer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import bank.acquirer.domain.TransactionRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonMappingTests {
	
	@Test
	public void mapTransactionRequestToJson_ShouldContainAllTransactionAttributes() throws JsonProcessingException {

		ObjectMapper mapper = createObjectMapper();
		TransactionRequest request = TransactionsUtil.createValidTransactionRequest();
		
		String requestAsJson = mapper.writeValueAsString(request);
		
		boolean jsonContainsCardInfo = requestAsJson.indexOf("cardInfo") != -1;
		boolean jsonContainsAcquirerInfo = requestAsJson.indexOf("acquirerInfo") != -1;
		boolean jsonContainsTransactionAmount = requestAsJson.indexOf("transactionAmount") != -1;
		boolean allAttributesMapped = jsonContainsCardInfo 
				&& jsonContainsAcquirerInfo 
				&& jsonContainsTransactionAmount;
		
		assertTrue(allAttributesMapped);
	}
	
	@Test
	public void parseJsonFromInputStream_WithValidJson_ShouldCreateTransactionRequest() {

		ObjectMapper objectMapper = createObjectMapper();
		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream("validTransactionRequest.json");

		TransactionRequest transacactionRequest = null;

		try {
			transacactionRequest = objectMapper.readValue(inputStream,
					TransactionRequest.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertNotNull(transacactionRequest);
	}
	
	@Test(expected = JsonMappingException.class)
	public void parseJsonFromInputStream_WithInvalidAcquirerTimestampFormat_ShouldThrowException() 
			throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = createObjectMapper();
		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream("invalidTimestampFormatTransactionRequest.json");
		
		objectMapper.readValue(inputStream, TransactionRequest.class);
	}
	
	@Test
	public void testMappingObjectToJson() throws JsonProcessingException {
		TransactionRequest request = TransactionsUtil.createValidTransactionRequest();
		
		ObjectMapper mapper = createObjectMapper();
		
		System.out.println(mapper.writeValueAsString(request));
	}
	
	private static ObjectMapper createObjectMapper() {
		return new ObjectMapper();
	}
}
