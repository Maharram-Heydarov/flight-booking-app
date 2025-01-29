package az.edu.turing.flightbookingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Configuration
@ComponentScan(basePackages = "az.edu.turing.flightbookingapp")
@EnableJpaRepositories("az.edu.turing.flightbookingapp.repository")
@ServletComponentScan
public class AppConfig {

    @Bean
    public MyCustomBean myCustomBean() {
        return new MyCustomBean();
    }
}
