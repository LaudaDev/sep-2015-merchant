package bank.acquirer.domain;

import java.math.BigDecimal;

public final class TransactionRequest {

	private CardInfo cardInfo;

	private AcquirerInfo acquirerInfo;

	private BigDecimal transactionAmount;

	public TransactionRequest() {

	}

	public TransactionRequest(CardInfo cardInfo, AcquirerInfo acquirerInfo,
			BigDecimal transactionAmount) {
		super();
		this.cardInfo = cardInfo;
		this.acquirerInfo = acquirerInfo;
		this.transactionAmount = transactionAmount;
	}

	public CardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}

	public AcquirerInfo getAcquirerInfo() {
		return acquirerInfo;
	}

	public void setAcquirerInfo(AcquirerInfo acquirerInfo) {
		this.acquirerInfo = acquirerInfo;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "TransactionRequest [cardInfo=" + cardInfo + ", acquirerInfo="
				+ acquirerInfo + ", transactionAmount=" + transactionAmount
				+ "]";
	}

}
