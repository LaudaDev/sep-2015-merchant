package bank.acquirer;

import java.math.BigDecimal;
import java.util.Date;

import bank.acquirer.domain.AcquirerInfo;
import bank.acquirer.domain.CardInfo;
import bank.acquirer.dto.TransactionRequestDTO;

public class TransactionsUtil {

	static TransactionRequestDTO createValidTransactionRequest() {
		TransactionRequestDTO transactionRequest;
		
		CardInfo cardInfo = new CardInfo("123456789", 2, "Marko Markovic", "10/2016");
		AcquirerInfo acquirerInfo = new AcquirerInfo(100, new Date());
		
		transactionRequest = new TransactionRequestDTO(cardInfo, acquirerInfo, new BigDecimal(1000));
		
		return transactionRequest;
	}

}
