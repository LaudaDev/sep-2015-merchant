package bank.acquirer.dto;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import bank.acquirer.domain.AcquirerInfo;
import bank.acquirer.domain.CardInfo;

public final class TransactionRequestDTO {
	
	@NotNull
	@Valid
	private CardInfo cardInfo;
	
	@NotNull
	@Valid
	private AcquirerInfo acquirerInfo;
	
	@NotNull
	private BigDecimal transactionAmount;

	public TransactionRequestDTO() {

	}

	public TransactionRequestDTO(CardInfo cardInfo, AcquirerInfo acquirerInfo,
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
