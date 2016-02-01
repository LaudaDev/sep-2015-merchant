package bank.acquirer.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;

public final class TransactionLog {

	@Id
	private String id;
	
	private Date logDate;
	
	private AcquirerInfo acquirerInfo;
	
	private IssuerInfo issuerInfo;
	
	private TransactionStatus transactionStatus;
	
	private BigDecimal transactionAmount;
	
	public TransactionLog() {}
	
	private TransactionLog(TransactionLogBuilder builder) {
		this.logDate = builder.logDate;
		this.acquirerInfo = builder.acquirerInfo;
		this.issuerInfo = builder.issuerInfo;
		this.transactionStatus = builder.transactionStatus;
		this.transactionAmount = builder.transactionAmount;
	}
	
	public static TransactionLogBuilder getBuilder() {
		return new TransactionLogBuilder();
	}

	public String getId() {
		return id;
	}

	public Date getLogDate() {
		return logDate;
	}

	public AcquirerInfo getAcquirerInfo() {
		return acquirerInfo;
	}

	public IssuerInfo getIssuerInfo() {
		return issuerInfo;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	
	@Override
	public String toString() {
		return "TransactionLog ["
				+ "id=" + id 
				+ ", logDate=" + logDate 
				+ ", acquirerInfo=" + acquirerInfo 
				+ ", issuerInfo=" + issuerInfo
				+ ", transactionStatus=" + transactionStatus 
				+ ", transactionAmount=" + transactionAmount + "]";
	}


	/**
	 * {@link TransactionLog} objects are constructed by using builder pattern which
	 * is useful when class has many attributes. Builder pattern makes object
	 * construction more readable and reduces the errors made by accidentally 
	 * switching constructor parameters.
	 * @author Dalibor Pavicic
	 */
	public static class TransactionLogBuilder {
		
		private Date logDate;
		
		private AcquirerInfo acquirerInfo;
		
		private IssuerInfo issuerInfo;
		
		private TransactionStatus transactionStatus;
		
		private BigDecimal transactionAmount;
		
		private TransactionLogBuilder() {}
		
		public TransactionLogBuilder logDate(Date logDate) {
			this.logDate = logDate;
			return this;
		}
		
		public TransactionLogBuilder acquirerInfo(AcquirerInfo acquirerInfo) {
			this.acquirerInfo = acquirerInfo;
			return this;
		}
		
		public TransactionLogBuilder issuerInfo(IssuerInfo issuerInfo) {
			this.issuerInfo = issuerInfo;
			return this;
		}
		
		public TransactionLogBuilder transactionStatus(TransactionStatus transactionStatus) {
			this.transactionStatus = transactionStatus;
			return this;
		}
		
		public TransactionLogBuilder transactionAmount(BigDecimal transactionAmount) {
			this.transactionAmount = transactionAmount;
			return this;
		}
		
		public TransactionLog build() {
			TransactionLog logToBuild = new TransactionLog(this);
			
			return logToBuild;
		}
	}
}
