package io.lgxkdream.servicemiya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@SpringBootApplication
public class ServiceMiyaApplication {

	private static final Logger LOGGER = Logger.getLogger(ServiceMiyaApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ServiceMiyaApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hi")
	public String home() {
		LOGGER.log(Level.INFO, "hi is being called");
		return "hi i'm miya!";
	}

	@RequestMapping("/miya")
	public String info() {
		LOGGER.log(Level.INFO, "info is being called");
		return restTemplate.getForObject("http://localhost:8988/info", String.class);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
