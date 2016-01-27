package bank.acquirer.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public final class AcquirerInfo {

	private Long orderId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "CET")
	private Date timestamp;

	public AcquirerInfo() {

	}

	public AcquirerInfo(Long orderId, Date timestamp) {
		super();
		this.orderId = orderId;
		this.timestamp = timestamp;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "AcquirerInfo [orderId=" + orderId + ", timestamp=" + timestamp
				+ "]";
	}

}
