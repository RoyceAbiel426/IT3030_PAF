package springboot.com.example.labsheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class LabsheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabsheetApplication.class, args);
	}

	@GetMapping("/")
	public String rootEndPoint() {
		String message = "hello world";
		return message;
	}
	
	@GetMapping("/greet")
	public String greets() {
		return "Hello, welcome to Spring Boot!";
	}

	
	@GetMapping("/greet/{name}")
	public String welcome(@PathVariable String name, @RequestParam(required = false) String message) {
		if (message != null && !message.isEmpty()) {
			return "Welcome to Spring Boot Lab Sheet, " + name + "! Message: " + message;
		} else {
			return "Welcome to Spring Boot Lab Sheet, " + name + "!";
		}
	}
	
}
