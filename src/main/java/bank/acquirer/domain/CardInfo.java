package bank.acquirer.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public final class CardInfo {
	
	public static final int LENGTH_PAN = 16;
	public static final int MIN_SECURITY_CODE = 100;
	public static final int MAX_SECURITY_CODE = 999;
	public static final int MIN_HOLDER_NAME = 2; 
	public static final int MAX_HOLDER_NAME = 100; 
	public static final int MIN_EXPIRATION_DATE = 5; 
	public static final int MAX_EXPIRATION_DATE = 10; 
	
	@NotEmpty
	@Length(min = LENGTH_PAN, max = LENGTH_PAN)
	private String pan;
	
	@NotNull
	@Min(value = MIN_SECURITY_CODE)
	@Max(value = MAX_SECURITY_CODE)
	private Integer securityCode;
	
	@NotEmpty
	@Length(min = MIN_HOLDER_NAME, max = MAX_HOLDER_NAME)
	private String holderName;
	
	@NotEmpty
	@Length(min = MIN_EXPIRATION_DATE, max = MAX_EXPIRATION_DATE)
	private String expirationDate;

	public CardInfo() {

	}

	public CardInfo(String pan, int securityCode, String holderName,
			String expirationDate) {
		super();
		this.pan = pan;
		this.securityCode = securityCode;
		this.holderName = holderName;
		this.expirationDate = expirationDate;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Integer getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "CardInfo [pan=" + pan + ", securityCode=" + securityCode
				+ ", holderName=" + holderName + ", expirationDate="
				+ expirationDate + "]";
	}

}
