package bank.acquirer;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(BankAppConfig.class)
@WebAppConfiguration
public class TransactionControllerTests {
		
		@Autowired
		protected WebApplicationContext context;
		
		protected MockMvc mockMvc;
		
		@Before
		public void setUp() {
			this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		}

}
