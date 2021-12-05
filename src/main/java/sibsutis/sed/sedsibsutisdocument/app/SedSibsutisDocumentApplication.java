package sibsutis.sed.sedsibsutisdocument.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@PropertySource(value = "classpath:sed-document-document.properties", encoding = "UTF-8")
@ComponentScan(basePackages = {"sibsutis.sed.sedsibsutisdocument"})
@EnableJpaRepositories(basePackages = "sibsutis.sed.sedsibsutisdocument.repository")
@EntityScan(basePackages = "sibsutis.sed.sedsibsutisdocument.model.entity")
public class SedSibsutisDocumentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SedSibsutisDocumentApplication.class, args);
	}

}
