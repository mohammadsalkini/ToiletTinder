package at.asd.toilettinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
public class ToiletTinderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToiletTinderApplication.class, args);

    }
}
