# SEP 2015 - Acquirer Bank

Acquirer bank REST api using Spring Boot

##Requirements

   * JDK 8

   * Apache Maven
   
     Download the latest Apache Maven from [http://maven.apache.org](http://maven.apache.org), and uncompress it into your local system. 
    
     Optionally, you can set **M2\_HOME** environment varible, and also do not forget to append *&lt;Maven Installation dir>/bin* your **PATH** environment variable

## Run this project

   1. Clone the codes.

    <pre>
    git clone https://github.com/LaudaDev/sep-acquirer-bank
    </pre>
  
   2. Enter the root folder, run `mvn spring-boot:run` to start up an embedded tomcat to serve this application or you can build the JAR file with `mvn clean package` and run the JAR by typing:
  
    <pre>
    java -jar target/bank-acquirer-rest-0.1.0.jar
    </pre>
## API URLs

- baseUrl: *https://host:port/api/bank/acquirer*
- Supported HTTP methods:
  * POST _baseUrl/auth_
    - Request body format example:
  ```json
  	    {
		    "cardInfo": {
		       "pan": "1111111111111111",
		       "securityCode": "111",
		       "holderName": "Card 1",
		       "expirationDate": "11/17"
		    },
		 
		    "acquirerInfo": {
		       "orderId": "1",
		       "timestamp": "25.01.2016 17:36:33"
		    },
		 
		    "transactionAmount": "7500"
		}
  ```
    - Expected response:
  ```json
	    {
		    "acquirerInfo": {
		        "orderId": 1,
		        "timestamp": "25.01.2016 17:36:33"
		    },
		    "issuerInfo": {
		        "orderId": 13,
		        "timestamp": "28.01.2016 23:52:53"
		    },
		    "transactionStatus": {
		        "code": "00",
		        "message": "TRANSACTION_COMPLETED"
		    }
	    }  
  ```




