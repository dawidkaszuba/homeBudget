package pl.dawidkaszuba.homeBudget.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"pl.dawidkaszuba"})
@EntityScan(basePackages = "pl.dawidkaszuba.homeBudget.entity")
@EnableJpaRepositories(basePackages = "pl.dawidkaszuba.homeBudget.repository")
public class HomeBudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBudgetApplication.class, args);
	}



}
