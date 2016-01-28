package bank.acquirer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("pcc.api")
public class PccApiProperties {

	private String baseUrl;

	private String resourceName;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}
