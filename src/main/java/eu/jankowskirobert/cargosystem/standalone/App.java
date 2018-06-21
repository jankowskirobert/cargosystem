package eu.jankowskirobert.cargosystem.standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("eu.jankowskirobert.cargosystem.infrastructure")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
