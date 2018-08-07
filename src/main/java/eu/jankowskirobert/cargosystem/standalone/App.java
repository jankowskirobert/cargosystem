package eu.jankowskirobert.cargosystem.standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackages = {"eu.jankowskirobert.cargosystem.composite.location","eu.jankowskirobert.cargosystem.composite.cargo"})
@SpringBootApplication
@ComponentScan("eu.jankowskirobert.cargosystem.infrastructure")
public class App {

    public static void main(String[] args) {



        SpringApplication.run(App.class, args);
    }

}
