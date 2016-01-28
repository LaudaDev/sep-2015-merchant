package bank.acquirer;

import java.math.BigDecimal;
import java.util.Date;

import bank.acquirer.domain.AcquirerInfo;
import bank.acquirer.domain.CardInfo;
import bank.acquirer.domain.TransactionRequest;

public class TransactionsUtil {

	static TransactionRequest createValidTransactionRequest() {
		TransactionRequest transactionRequest;
		
		CardInfo cardInfo = new CardInfo("123456789", 2, "Marko Markovic", "10/2016");
		AcquirerInfo acquirerInfo = new AcquirerInfo(100L, new Date());
		
		transactionRequest = new TransactionRequest(cardInfo, acquirerInfo, new BigDecimal(1000));
		
		return transactionRequest;
	}

}
