package edu.basic.preparation;

import edu.basic.preparation.service.DependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kartik mahaley
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private DependencyService dependencyService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        dependencyService.listFunctionality();
    }


}
