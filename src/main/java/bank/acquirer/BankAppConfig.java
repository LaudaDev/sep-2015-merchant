package bank.acquirer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import bank.acquirer.config.PccApiProperties;

/**
 * This configuration class has three responsibilities:
 * <ol>
 *     <li>It enables the auto configuration of the Spring application context.</li>
 *     <li>
 *         It ensures that Spring looks for other components (controllers, services, and repositories) from the
 *         <code>bank.acquirer</code> package.
 *     </li>
 *     <li>It launches the application in the main() method.</li>
 * </ol>
 * @author Dalibor Pavicic
 */
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(PccApiProperties.class)
@ComponentScan
public class BankAppConfig {
	
	public static void main(String[] args) {
		SpringApplication.run(BankAppConfig.class, args);
	}
}
