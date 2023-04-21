package med.voll.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		//OBS: Atualmente o SpringBoot ja vem com um servidor de aplicacao embutido nas dependencias do modulo WEB, Tomcat eh o padrao
		SpringApplication.run(ApiApplication.class, args);
	}

}
