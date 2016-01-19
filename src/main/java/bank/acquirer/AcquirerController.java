package bank.acquirer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank/acquirer")
public class AcquirerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AcquirerController.class);
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Hello hello() {
    	LOGGER.info("Invoked hello method");
    	
    	return new Hello(1, "Hello from acquirer bank!");
    }
}
