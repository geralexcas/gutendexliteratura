package com.geralexcas.gutendexlitelatura;

import com.geralexcas.gutendexlitelatura.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GutendexlitelaturaApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GutendexlitelaturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();

	}
}
