package bank.acquirer.dto;

import bank.acquirer.domain.AcquirerInfo;
import bank.acquirer.domain.IssuerInfo;
import bank.acquirer.domain.TransactionStatus;

public class TransactionResponseDTO {

	private AcquirerInfo acquirerInfo;

	private IssuerInfo issuerInfo;

	private TransactionStatus transactionStatus;

	public TransactionResponseDTO() {

	}

	public TransactionResponseDTO(AcquirerInfo acquirerInfo,
			IssuerInfo issuerInfo, TransactionStatus transactionStatus) {
		super();
		this.acquirerInfo = acquirerInfo;
		this.issuerInfo = issuerInfo;
		this.transactionStatus = transactionStatus;
	}

	public AcquirerInfo getAcquirerInfo() {
		return acquirerInfo;
	}

	public void setAcquirerInfo(AcquirerInfo acquirerInfo) {
		this.acquirerInfo = acquirerInfo;
	}

	public IssuerInfo getIssuerInfo() {
		return issuerInfo;
	}

	public void setIssuerInfo(IssuerInfo issuerInfo) {
		this.issuerInfo = issuerInfo;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	@Override
	public String toString() {
		return "TransactionResponse [acquirerInfo=" + acquirerInfo
				+ ", issuerInfo=" + issuerInfo + ", transactionStatus="
				+ transactionStatus + "]";
	}

}
