package com.geralexcas.gutendexlitelatura;

import com.geralexcas.gutendexlitelatura.principal.Principal;
import com.geralexcas.gutendexlitelatura.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GutendexlitelaturaApplication  implements CommandLineRunner {
	@Autowired
	private IAutorRepository repository;
	public static void main(String[] args) {SpringApplication.run(GutendexlitelaturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraElMenu();

	}
}
