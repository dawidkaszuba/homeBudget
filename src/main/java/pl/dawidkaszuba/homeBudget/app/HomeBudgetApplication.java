package pl.dawidkaszuba.homeBudget.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"pl.dawidkaszuba"})
//@EnableTransactionManagement
@EntityScan(basePackages = "pl.dawidkaszuba.homeBudget.entity")
@EnableJpaRepositories(basePackages = "pl.dawidkaszuba.homeBudget.repository")
public class HomeBudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBudgetApplication.class, args);
	}

}
