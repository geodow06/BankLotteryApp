package control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import service.AccNumGen;

@RestController
@EnableWebMvc
@RequestMapping
public class AccountNumEndPoint {
	
	private AccNumGen accountGenerator;

	public AccountNumEndPoint(AccNumGen accountGenerator) {
		this.accountGenerator = accountGenerator;
	}

	@GetMapping("/genNum")
	public String generateAccount() {
		return accountGenerator.accountNumberGenerator();
	}
	
}
