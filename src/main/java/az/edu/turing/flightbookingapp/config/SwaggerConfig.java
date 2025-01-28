package az.edu.turing.flightbookingapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Flight Booking Application API")
                        .version("1.0.0")
                        .description("This API provides functionalities for flight booking application, including user authentication, flight management, and booking operations."));
    }
}
