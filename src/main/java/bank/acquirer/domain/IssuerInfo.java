package bank.acquirer.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public final class IssuerInfo {

	@NotNull
	private Integer orderId;

	@JsonFormat(
			shape = JsonFormat.Shape.STRING, 
			pattern = "dd.MM.yyyy HH:mm:ss", 
			timezone = "CET")
	private Date timestamp;

	public IssuerInfo() {

	}

	public IssuerInfo(Integer orderId, Date timestamp) {
		super();
		this.orderId = orderId;
		this.timestamp = timestamp;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
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
		return "IssuerInfo [orderId=" + orderId + ", timestamp=" + timestamp + "]";
	}

}
